package com.example.blog.core.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.blog.core.entity.VblogCategory;
import com.example.blog.core.vo.CategoryVo;

import java.util.List;

/**
 * <p>
 * 文章类别表 Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface VblogCategoryMapper extends BaseMapper<VblogCategory> {

    // 文章分类详情
    List<CategoryVo> queryCategoryDetails();


    // 单条文章分类详情

    CategoryVo queryOneCategoryDetail(Integer categoryId);


}
