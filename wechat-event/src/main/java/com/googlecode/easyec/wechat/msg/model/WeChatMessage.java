package com.googlecode.easyec.wechat.msg.model;

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

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
