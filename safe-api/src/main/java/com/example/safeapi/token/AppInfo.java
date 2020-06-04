package com.example.safeapi.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/3
 * \* Time: 15:51
 * \* Description:
 * \
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppInfo {

    /** App id */
    private String appId;
    /** API 秘钥 */
    private String key;


}
