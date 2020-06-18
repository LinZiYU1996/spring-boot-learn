package com.example.blog.core.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.IService;
import com.example.blog.core.entity.ArticleEntity;
import com.example.blog.core.entity.VblogArticle;
import com.example.blog.core.entity.VblogUser;
import com.example.blog.core.vo.ArticleArchivesVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface IVblogArticleService extends IService<VblogArticle> {


    List<VblogArticle> queryPage(Map<String, Object> params);


    JSONArray getFormatArticleList(List<VblogArticle> list);


    //根据id获取文章，添加阅读数
    JSONObject getArticleDetailAndAddViewNum(Long articleId);


    //发布文章按年-月汇总
    List<ArticleArchivesVo> queyArticleArchives(int limit);


    // 添加一篇新文章
    Long  addOneArticle(VblogUser userEntity, JSONObject json);


    // 更新一篇文章

    Long updateOneArticle(VblogUser userEntity, VblogArticle article, JSONObject json);


}
