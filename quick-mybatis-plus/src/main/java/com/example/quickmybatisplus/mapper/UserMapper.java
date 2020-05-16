package com.example.quickmybatisplus.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.quickmybatisplus.entity.User;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 *  <p> 系统管理-用户基础信息表 Mapper 接口 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/10/10 11:55
 */

public interface UserMapper extends BaseMapper<User> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<User> selectUsers(Pagination page, @Param("filter") User filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<User> selectUsers(@Param("filter") User filter);
}
