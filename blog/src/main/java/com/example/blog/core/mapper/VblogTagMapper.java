package com.example.blog.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.blog.core.entity.TagEntity;
import com.example.blog.core.entity.VblogTag;

import java.util.List;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface VblogTagMapper extends BaseMapper<VblogTag> {


    // 获取标签详情
    List<VblogTag> queryHotTagDetails(Integer[] tagIds);


}
