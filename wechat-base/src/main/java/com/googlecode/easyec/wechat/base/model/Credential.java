package com.googlecode.easyec.wechat.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author JunJie
 */
@JsonIgnoreProperties({ "uidPk", "expireTime" })
public class Credential {

    @JsonProperty("access_token")
    private String accessToken;
    private Date expireTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @JsonProperty("expires_in")
    public void setExpiresIn(Integer second) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        setExpireTime(DateUtils.addSeconds(calendar.getTime(), second));
    }
}
