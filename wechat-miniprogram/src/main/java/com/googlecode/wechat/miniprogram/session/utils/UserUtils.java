package com.googlecode.wechat.miniprogram.session.utils;

import com.googlecode.easyec.spirit.web.utils.ShortUuidBuilder;
import com.googlecode.wechat.miniprogram.session.model.UserLoginResult;

import java.util.UUID;

import static com.fasterxml.uuid.Generators.nameBasedGenerator;

public class UserUtils {

    private UserUtils() {}

    /**
     * 为用户登录结果创建session id，
     * 并将该值返回给小程序前端，在后续
     * 的业务调用时，提供该session id。
     *
     * @param result <code>UserLoginResult</code>
     * @return session id
     */
    public static String createSession(UserLoginResult result) {
        if (result == null) return null;

        StringBuffer sb = new StringBuffer();
        sb.append("openid").append(result.getOpenId());
        sb.append("session_key").append(result.getSessionKey());
        sb.append("unionid").append(result.getUnionId());

        UUID uuid = nameBasedGenerator().generate(sb.toString());
        return new ShortUuidBuilder().build(uuid).toString();
    }
}
