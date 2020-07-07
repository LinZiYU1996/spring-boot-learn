package com.lin.aop_data.dynamicdatasource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/4
 * \* Time: 20:51
 * \* Description:
 * \
 */
public class DataSourceContextHolder {

    /**
     * 设置路由的目的为了方便查找对应的数据源，我们可以用ThreadLocal保存数据源的信息到每个线程中，
     * 方便我们需要时获取
     */
    private static final ThreadLocal<String> DYNAMIC_DATASOURCE_CONTEXT = new ThreadLocal<>();

    public static void set(String datasourceType) {
        DYNAMIC_DATASOURCE_CONTEXT.set(datasourceType);
    }

    public static String get() {
        return DYNAMIC_DATASOURCE_CONTEXT.get();
    }

    public static void clear() {
        DYNAMIC_DATASOURCE_CONTEXT.remove();
    }

}