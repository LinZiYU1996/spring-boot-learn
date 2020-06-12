package com.example.blog.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.entity.VblogComment;
import com.example.blog.core.mapper.VblogCommentMapper;
import com.example.blog.core.service.IVblogCommentService;
import org.springframework.stereotype.Service;

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

}
