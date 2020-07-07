package com.lin.aop_data.dynamicdatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/4
 * \* Time: 20:51
 * \* Description:
 * \
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 获取路由
     * AbstractRoutingDataSource的作用是基于查找key路由到对应的数据源，它内部维护了一组目标数据源，
     * 并且做了路由key与目标数据源之间的映射，提供基于key查找数据源的方法
     *
     */


    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }

}
