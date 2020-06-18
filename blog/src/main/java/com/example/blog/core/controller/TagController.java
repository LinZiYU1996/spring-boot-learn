package com.example.blog.core.controller;

import com.example.blog.common.component.Result;
import com.example.blog.common.validator.ValidatorUtils;
import com.example.blog.core.entity.TagEntity;
import com.example.blog.core.entity.VblogTag;
import com.example.blog.core.service.IVblogArticleTagService;
import com.example.blog.core.service.IVblogTagService;
import com.example.blog.core.vo.TagVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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


    //  查询标签详情
    @GetMapping("/detail")
    public Result detail() {
        log.info(" TagController  detail");
        List<TagVo> tagVos = tagService.queryTagDetails();
        return Result.ok(tagVos);
    }


    // 单条标签详情
    @GetMapping("/detail/{tagId}")
    public Result detailById(@PathVariable("tagId") Integer tagId) {
        log.info(" TagController/detail/{tagId} ");
        TagVo tagVo = tagService.queryOneTagDetail(tagId);
        return Result.ok(tagVo);
    }

    // 保存

    @RequestMapping("/save")
    public Result save(@RequestBody VblogTag tag) {
        tagService.insert(tag);

        return Result.ok();
    }

    // 修改

    @RequestMapping("/update")
    public Result update(@RequestBody VblogTag tag) {
        ValidatorUtils.validateEntity(tag);
        //全部更新
        tagService.updateAllColumnById(tag);

        return Result.ok();
    }


    //删除
    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids) {
        tagService.deleteBatchIds(Arrays.asList(ids));

        return Result.ok();
    }

}
