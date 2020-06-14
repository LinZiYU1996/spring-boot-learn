package com.example.blog;

import com.example.blog.core.entity.VblogTag;
import com.example.blog.core.service.IVblogArticleTagService;
import com.example.blog.core.service.IVblogTagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/13
 * \* Time: 14:57
 * \* Description:
 * \
 */

@SpringBootTest

public class Test_Tags {

    @Autowired
    private IVblogTagService tagService;


    @Autowired
    private IVblogArticleTagService articleTagService;


    @Test
    public void test1() {

        List<VblogTag> tagEntities = tagService.selectList(null);
        for (VblogTag tag : tagEntities ) {
            System.out.println(tag);
        }

        //VblogTag{id=1, tagName=Java, avatar=/tag/java.png, createTime=2018-07-06T14:40:41}
        //VblogTag{id=2, tagName=Spring, avatar=/tag/spring.png, createTime=2018-07-06T14:46:55}
        //VblogTag{id=3, tagName=Hibernate, avatar=/tag/hibernate.svg, createTime=2018-07-06T14:46:55}
        //VblogTag{id=4, tagName=Maven, avatar=/tag/maven.png, createTime=2018-07-06T14:46:55}
        //VblogTag{id=5, tagName=Html, avatar=/tag/html.png, createTime=2018-07-06T14:46:55}
        //VblogTag{id=6, tagName=JavaScript, avatar=/tag/js.png, createTime=2018-07-06T14:46:55}
        //VblogTag{id=7, tagName=Vue, avatar=/tag/vue.png, createTime=2018-07-06T14:46:55}
        //VblogTag{id=8, tagName=Css, avatar=/tag/css.png, createTime=2018-07-06T14:46:55}


    }



    @Test
    public void test2() {

        List<Integer> integers = articleTagService.queryHotTagIds(5);
        System.out.println(integers);
    }


    @Test
    public void test_queryHotTagDetails() {

        List<Integer> integers = articleTagService.queryHotTagIds(5);
        Integer[] tagIdsArray = new Integer[integers.size()];
        List<VblogTag> vblogTags = tagService.queryHotTagDetails(integers.toArray(tagIdsArray));

        for (VblogTag vblogTag : vblogTags) {
            System.out.println(vblogTag);
        }

        //VblogTag{id=7, tagName=Vue, avatar=/tag/vue.png, createTime=2018-07-06T14:46:55}
        //VblogTag{id=6, tagName=JavaScript, avatar=/tag/js.png, createTime=2018-07-06T14:46:55}
        //VblogTag{id=5, tagName=Html, avatar=/tag/html.png, createTime=2018-07-06T14:46:55}
        //VblogTag{id=1, tagName=Java, avatar=/tag/java.png, createTime=2018-07-06T14:40:41}
        //VblogTag{id=8, tagName=Css, avatar=/tag/css.png, createTime=2018-07-06T14:46:55}



    }

}
