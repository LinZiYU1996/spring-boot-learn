package com.example.safeapi.token;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/3
 * \* Time: 15:52
 * \* Description:
 * \
 */
@Data
public class TokenInfo {

    /** token类型: api:0 、user:1 */
    private Integer tokenType;


    /** App 信息 */
    private AppInfo appInfo;


    /** 用户其他数据 */
    private UserInfo userInfo;
}
