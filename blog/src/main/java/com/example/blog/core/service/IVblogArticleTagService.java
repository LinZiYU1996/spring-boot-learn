package com.example.blog.core.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.blog.core.entity.VblogArticleTag;

import java.util.List;

/**
 * <p>
 * 文章标签表 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface IVblogArticleTagService extends IService<VblogArticleTag> {



    // 查询最热标签
    List<Integer> queryHotTagIds(Integer limit);

}
