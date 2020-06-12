package com.example.blog.core.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.entity.VblogArticle;
import com.example.blog.core.mapper.VblogArticleMapper;
import com.example.blog.core.service.IVblogArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
@Service
public class VblogArticleServiceImpl extends ServiceImpl<VblogArticleMapper, VblogArticle> implements IVblogArticleService {

}
