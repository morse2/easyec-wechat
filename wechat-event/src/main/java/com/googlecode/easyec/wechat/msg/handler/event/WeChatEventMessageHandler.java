package com.googlecode.easyec.wechat.msg.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.handler.WeChatXmlMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.msg.xml.WeChatXmlObject;
import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.w3c.dom.Element;

import static com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage.ELEMENT_EVENT;
import static com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage.MSG_TYPE_EVENT;
import static org.apache.commons.collections.CollectionUtils.find;
import static org.apache.commons.lang.StringUtils.trim;

/**
 * 基于事件类型的消息处理类
 *
 * @author JunJie
 */
public abstract class WeChatEventMessageHandler<T extends WeChatEventMessage> extends WeChatXmlMessageHandler<T> {

    public WeChatEventMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatXmlObject obj) {
        return obj != null && MSG_TYPE_EVENT.equals(obj.getMsgType());
    }

    @Override
    protected void setCustomValue(WeChatMessage msg, String key, String value) {
        if (ELEMENT_EVENT.equals(key)) {
            ((WeChatEventMessage) msg).setEvent(value);
        }
    }

    /**
     * 获取Event元素的值
     *
     * @param obj <code>WeChatXmlObject</code>对象类
     * @return Event元素的值
     */
    protected String getEventValue(WeChatXmlObject obj) {
        Element element = (Element) find(
            obj.getElements(),
            new BeanPropertyValueEqualsPredicate("localName", ELEMENT_EVENT)
        );

        return element != null ? trim(element.getTextContent()) : null;
    }
}
