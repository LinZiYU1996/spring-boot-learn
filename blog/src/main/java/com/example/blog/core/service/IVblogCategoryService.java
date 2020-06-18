package com.example.blog.core.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.blog.core.entity.VblogCategory;
import com.example.blog.core.vo.CategoryVo;

import java.util.List;

/**
 * <p>
 * 文章类别表 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface IVblogCategoryService extends IService<VblogCategory> {


    //  文章分类详情
    List<CategoryVo> queryCategoryDetails();


    //  单条文章分类详情

    CategoryVo queryOneCategoryDetail(Integer categoryId);

}
