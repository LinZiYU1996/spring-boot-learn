package com.example.quickmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author BaoZhou
 * @since 2020-05-15
 */
@TableName("t_city")
public class City extends Model<City> {

    private static final long serialVersionUID=1L;

      private Long id;

    /**
     * 城市名称
     */
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "City{" +
        "id=" + id +
        ", name=" + name +
        "}";
    }
}
