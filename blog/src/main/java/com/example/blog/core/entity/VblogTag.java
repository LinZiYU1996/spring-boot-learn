package com.example.blog.core.entity;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 标签表
 * </p>
 *
 * @author Lin
 * @since 2020-06-11
 */
public class VblogTag extends Model<VblogTag> {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签名字
     */
    private String tagName;

    /**
     * 标签图标
     */
    private String avatar;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "VblogTag{" +
        "id=" + id +
        ", tagName=" + tagName +
        ", avatar=" + avatar +
        ", createTime=" + createTime +
        "}";
    }
}
