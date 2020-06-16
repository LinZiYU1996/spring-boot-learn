package com.example.blog.core.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.core.entity.VblogArticleTag;
import com.example.blog.core.entity.VblogTag;
import com.example.blog.core.mapper.VblogArticleTagMapper;
import com.example.blog.core.service.IVblogArticleTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章标签表 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
@Service
public class VblogArticleTagServiceImpl extends ServiceImpl<VblogArticleTagMapper, VblogArticleTag> implements IVblogArticleTagService {

    @Override
    public List<Integer> queryHotTagIds(Integer limit) {
        List<Integer> hotTagIds = this.baseMapper.queryHotTagIds(limit);
        return hotTagIds;
    }

    // 获取文章所有标签

    @Override
    public List<VblogTag> queryArticleTags(Long articleId) {
        return this.baseMapper.queryArticleTags(articleId);
    }
}
