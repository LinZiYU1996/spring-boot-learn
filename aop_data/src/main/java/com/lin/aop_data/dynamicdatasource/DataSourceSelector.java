package com.lin.aop_data.dynamicdatasource;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSourceSelector {

    /**
     * 为了可以方便切换数据源，我们可以写一个注解，注解中包含数据源对应的枚举值，默认是主库，
     *
     *
     */


    DynamicDataSourceEnum value() default DynamicDataSourceEnum.MASTER;

    boolean clear() default true;

}
