package com.example.blog;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.blog.core.entity.VblogArticle;
import com.example.blog.core.mapper.VblogArticleMapper;
import com.example.blog.core.service.IVblogArticleService;
import com.example.blog.core.vo.ArticleArchivesVo;
import org.apache.velocity.util.introspection.Uberspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/12
 * \* Time: 10:20
 * \* Description:
 * \
 */

@SpringBootTest

public class TestArticle {

    @Autowired
    private IVblogArticleService articleService;

    @Autowired
    private VblogArticleMapper vblogArticleMapper;


    @Test
    public void Test_queryPage() {

        Map<String, Object> params = new HashMap<>();

        params.put("sidx", "view_num");
        params.put("order", "DESC");
        params.put("pageSize", "10");
        params.put("pageNo", "1");
        params.put("sort", "desc");

        List<VblogArticle> articles = articleService.queryPage(params);

        for (VblogArticle article : articles) {
            System.out.println(article.toString());
        }

    }


    @Test
    public void Test_listHotArticles() {

        Page<VblogArticle> page = new Page<>(1, 6);
        page.setOrderByField("view_num");
        page.setAsc(false);

        Page<VblogArticle> pageList = articleService.selectPage(page, new EntityWrapper<VblogArticle>());

        List<VblogArticle> articles = pageList.getRecords();
        for (VblogArticle article : articles) {
            System.out.println(article.toString());
        }

    }


    @Test
    public void Test_getArticleDetailAndAddViewNum() {

            articleService.getArticleDetailAndAddViewNum(1L);
    }



    @Test
    public void  Test_ArticleArchivesVo() {

        List<ArticleArchivesVo> q =  vblogArticleMapper.queyArticleArchives(8);

        for (ArticleArchivesVo v : q) {
            System.out.println(q);
        }
    }




}
