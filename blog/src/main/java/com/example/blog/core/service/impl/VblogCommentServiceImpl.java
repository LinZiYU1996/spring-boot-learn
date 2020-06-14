package com.example.blog.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.dto.ChildCommentDto;
import com.example.blog.core.entity.VblogComment;
import com.example.blog.core.mapper.VblogCommentMapper;
import com.example.blog.core.service.IVblogCommentService;
import com.example.blog.core.vo.CommentVo;
import org.springframework.stereotype.Service;

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
}
