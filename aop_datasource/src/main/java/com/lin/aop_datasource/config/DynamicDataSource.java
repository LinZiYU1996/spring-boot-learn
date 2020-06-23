package com.lin.aop_datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/21
 * \* Time: 16:00
 * \* Description:
 * \
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为"+DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }

}