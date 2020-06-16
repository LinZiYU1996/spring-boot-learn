package com.example.blog.common.component;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/12
 * \* Time: 9:16
 * \* Description:
 * \
 */
public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", 0);
        put("msg", "success");
    }



    public static Result ok(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        //r.putAll(map);
        r.put("data", map);
        return r;
    }

    public static Result ok(Object object) {
        Result r = new Result();
        r.put("data", object);
        return r;
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }


    public static Result ok() {
        return new Result();
    }



    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }



    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
