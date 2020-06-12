package com.test.generator.service.impl;

import com.test.generator.entity.VblogCategory;
import com.test.generator.mapper.VblogCategoryMapper;
import com.test.generator.service.IVblogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章类别表 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
@Service
public class VblogCategoryServiceImpl extends ServiceImpl<VblogCategoryMapper, VblogCategory> implements IVblogCategoryService {

}
