package com.example.blog.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.entity.VblogCategory;
import com.example.blog.core.mapper.VblogCategoryMapper;
import com.example.blog.core.service.IVblogCategoryService;
import com.example.blog.core.vo.CategoryVo;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public List<CategoryVo> queryCategoryDetails() {
        return this.baseMapper.queryCategoryDetails();

    }

    @Override
    public CategoryVo queryOneCategoryDetail(Integer categoryId) {
        return this.baseMapper.queryOneCategoryDetail(categoryId);
    }
}
