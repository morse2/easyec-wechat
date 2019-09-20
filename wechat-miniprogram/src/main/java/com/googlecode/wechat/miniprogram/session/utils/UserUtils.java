package com.googlecode.wechat.miniprogram.session.utils;

import com.googlecode.easyec.spirit.web.utils.ShortUuidBuilder;
import com.googlecode.wechat.miniprogram.session.SessionCreator;
import com.googlecode.wechat.miniprogram.session.model.UserLoginResult;

import java.util.UUID;

import static com.fasterxml.uuid.Generators.nameBasedGenerator;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

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
        return result == null ? null
            : createSession(
            () -> {
                StringBuffer sb = new StringBuffer();
                sb.append("openid").append(result.getOpenId());
                sb.append("session_key").append(result.getSessionKey());
                if (isNotBlank(result.getUnionId())) {
                    sb.append("unionid").append(result.getUnionId());
                }

                return sb.toString();
            }
        );
    }

    /**
     * 为用户登录结果创建session id，
     * 并将该值返回给小程序前端，在后续
     * 的业务调用时，提供该session id。
     *
     * @param creator <code>SessionCreator</code>
     * @return session id
     */
    public static String createSession(SessionCreator creator) {
        if (creator == null) return null;

        UUID uuid = nameBasedGenerator().generate(creator.build());
        return new ShortUuidBuilder().build(uuid).toString();
    }
}
