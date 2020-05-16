package com.test.generator.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lin
 * @since 2020-05-15
 */
public class TIdcard extends Model<TIdcard> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      private Long id;

    /**
     * 身份证号码
     */
    private String code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TIdcard{" +
        "id=" + id +
        ", code=" + code +
        "}";
    }
}
