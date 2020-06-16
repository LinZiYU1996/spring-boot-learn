package com.example.blog.shiro;

import com.example.blog.common.constant.Base;
import com.example.blog.common.constant.Constant;
import com.example.blog.core.entity.VblogUser;
import com.example.blog.core.entity.VblogUserToken;
import com.example.blog.core.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/14
 * \* Time: 12:04
 * \* Description:
 * \
 */

@Slf4j
@Component

public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        VblogUser user = (VblogUser) principals.getPrimaryPrincipal();
        Set<String> roles = new HashSet<String>();

        //简单处理  只有admin一个角色
        if (user.getAdmin().intValue() == 1) {
            roles.add(Base.ROLE_ADMIN);
        }
        info.setRoles(roles);

        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        log.info("   doGetAuthenticationInfo  认证(登录时调用) ");
        String accessToken = (String) token.getPrincipal();
        log.info(accessToken);

        //根据accessToken，查询用户信息
        VblogUserToken tokenEntity = shiroService.queryByToken(accessToken);
        log.info(tokenEntity.toString());

        //token失效
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            log.info( "  token失效   ");
            throw new IncorrectCredentialsException("token失效, 请重新登录");
        }

        //查询用户信息
        VblogUser user = shiroService.queryUser(tokenEntity.getUserId());

        log.info(user.toString());
        //账号锁定
        if (Constant.UserStatus.PAUSE.getValue().equals(user.getStatus())) {
            throw new LockedAccountException("账号已被锁定, 请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        log.info("[Oauth-Token登录]token={},account={}", accessToken, user.getAccount());

        return info;
    }


}
