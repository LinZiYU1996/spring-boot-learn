package com.example.blog.core.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.blog.core.entity.TagEntity;
import com.example.blog.core.entity.VblogTag;

import java.util.List;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public interface IVblogTagService extends IService<VblogTag> {


    // 获取标签详情

    List<VblogTag> queryHotTagDetails(Integer[] tagIds);

}
