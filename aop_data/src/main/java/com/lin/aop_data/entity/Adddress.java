package com.lin.aop_data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lin
 * @since 2020-07-05
 */
@TableName("adddress")
@NoArgsConstructor
@AllArgsConstructor
public class Adddress extends Model<Adddress> {

    private static final long serialVersionUID=1L;

    public Adddress(String location, Integer age) {
        this.location = location;
        this.age = age;
    }

    private Integer id;

    private String location;

    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Adddress{" +
        "id=" + id +
        ", location=" + location +
        ", age=" + age +
        "}";
    }
}
