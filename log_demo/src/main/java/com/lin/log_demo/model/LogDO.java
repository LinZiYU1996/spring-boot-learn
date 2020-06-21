package com.lin.log_demo.model;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/19
 * \* Time: 15:41
 * \* Description:
 * \
 */
@Data
public class LogDO {

    /**
     * 主键
     */
    private Long oid;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 操作那个表中的主键
     */
    private Long tableId;

    /**
     * 操作方式
     */
    private String type;

    /**
     * 操作时间
     */
    private String time;

    /**
     * 操作人id
     */
    private Long userId;
}

