package com.example.blog.core.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.entity.VblogTag;
import com.example.blog.core.mapper.VblogTagMapper;
import com.example.blog.core.service.IVblogTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
@Service
public class VblogTagServiceImpl extends ServiceImpl<VblogTagMapper, VblogTag> implements IVblogTagService {


    @Override
    public List<VblogTag> queryHotTagDetails(Integer[] tagIds) {
        if (tagIds == null || tagIds.length <= 0){
            return this.selectList(null);
        } else {
            return this.baseMapper.queryHotTagDetails(tagIds);
        }
    }
}
