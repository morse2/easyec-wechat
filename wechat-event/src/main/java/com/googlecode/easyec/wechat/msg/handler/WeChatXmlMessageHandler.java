package com.googlecode.easyec.wechat.msg.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.xml.WeChatXmlObject;
import com.googlecode.easyec.wechat.utils.WeChatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.w3c.dom.Element;

import static org.apache.commons.lang.StringUtils.trim;

/**
 * 微信XML格式的消息处理的基类
 *
 * @author JunJie
 */
public abstract class WeChatXmlMessageHandler<T extends WeChatMessage> implements WeChatMessageHandler {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private StreamObjectFactory streamObjectFactory;

    public WeChatXmlMessageHandler(StreamObjectFactory streamObjectFactory) {
        Assert.notNull(streamObjectFactory, "StreamObjectFactory is null.");
        this.streamObjectFactory = streamObjectFactory;
    }

    /**
     * 返回当前设置的流对象工厂类
     *
     * @return <code>StreamObjectFactory</code>对象
     */
    public StreamObjectFactory getStreamObjectFactory() {
        return streamObjectFactory;
    }

    @Override
    public WeChatMessage process(byte[] data) throws Exception {
        WeChatXmlObject result = streamObjectFactory.readValue(
            data, WeChatXmlObject.class
        );

        Assert.notNull(result, "Cannot resolve XML data.");

        if (accept(result)) return processMessage(cast(result));

        logger.debug("MsgType cannot be accept, so ignore and return null.");

        return null;
    }

    /**
     * 为消息对象设置公共属性
     *
     * @param obj <code>WeChatXmlObject</code>对象
     * @param msg 微信消息对象
     */
    protected void setCommonProperties(WeChatXmlObject obj, WeChatMessage msg) {
        msg.setFrom(obj.getFrom());
        msg.setTo(obj.getTo());
        msg.setMsgType(obj.getMsgType());
        msg.setCreateTime(
            WeChatUtils.parseDate(obj.getCreateTime())
        );
    }

    /**
     * 解析自定义的属性和值
     *
     * @param obj <code>WeChatXmlObject</code>对象
     * @param msg 微信消息对象
     */
    protected void parseCustomProperties(WeChatXmlObject obj, WeChatMessage msg) {
        for (Element element : obj.getElements()) {
            String name = element.getLocalName();
            String content = trim(element.getTextContent());
            setCustomValue(msg, name, content);
        }
    }

    /**
     * 设置自定义的属性值。
     * 该方法应有子类具体实现。
     *
     * @param msg   微信消息对象
     * @param key   自定义属性的名称
     * @param value 自定义属性的值
     */
    protected void setCustomValue(WeChatMessage msg, String key, String value) {
        // no op
    }

    /**
     * 判断当前消息处理对象是否
     * 接收并处理该XML对象数据
     *
     * @param obj <code>WeChatXmlObject</code>对象
     * @return bool值
     */
    abstract protected boolean accept(WeChatXmlObject obj);

    /**
     * 转换XML对象为指定的业务消息对象
     *
     * @param obj <code>WeChatXmlObject</code>对象
     * @return 指定的消息对象
     */
    abstract protected T cast(WeChatXmlObject obj);

    /**
     * 处理微信XML消息对象的方法
     *
     * @param obj 泛型对象
     * @return 返回微信的消息对象
     * @throws Exception 捕获并抛出的异常信息
     */
    abstract protected WeChatMessage processMessage(T obj) throws Exception;
}
