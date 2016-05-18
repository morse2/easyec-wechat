package com.googlecode.easyec.wechat.oauth2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 网页授权结果对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = { "expireTime", "scopes" })
public class WebAuthorityResult implements Serializable {

    private static final long serialVersionUID = -7058677144395632895L;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("openid")
    private String openId;
    private String[] scopes;
    private Date expireTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String[] getScopes() {
        return scopes;
    }

    public void setScopes(String[] scopes) {
        this.scopes = scopes;
    }

    @JsonProperty("expires_in")
    public void setExpiresIn(Integer second) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        setExpireTime(DateUtils.addSeconds(calendar.getTime(), second));
    }

    @JsonProperty("scope")
    public void setScope(String str) {
        setScopes(StringUtils.split(str, ","));
    }
}
