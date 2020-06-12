package com.test.generator.service.impl;

import com.test.generator.entity.VblogComment;
import com.test.generator.mapper.VblogCommentMapper;
import com.test.generator.service.IVblogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
