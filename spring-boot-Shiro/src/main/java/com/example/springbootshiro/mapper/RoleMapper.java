package com.example.springbootshiro.mapper;

import com.example.springbootshiro.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-05-20
 */

@Repository
public interface RoleMapper extends BaseMapper<Role> {


    @Select(" select r.id, r.role\n" +
            "    from role r\n" +
            "    left join user_role ur on ur.role_id = r.id\n" +
            "    left join user u on u.id = ur.user_id\n" +
            "    where 1=1\n" +
            "    and u.user_id = #{userId}")
    List<Role> findRoleByUserId(@Param("userId") Long userId);

}
