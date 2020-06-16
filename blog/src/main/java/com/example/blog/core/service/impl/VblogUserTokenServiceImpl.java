package com.example.blog.core.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.blog.common.component.Result;
import com.example.blog.core.entity.VblogUserToken;
import com.example.blog.core.mapper.VblogUserTokenMapper;
import com.example.blog.core.service.IVblogUserTokenService;
import com.example.blog.shiro.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 系统用户Token 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-06-14
 */
@Service
public class VblogUserTokenServiceImpl extends ServiceImpl<VblogUserTokenMapper, VblogUserToken> implements IVblogUserTokenService {

// 7天后过期 单位秒

    private final static int EXPIRE = 3600 * 24 * 7;

    @Override
    public Result createToken(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        VblogUserToken tokenEntity = this.selectOne(new EntityWrapper<VblogUserToken>().eq("user_id", userId));
        if (tokenEntity == null) {
            tokenEntity = new VblogUserToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setCreateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            this.insert(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        JSONObject object = new JSONObject();
        object.put("Oauth-Token", token);
        object.put("expire", EXPIRE);

        Result r = Result.ok(object);

        return r;    }
}
