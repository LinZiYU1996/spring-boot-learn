package com.lin.aop_data.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.aop_data.dynamicdatasource.DataSourceSelector;
import com.lin.aop_data.dynamicdatasource.DynamicDataSourceEnum;
import com.lin.aop_data.entity.Adddress;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lin
 * @since 2020-07-05
 */
public interface IAdddressService extends IService<Adddress> {


    List<Adddress> getAll();


}
