package com.example.quickmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lin
 * @since 2020-05-15
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyUser extends Model<MyUser> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String pwd;

    private String birthday;




    public MyUser(String name, String pwd, String birthday) {
        this.name = name;
        this.pwd = pwd;
        this.birthday = birthday;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MyUser{" +
        "id=" + id +
        ", name=" + name +
        ", pwd=" + pwd +
        ", birthday=" + birthday +
        "}";
    }
}
