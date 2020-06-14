package com.example.blog.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.blog.common.component.Result;
import com.example.blog.core.entity.ArticleEntity;
import com.example.blog.core.entity.VblogArticle;
import com.example.blog.core.service.IVblogArticleService;
import com.example.blog.core.vo.ArticleArchivesVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/12
 * \* Time: 9:13
 * \* Description:
 * \
 */

@RestController
@RequestMapping("/article")
@CrossOrigin
@Slf4j
public class ArticleController {
    public static final int HOT_OR_NEW_ARTICLE_NUM = 6;
    public static final int ARTICLE_ARCHIVE_LIMIT_NUM = 8;

    @Autowired
    private IVblogArticleService articleService;


    // 针对文章 分页查询
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("sidx", "view_num");
        params.put("order", "DESC");

        List<VblogArticle> list = articleService.queryPage(params);
        JSONArray array = articleService.getFormatArticleList(list);
        return Result.ok(array);
    }


    //最热文章
    @GetMapping("/hot")
    public Result listHotArticles() {
        JSONArray array = getHotOrNewArticles("view_num");
        return Result.ok(array);
    }


    //最新文章
    @GetMapping("/new")
    public Result listNewArticles() {
        JSONArray array = getHotOrNewArticles("create_time");
        return Result.ok(array);
    }

    //获取最热或最新文章
    //type 可取 view_num 最热
    //create_time 最新
    private JSONArray getHotOrNewArticles(String type) {
        Page<VblogArticle> page = new Page<>(1, HOT_OR_NEW_ARTICLE_NUM);
        page.setOrderByField(type);
        page.setAsc(false);

        Page<VblogArticle> pageList = articleService.selectPage(page, new EntityWrapper<VblogArticle>());

        JSONArray array = new JSONArray();
        for (VblogArticle article : pageList.getRecords()) {
            JSONObject object = new JSONObject();
            object.put("id", article.getId());
            object.put("title", article.getTitle());
            array.add(object);
        }
        return array;
    }


    //查看文章详情时：
    //     * 获取文章详情
    //     * 包含作者信息
    // 要增加文章阅读数
    @GetMapping("/view/{id}")
    public Result oneArticleInfo(@PathVariable("id") Long id) {
        log.info("oneArticleInfo 查看文章详情时  ");
        JSONObject detailAndAddViewNum = articleService.getArticleDetailAndAddViewNum(id);
        return Result.ok(detailAndAddViewNum);
    }


    //发布文章按年-月汇总
    //汇总查询
    @GetMapping("/archives")
    public Result archives() {
        List<ArticleArchivesVo> archivesVos = articleService.queyArticleArchives(ARTICLE_ARCHIVE_LIMIT_NUM);
        return Result.ok(archivesVos);
    }
}
