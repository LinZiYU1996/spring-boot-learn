package com.example.blog.core.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.blog.core.dto.ChildCommentDto;
import com.example.blog.core.entity.VblogComment;
import com.example.blog.core.vo.CommentVo;

import java.util.List;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface VblogCommentMapper extends BaseMapper<VblogComment> {


    //  获取文章评论信息
    List<CommentVo> queryArticleComments(Long articleId);


    // 获取子评论信息

    List<CommentVo> queryChildrenComments(ChildCommentDto dto);
}
