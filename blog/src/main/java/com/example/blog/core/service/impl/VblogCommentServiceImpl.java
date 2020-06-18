package com.example.blog.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.dto.AuthorDto;
import com.example.blog.core.dto.ChildCommentDto;
import com.example.blog.core.entity.CommentEntity;
import com.example.blog.core.entity.VblogArticle;
import com.example.blog.core.entity.VblogComment;
import com.example.blog.core.entity.VblogUser;
import com.example.blog.core.mapper.VblogCommentMapper;
import com.example.blog.core.service.IVblogArticleService;
import com.example.blog.core.service.IVblogCommentService;
import com.example.blog.core.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
@Service
public class VblogCommentServiceImpl extends ServiceImpl<VblogCommentMapper, VblogComment> implements IVblogCommentService {


    @Autowired
    private IVblogArticleService articleService;
    // 获取文章评论信息
    @Override
    public List<CommentVo> queryArticleComments(Long articleId) {
        return this.baseMapper.queryArticleComments(articleId);
    }


    // 获取子评论信息
    @Override
    public List<CommentVo> queryChildrenComments(ChildCommentDto dto) {
        return this.baseMapper.queryChildrenComments(dto);
    }



    // 发布文章评论


    @Override
    public JSONObject publishArticleComment(VblogArticle articleEntity, VblogUser userEntity, JSONObject json) {
        // 1、更新文章评论数+1
        articleEntity.setCommentNum(articleEntity.getCommentNum() + 1);
        articleService.updateById(articleEntity);

        // 2、插入一条文章评论
        VblogComment comment = new VblogComment();
        comment.setArticleId(articleEntity.getId());
        comment.setContent(json.getString("content"));
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        comment.setUserId(userEntity.getId());

        // 3、设置文章评论级别 level_flag
        //    为0:评论文章;1:评论某人评论;2:回复某人评论
        JSONObject parent = json.getJSONObject("parent");
        JSONObject toUser = json.getJSONObject("toUser");
        if (parent != null) {
            comment.setParentId(parent.getLong("id"));
            if (toUser != null) {
                comment.setLevelFlag("2");
                comment.setToUid(toUser.getLong("id"));
            } else {
                comment.setLevelFlag("1");
            }
        } else {
            comment.setLevelFlag("0");
        }
        this.insert(comment);

        // 4、返回评论数据
        JSONObject object = new JSONObject();
        object.put("id", comment.getId());
        object.put("level", comment.getLevelFlag());
        object.put("content", comment.getContent());
        object.put("createDate", comment.getCreateTime().getTime());
        object.put("author", new AuthorDto(comment.getUserId(), userEntity.getAvatar(), userEntity.getNickname()));
        if (toUser != null) {
            object.put("toUser", toUser);
        }
        if (parent != null) {
            object.put("parent", parent);
        }

        return object;    }
}
