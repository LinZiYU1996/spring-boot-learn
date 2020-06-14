package com.example.blog.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.blog.core.dto.ChildCommentDto;
import com.example.blog.core.entity.VblogComment;
import com.example.blog.core.vo.CommentVo;
;import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface IVblogCommentService extends IService<VblogComment> {


    // 获取文章评论信息
    List<CommentVo> queryArticleComments(Long articleId);


    // 获取子评论信息

    List<CommentVo> queryChildrenComments(ChildCommentDto dto);


}
