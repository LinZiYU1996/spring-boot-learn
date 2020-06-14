package com.example.blog.core.controller;

import com.example.blog.common.component.Result;
import com.example.blog.core.entity.TagEntity;
import com.example.blog.core.entity.VblogTag;
import com.example.blog.core.service.IVblogArticleTagService;
import com.example.blog.core.service.IVblogTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/13
 * \* Time: 9:16
 * \* Description:
 * \
 */

@RestController
@RequestMapping("/tags")
@Slf4j
@CrossOrigin
public class TagController {

    public static final int HOT_ARTICLE_TAG_NUM = 4;

    @Autowired
    private IVblogTagService tagService;


    @Autowired
    private IVblogArticleTagService articleTagService;
    // 获取所有标签
    @GetMapping("/list")
    public Result list() {
        List<VblogTag> tagEntities = tagService.selectList(null);
        return Result.ok(tagEntities);
    }


    //获取热门标签

    @GetMapping("/hot")
    public Result hot() {
        List<Integer> tagIds = articleTagService.queryHotTagIds(HOT_ARTICLE_TAG_NUM);
        log.info("tagIds.size()={} {}", tagIds.size(), tagIds.toString());
        Integer[] tagIdsArray = new Integer[tagIds.size()];
        /*for (int i = 0; i < tagIds.size(); i++) {
            tagIdsArray[i] = tagIds.get(i);
        }*/
        List<VblogTag> tagEntities = tagService.queryHotTagDetails(tagIds.toArray(tagIdsArray));
        return Result.ok(tagEntities);
    }

}
