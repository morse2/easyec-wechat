package com.googlecode.wechat.miniprogram.session.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginResult implements Serializable {

    /** 系统繁忙，此时请开发者稍候再试 */
    public static final String CODE_BUSY = "-1";
    /** 请求成功 */
    public static final String CODE_OK = "0";
    /** code 无效 */
    public static final String CODE_BAD_JSCODE = "40029";
    /** 频率限制，每个用户每分钟100次 */
    public static final String CODE_BLOCKED = "45011";
    private static final long serialVersionUID = 7782154589707322115L;

    @JsonProperty("openid")
    private String openId;
    @JsonProperty("unionid")
    private String unionId;
    @JsonProperty("session_key")
    private String sessionKey;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
