package com.example.blog.core.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.common.exception.RestException;
import com.example.blog.common.utils.Query;
import com.example.blog.core.entity.ArticleEntity;
import com.example.blog.core.entity.VblogArticle;
import com.example.blog.core.mapper.VblogArticleMapper;
import com.example.blog.core.service.IVblogArticleService;
import com.example.blog.core.vo.ArticleArchivesVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

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
            object.put("tags", article.getTags());
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



        // 5、文章阅读数 + 1
        this.updateById(article);


        return object;
    }


    @Override
    public List<ArticleArchivesVo> queyArticleArchives(int limit) {
        return this.baseMapper.queyArticleArchives(limit);
    }
}
