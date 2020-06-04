package com.example.safeapi.token;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/3
 * \* Time: 15:50
 * \* Description:
 * \
 */

@Data
@AllArgsConstructor
public class AccessToken {

    /** token */
    private String token;

    /** 失效时间 */
    private Date expireTime;


}
