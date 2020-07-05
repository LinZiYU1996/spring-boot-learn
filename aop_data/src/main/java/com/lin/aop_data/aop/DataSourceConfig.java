//package com.lin.aop_data.aop;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.lin.aop_data.dynamicdatasource.DynamicDataSource;
//import com.lin.aop_data.dynamicdatasource.DynamicDataSourceEnum;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: LinZiYu
// * \* Date: 2020/7/4
// * \* Time: 20:50
// * \* Description:
// * \
// */
//
//@Configuration
////@MapperScan(basePackages = "com.lin.aop_data.mapper", sqlSessionTemplateRef = "sqlTemplate")
//@MapperScan(basePackages = "com.lin.aop_data.mapper")
//public class DataSourceConfig {
//
//
//    /**
//     * 主库
//     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    public DataSource masterDb() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    /**
//     * 从库
//     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.slave")
//    public DataSource slaveDb() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    /**
//     * 主从动态配置
//     */
//    @Bean
//    public DynamicDataSource dynamicDb(@Qualifier("masterDb") DataSource masterDataSource,
//                                       @Autowired(required = false) @Qualifier("slaveDb") DataSource slaveDataSource) {
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put(DynamicDataSourceEnum.MASTER.getDataSourceName(), masterDataSource);
//        if (slaveDataSource != null) {
//            targetDataSources.put(DynamicDataSourceEnum.SLAVE.getDataSourceName(), slaveDataSource);
//        }
//        dynamicDataSource.setTargetDataSources(targetDataSources);
//        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
//        return dynamicDataSource;
//    }
//
//    @Bean
//    public SqlSessionFactoryBean sessionFactory(@Qualifier("dynamicDb") DataSource dynamicDataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
//        bean.setDataSource(dynamicDataSource);
//        return bean;
//    }
//
////    @Bean
////    public SqlSessionTemplate sqlTemplate(@Qualifier("sessionFactory") MybatisSqlSessionFactoryBean sqlSessionFactory) {
////        return new SqlSessionTemplate((SqlSessionFactory) sqlSessionFactory);
////    }
//
//    @Bean(name = "dataSourceTx")
//    public DataSourceTransactionManager dataSourceTx(@Qualifier("dynamicDb") DataSource dynamicDataSource) {
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(dynamicDataSource);
//        return dataSourceTransactionManager;
//    }
//}
