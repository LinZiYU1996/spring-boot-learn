//package com.example.beetlsql.config;
//
//import org.beetl.core.resource.WebAppResourceLoader;
//import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
//import org.beetl.ext.spring.BeetlSpringViewResolver;
//import org.beetl.sql.core.ClasspathLoader;
//import org.beetl.sql.core.DefaultNameConversion;
//import org.beetl.sql.core.Interceptor;
//import org.beetl.sql.core.UnderlinedNameConversion;
//import org.beetl.sql.core.db.MySqlStyle;
//import org.beetl.sql.ext.DebugInterceptor;
//import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
//import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
//import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternUtils;
//
//
//import javax.sql.DataSource;
//import java.io.IOException;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: LinZiYu
// * \* Date: 2020/6/3
// * \* Time: 19:38
// * \* Description:
// * \
// */
//
//@Configuration
//public class BeetlSqlConfig {
//    @Bean(initMethod = "init", name = "beetlConfig")
//    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
//        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
//
//        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
//
//        try {
//            WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader(patternResolver.getResource("classpath:/templates").getFile().getPath());
//            beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return beetlGroupUtilConfiguration;
//    }
//
//    @Bean(name = "beetlViewResolver")
//    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
//        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
////        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
////        beetlSpringViewResolver.setOrder(0);
//        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
//        return beetlSpringViewResolver;
//    }
//
//    //配置包扫描
//    @Bean(name = "beetlSqlScannerConfigurer")
//    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
//        BeetlSqlScannerConfigurer config = new BeetlSqlScannerConfigurer();
//        config.setBasePackage("com.example.beetlsql.dao");
//        config.setDaoSuffix("Dao");
//        config.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
//        return config;
//    }
//
//    @Bean(name = "sqlManagerFactoryBean")
//    @Primary
//    public SqlManagerFactoryBean getSqlManagerFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
//        SqlManagerFactoryBean factoryBean = new SqlManagerFactoryBean();
//
//        BeetlSqlDataSource sqlDataSource = new BeetlSqlDataSource();
//        sqlDataSource.setMasterSource(dataSource);
//        factoryBean.setCs(sqlDataSource);
//        factoryBean.setDbStyle(new MySqlStyle());
//        factoryBean.setInterceptors(new Interceptor[]{new DebugInterceptor()});
//        factoryBean.setNc(new UnderlinedNameConversion()); //开启驼峰
//        factoryBean.setSqlLoader(new ClasspathLoader("/sql")); //sql文件路径
//        return factoryBean;
//    }
//
//    //配置数据库
//    @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//        return DataSourceBuilder.create().url("jdbc:mysql://127.0.0.1:3306/t63").username("root").password("8317992").build();
//    }
//
//    //开启事务
//    @Bean(name = "txManager")
//    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//        transactionManager.setDataSource(dataSource);
//        return transactionManager;
//    }
//
//
//
//}
