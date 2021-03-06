package com.lin.aop_data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.aop_data.dynamicdatasource.DataSourceSelector;
import com.lin.aop_data.dynamicdatasource.DynamicDataSourceEnum;
import com.lin.aop_data.entity.Adddress;
import com.lin.aop_data.mapper.AdddressMapper;
import com.lin.aop_data.service.IAdddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-07-05
 */
@Service
public class AdddressServiceImpl extends ServiceImpl<AdddressMapper, Adddress> implements IAdddressService {

    @Autowired
    private AdddressMapper adddressMapper;


    @Override
    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public List<Adddress> getAll() {
        return adddressMapper.getAll();
    }
}
