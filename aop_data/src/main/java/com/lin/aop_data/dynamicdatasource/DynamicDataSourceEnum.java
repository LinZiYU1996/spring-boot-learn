package com.lin.aop_data.dynamicdatasource;


import lombok.Getter;

@Getter
public enum DynamicDataSourceEnum {
/**
 * 有一主一从两个数据源，我们用枚举类来代替，方便我们使用时能对应
 *
 */


    /**
     * 主库
     */
    MASTER("master"),
    /**
     * 从库
     */
    SLAVE("slave");

    private String dataSourceName;

    DynamicDataSourceEnum(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }


}
