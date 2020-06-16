package com.example.blog.shiro;

import com.example.blog.common.exception.RestException;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/14
 * \* Time: 11:36
 * \* Description:
 * \
 */

@Slf4j
public class TokenGenerator {


    public static String generateValue() {
        log.info("generateValue");
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        log.info("toHexString");

        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {

        log.info("generateValue");

        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new RestException("生成Token失败", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateValue("123456"));
    }


}
