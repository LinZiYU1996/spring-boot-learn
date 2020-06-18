package com.example.blog.core.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.entity.VblogTag;
import com.example.blog.core.mapper.VblogTagMapper;
import com.example.blog.core.service.IVblogTagService;
import com.example.blog.core.vo.TagVo;
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


    // 查询单条标签详情

    @Override
    public TagVo queryOneTagDetail(Integer tagId) {
        return this.baseMapper.queryOneTagDetail(tagId);
    }

    @Override
    public List<TagVo> queryTagDetails() {
        return this.baseMapper.queryTagDetails();
    }
}
