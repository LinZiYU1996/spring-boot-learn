package com.example.safeapi.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/3
 * \* Time: 15:53
 * \* Description:
 * \
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {

    private String code;

    /** 结果 */
    private String msg;
}
