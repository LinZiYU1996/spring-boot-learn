package com.lin.aop_data.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.lin.aop_data.entity.Adddress;
import org.apache.ibatis.annotations.Mapper;
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
 * @since 2020-07-05
 */

@Mapper
@Repository
public interface AdddressMapper extends BaseMapper<Adddress> {


    @Select("select * from adddress")
    List<Adddress> getAll();
}
