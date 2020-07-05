package com.lin.aop_data.dynamicdatasource;


import lombok.Getter;

@Getter
public enum DynamicDataSourceEnum {

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
