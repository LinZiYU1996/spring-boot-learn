package com.example.springbootshiro.mapper;

import com.example.springbootshiro.entity.Permission;
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
public interface PermissionMapper extends BaseMapper<Permission> {


    @Select(" select permission\n" +
            "    from permission, role_permission rp\n" +
            "    where rp.permission_id = permission.id and rp.role_id in\n" +
            "    <foreach collection=\"roleIds\" item=\"id\" open=\"(\" close=\")\" separator=\",\">\n" +
            "        #{id}\n" +
            "    </foreach>")
    List<String> findByRoleId(@Param("roleIds") List<Integer> roleIds);

}
