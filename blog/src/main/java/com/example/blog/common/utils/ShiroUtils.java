package com.example.blog.common.utils;

import com.example.blog.common.exception.RestException;
import com.example.blog.core.entity.VblogUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/14
 * \* Time: 11:43
 * \* Description:
 * \
 */
public class ShiroUtils {

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static VblogUser getUserEntity() {
        VblogUser userEntity = (VblogUser) SecurityUtils.getSubject().getPrincipal();
        if (userEntity == null) {
            throw new RestException("您当前没有权限", 401);
        }
        return userEntity;
    }

    public static Long getUserId() {
        return getUserEntity().getId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static String getKaptcha(String key) {
        Object kaptcha = getSessionAttribute(key);
        if (kaptcha == null) {
            throw new RestException("验证码已失效");
        }
        getSession().removeAttribute(key);
        return kaptcha.toString();
    }



}
