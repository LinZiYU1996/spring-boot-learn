package com.example.quickmybatisplus.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *  <p> MybatisPlus配置类 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/10/8 11:36
 */


//@Configuration
//@MapperScan("com.example.quickmybatisplus.mapper") // 扫描 Mapper 文件夹 TODO 【注：根据自己的项目结构配置】
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     * 文档：https://mp.baomidou.com/guide/page.html <br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
