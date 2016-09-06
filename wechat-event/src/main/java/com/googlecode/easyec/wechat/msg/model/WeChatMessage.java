package com.googlecode.easyec.wechat.msg.model;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.xml.converter.impl.DatetimeElementConverter;

import java.util.Date;

/**
 * 描述微信消息内容的基类
 *
 * @author JunJie
 */
public abstract class WeChatMessage {

    private String from;
    private String to;
    private Date createTime;
    private String msgType;

    public String getFrom() {
        return from;
    }

    @XmlElementMapping(name = "FromUserName")
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElementMapping(name = "ToUserName")
    public void setTo(String to) {
        this.to = to;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @XmlElementMapping(name = "CreateTime", converter = DatetimeElementConverter.class)
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    @XmlElementMapping(name = "MsgType")
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
