package com.example.blog.core.controller;

import com.example.blog.common.component.Result;
import com.example.blog.common.validator.ValidatorUtils;
import com.example.blog.core.entity.CategoryEntity;
import com.example.blog.core.entity.VblogCategory;
import com.example.blog.core.service.IVblogCategoryService;
import com.example.blog.core.vo.CategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/16
 * \* Time: 9:29
 * \* Description:
 * \
 */

@RestController
@RequestMapping("/category")
@CrossOrigin
@Slf4j
public class CategoryController {


    @Autowired
    private IVblogCategoryService categoryService;


    //  列表

    @GetMapping("/list")
    public Result list() {
        List<VblogCategory> categoryEntityList = categoryService.selectList(null);
        return Result.ok(categoryEntityList);
    }


    // 分类详情
    @GetMapping("/detail")
    public Result detail() {
        List<CategoryVo> categoryVos = categoryService.queryCategoryDetails();
        return Result.ok(categoryVos);
    }

    // 单条分类详情
    @GetMapping("/detail/{categoryId}")
    public Result detailById(@PathVariable("categoryId") Integer categoryId) {
        log.info(categoryId + "");
        log.info(" CategoryController/detail/{categoryId ");
        CategoryVo categoryVo = categoryService.queryOneCategoryDetail(categoryId);
        return Result.ok(categoryVo);
    }


    // 保存

    @RequestMapping("/save")
    public Result save(@RequestBody VblogCategory category) {
        categoryService.insert(category);

        return Result.ok();
    }

    // 修改
    @RequestMapping("/update")
    public Result update(@RequestBody VblogCategory category) {
        ValidatorUtils.validateEntity(category);
        //全部更新
        categoryService.updateAllColumnById(category);

        return Result.ok();
    }



    // 删除

    @RequestMapping("/delete")
    public Result delete(@RequestBody Integer[] ids) {
        categoryService.deleteBatchIds(Arrays.asList(ids));

        return Result.ok();
    }

}
