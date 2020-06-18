package com.example.blog.core.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.common.exception.RestException;
import com.example.blog.common.utils.Query;
import com.example.blog.core.entity.*;
import com.example.blog.core.mapper.VblogArticleMapper;
import com.example.blog.core.service.*;
import com.example.blog.core.vo.ArticleArchivesVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
@Service
public class VblogArticleServiceImpl extends ServiceImpl<VblogArticleMapper, VblogArticle> implements IVblogArticleService {



    @Autowired
    private IVblogUserService userService;

    @Autowired
    private IVblogCategoryService categoryService;

    @Autowired
    private IVblogArticleTagService articleTagService;

    @Autowired
    private IVblogTagService tagService;

    @Override
    public List<VblogArticle> queryPage(Map<String, Object> params) {
        EntityWrapper<VblogArticle> entityEntityWrapper = new EntityWrapper<>();

        String categoryIdStr = (String) params.get("categoryId");

        if (StringUtils.isNotBlank(categoryIdStr)){
            Integer categoryId = Integer.parseInt(categoryIdStr);
            entityEntityWrapper.eq("category_id", categoryId);
        }

        String year = (String) params.get("year");
        String month = (String) params.get("month");
        if (StringUtils.isNotBlank(year) && StringUtils.isNotBlank(month)) {
            entityEntityWrapper.eq("year(create_time)", year);
            entityEntityWrapper.eq("month(create_time)", month);
        }


        Page<VblogArticle> page = this.selectPage(
                new Query<VblogArticle>(params).getPage(),
                entityEntityWrapper
        );

        return page.getRecords();
    }


    //格式化文章列表输出


    @Override
    public JSONArray getFormatArticleList(List<VblogArticle> list) {
        JSONArray array = new JSONArray();
        for (VblogArticle article :list) {
            JSONObject object = new JSONObject();
            object.put("id", article.getId());
            object.put("nickname", article.getNickname());
            object.put("title", article.getTitle());
            object.put("summary", article.getSummary());
            object.put("weight", article.getWeight());
            object.put("tags", article.getTagArray());   // 返回string 数组
            object.put("createTime", article.getCreateTime());
            object.put("viewNum", article.getViewNum());
            object.put("commentNum", article.getCommentNum());

            array.add(object);
        }
        return array;
    }


    //根据id获取文章，添加阅读数

    @Override
    public JSONObject getArticleDetailAndAddViewNum(Long articleId) {

        VblogArticle article = this.selectById(articleId);
        if (article == null) {
            throw new RestException("该文章不存在");
        }

        JSONObject object = new JSONObject();
        // 1、文章详情
        object.put("id", article.getId());
        object.put("title", article.getTitle());
        object.put("summary", article.getSummary());
        object.put("createTime", article.getCreateTime());

        article.setViewNum(article.getViewNum() + 1);
        object.put("viewNum", article.getViewNum());
        object.put("commentNum", article.getCommentNum());
        object.put("content", article.getContent());

        // 2、文章作者信息
        VblogUser userEntity = userService.selectById(article.getUserId());
        JSONObject user = new JSONObject();
        user.put("id", userEntity.getId());
        user.put("avatar", userEntity.getAvatar());
        user.put("nickname", userEntity.getNickname());
        object.put("author", user);

        // 3、文章所属分类信息
        VblogCategory categoryEntity = categoryService.selectById(article.getCategoryId());
        object.put("category", categoryEntity);

        // 4、文章所属标签信息
        List<VblogTag> tagEntities = articleTagService.queryArticleTags(article.getId());
        object.put("tags", tagEntities);

        // 5、文章阅读数 + 1
        this.updateById(article);

        return object;
    }


    @Override
    public List<ArticleArchivesVo> queyArticleArchives(int limit) {
        return this.baseMapper.queyArticleArchives(limit);
    }


    // 添加一篇新文章

    @Override
    public Long addOneArticle(VblogUser userEntity, JSONObject json) {
        Map<Integer, String> maps = getTagMapInfos();

        // 1、保存文章信息
        VblogArticle article = new VblogArticle();
        article.setUserId(userEntity.getId());
        article.setNickname(userEntity.getNickname());
        article.setCommentNum(0);
        article.setViewNum(0);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setWeight(0);
        article.setTitle(json.getString("title"));
        article.setSummary(json.getString("summary"));

        JSONObject body = json.getJSONObject("body");
        article.setContent(body.getString("content"));
        article.setContentHtml(body.getString("contentHtml"));

        // 2、设置分类信息
        JSONObject category = json.getJSONObject("category");
        article.setCategoryId(category.getInteger("id"));

        // 3、设置标签信息
        JSONArray tags = json.getJSONArray("tags");
        StringBuilder tagStr = new StringBuilder();
        for (int i = 0; i < tags.size(); i++ ) {
            Integer tagId = tags.getJSONObject(i).getInteger("id");
            if (i != 0){
                tagStr.append(",");
            }
            tagStr.append(maps.get(tagId));
        }
        article.setTags(tagStr.toString());

        // 4、插入文章信息
        this.insert(article);
        Long id = article.getId();

        // 5、插入文章对应的标签信息
        List<VblogArticleTag> articleTagEntityList = new ArrayList<>();
        for (int i = 0; i < tags.size(); i++ ) {
            Integer tagId = tags.getJSONObject(i).getInteger("id");
            VblogArticleTag articleTagEntity = new VblogArticleTag();
            articleTagEntity.setArticleId(id);
            articleTagEntity.setTagId(tagId);
            articleTagEntity.setCreateTime(new Date());
            articleTagEntity.setUpdateTime(new Date());
            articleTagEntityList.add(articleTagEntity);
        }
        articleTagService.insertBatch(articleTagEntityList);

        return id;
    }


    // 获取标签Map数据
    private  Map<Integer, String> getTagMapInfos() {
        List<VblogTag> tagEntities = tagService.selectList(null);
        Map<Integer, String> map = new HashMap<>();
        for (VblogTag tag: tagEntities){
            map.put(tag.getId(), tag.getTagName());
        }
        return map;
    }



    // 更新一篇文章
    @Override
    public Long updateOneArticle(VblogUser userEntity, VblogArticle article, JSONObject json) {
        Long id = article.getId();
        Map<Integer, String> map = getTagMapInfos();

        // 1、更新文章信息
        article.setTitle(json.getString("title"));
        article.setSummary(json.getString("summary"));

        JSONObject body = json.getJSONObject("body");
        article.setContent(body.getString("content"));
        article.setContentHtml(body.getString("contentHtml"));

        JSONObject category = json.getJSONObject("category");
        if (article.getCategoryId().intValue() != category.getInteger("id").intValue()) {
            article.setCategoryId(category.getInteger("id"));
        }

        // 2、获取文章对应的标签信息
        List<VblogArticleTag> articleTagEntityList = new ArrayList<>();
        StringBuilder tagStr = new StringBuilder();
        JSONArray tags = json.getJSONArray("tags");
        for (int i = 0; i < tags.size(); i++ ) {
            Integer tagId = tags.getJSONObject(i).getInteger("id");
            if (i != 0){
                tagStr.append(",");
            }
            tagStr.append(map.get(tagId));

            VblogArticleTag articleTagEntity = new VblogArticleTag();
            articleTagEntity.setArticleId(id);
            articleTagEntity.setTagId(tagId);
            articleTagEntity.setCreateTime(new Date());
            articleTagEntity.setUpdateTime(new Date());
            articleTagEntityList.add(articleTagEntity);
        }
        article.setTags(tagStr.toString());

        article.setUpdateTime(new Date());
        article.setUserId(userEntity.getId());
        article.setNickname(userEntity.getNickname());
        this.updateById(article);

        // 3、删除之前的文章标签信息
        EntityWrapper<VblogArticleTag> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("article_id", id);
        articleTagService.delete(entityWrapper);

        // 4、更新文章标签信息
        articleTagService.insertBatch(articleTagEntityList);

        return id;
    }
}
