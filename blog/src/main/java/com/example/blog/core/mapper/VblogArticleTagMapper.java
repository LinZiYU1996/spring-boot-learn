package com.example.blog.core.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.blog.core.entity.VblogArticleTag;
import com.example.blog.core.entity.VblogTag;

import java.util.List;

/**
 * <p>
 * 文章标签表 Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface VblogArticleTagMapper extends BaseMapper<VblogArticleTag> {


    // 查询最热标签

    List<Integer> queryHotTagIds(Integer limit);

    // 获取文章所有标签
    List<VblogTag> queryArticleTags(Long articleId);


}
