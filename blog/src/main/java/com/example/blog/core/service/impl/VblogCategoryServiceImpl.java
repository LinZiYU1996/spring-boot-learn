package com.example.blog.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.entity.VblogCategory;
import com.example.blog.core.mapper.VblogCategoryMapper;
import com.example.blog.core.service.IVblogCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章类别表 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
@Service
public class VblogCategoryServiceImpl extends ServiceImpl<VblogCategoryMapper, VblogCategory> implements IVblogCategoryService {

}
