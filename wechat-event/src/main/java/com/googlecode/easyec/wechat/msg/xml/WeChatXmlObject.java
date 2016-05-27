package com.googlecode.easyec.wechat.msg.xml;

import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责映射微信针对事件推送时候,
 * 传递的XML内容的对象类
 *
 * @author JunJie
 */
@XmlRootElement(name = "xml")
public class WeChatXmlObject {

    private String from;
    private String to;
    private String createTime;
    private String msgType;

    private List<Element> elements = new ArrayList<Element>();

    public String getFrom() {
        return from;
    }

    @XmlElement(name = "FromUserName")
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElement(name = "ToUserName")
    public void setTo(String to) {
        this.to = to;
    }

    public String getCreateTime() {
        return createTime;
    }

    @XmlElement(name = "CreateTime")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    @XmlElement(name = "MsgType")
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public List<Element> getElements() {
        return elements;
    }

    @XmlAnyElement
    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
