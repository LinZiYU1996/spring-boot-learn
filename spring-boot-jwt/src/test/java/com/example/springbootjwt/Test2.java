package com.example.springbootjwt;

import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/12
 * \* Time: 16:29
 * \* Description:
 * \
 */
public class Test2 {


    public static void main(String[] args) {


        //生成JWT token。

        /*
        这里使用sha512算法，所以需要一个密钥。


         */
        Key KEY = new SecretKeySpec("javastack".getBytes(),
                SignatureAlgorithm.HS512.getJcaName());

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("type", "1");
        String payload = "{\"user_id\":\"1341137\", \"expire_time\":\"2018-01-01 0:00:00\"}";
        String compactJws = Jwts.builder().setHeader(stringObjectMap)
                .setPayload(payload).signWith(SignatureAlgorithm.HS512, KEY).compact();

        System.out.println("jwt key:" + new String(KEY.getEncoded()));
        System.out.println("jwt payload:" + payload);
        System.out.println("jwt encoded:" + compactJws);

        System.out.println("==================================");

        //解密JWT token内容。
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(compactJws);
        JwsHeader header = claimsJws.getHeader();
        Claims body = claimsJws.getBody();

        System.out.println("jwt header:" + header);
        System.out.println("jwt body:" + body);
        System.out.println("jwt body user-id:" + body.get("user_id", String.class));

    }
}
