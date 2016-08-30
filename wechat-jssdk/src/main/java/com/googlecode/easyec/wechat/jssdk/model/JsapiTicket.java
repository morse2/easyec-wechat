package com.googlecode.easyec.wechat.jssdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.time.DateUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * jsapi_ticket结果对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = { "expireTime" })
public class JsapiTicket implements Serializable {

    private static final long serialVersionUID = -5052685333069827494L;
    @JsonProperty
    private String ticket;
    private Date expireTime;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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
