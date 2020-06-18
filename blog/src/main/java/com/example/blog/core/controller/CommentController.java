package com.example.blog.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.blog.common.component.Result;
import com.example.blog.common.exception.RestException;
import com.example.blog.common.utils.ShiroUtils;
import com.example.blog.core.dto.AuthorDto;
import com.example.blog.core.dto.ChildCommentDto;
import com.example.blog.core.entity.*;
import com.example.blog.core.service.IVblogArticleService;
import com.example.blog.core.service.IVblogCommentService;
import com.example.blog.core.service.IVblogUserService;
import com.example.blog.core.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.joda.time.DateTime;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/13
 * \* Time: 15:49
 * \* Description:
 * \
 */

@RestController
@RequestMapping("/comments")
@CrossOrigin
@Slf4j
public class CommentController {


    @Autowired
    private IVblogCommentService commentService;


    @Autowired
    private IVblogUserService userService;

    @Autowired
    private IVblogArticleService articleService;


    // 获取某篇文章的评论

    @RequestMapping("/article/{id}")
    public Result info(@PathVariable("id") Long id) {
        log.info(" CommentController   info");
        List<CommentVo> commentVos = commentService.queryArticleComments(id);
        JSONArray array = new JSONArray();
        for (CommentVo vo : commentVos) {
            JSONObject object = formatCommentInfo(vo);

            EntityWrapper<VblogComment> entityWrapper = new EntityWrapper<>();
            entityWrapper.eq("article_id", vo.getArticleId());
            entityWrapper.eq("parent_id", vo.getId());
            int childCount = commentService.selectCount(entityWrapper);
            if (childCount <= 0) {
                object.put("childrens", new JSONArray());
            } else {
                List<CommentVo> commentVoList = commentService.queryChildrenComments(new ChildCommentDto(vo.getArticleId(), vo.getId()));
                object.put("childrens", formatChildCommentInfo(commentVoList));
            }
            array.add(object);
        }

        return Result.ok(array);
    }

    //  格式化评论数据
    private JSONObject formatCommentInfo(CommentVo vo) {
        JSONObject object = new JSONObject();
        object.put("id", vo.getId());
        object.put("level", vo.getLevelFlag());
        object.put("content", vo.getContent());
        object.put("createDate", new DateTime(vo.getCreateTime()).toString("yyyy-MM-dd HH:mm:ss"));
        object.put("author", new AuthorDto(vo.getUserId(), vo.getAvatar(), vo.getNickname()));
        return object;
    }



    // 获取子评论信息

    private JSONArray formatChildCommentInfo(List<CommentVo> commentVoList) {
        JSONArray array = new JSONArray();
        for (CommentVo vo : commentVoList) {
            JSONObject object = formatCommentInfo(vo);
            object.put("childrens", new JSONArray());
            if (vo.getToUid() != null) {
                VblogUser userEntity = userService.selectById(vo.getToUid());
                object.put("toUser", new AuthorDto(userEntity.getId(), userEntity.getAvatar(), userEntity.getNickname()));
            }
            array.add(object);
        }
        return array;
    }

    // 发表评论
    @PostMapping("/create/change")
    public Result save(@RequestBody JSONObject json) {
        VblogUser userEntity = ShiroUtils.getUserEntity();

        Long articleId = json.getJSONObject("article").getLong("id");
        VblogArticle articleEntity = articleService.selectById(articleId);
        if (articleEntity == null) {
            throw new RestException("参数有误");
        }
        JSONObject object = commentService.publishArticleComment(articleEntity, userEntity, json);

        return Result.ok(object);
    }



}
