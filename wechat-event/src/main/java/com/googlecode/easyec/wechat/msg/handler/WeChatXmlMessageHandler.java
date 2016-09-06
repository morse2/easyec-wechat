package com.googlecode.easyec.wechat.msg.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

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
    public byte[] process(byte[] data) throws Exception {
        WeChatXmlData result = streamObjectFactory.readValue(
            data, WeChatXmlData.class
        );

        Assert.notNull(result, "Cannot resolve XML data.");

        T obj = createInstance(result);
        if (accept(obj)) {
            WeChatMessage ret = processMessage(obj);
            if (ret == null) return null;

            WeChatXmlData xmlToRet = _createReturnXml(ret);
            if (xmlToRet != null) {
                return streamObjectFactory.writeValue(xmlToRet);
            }
        }

        logger.debug("Message cannot be accept, so ignore and return null.");

        return null;
    }

    /* 创建返回的XML对象 */
    private WeChatXmlData _createReturnXml(WeChatMessage msg) {
        WeChatXmlData xml = new WeChatXmlData();
        xml.merge(msg);

        return xml;
    }

    /**
     * 判断当前消息处理对象是否
     * 接收并处理该XML对象数据
     *
     * @param msg 微信消息对象
     * @return bool值
     */
    abstract protected boolean accept(WeChatMessage msg);

    /**
     * 创建指定的业务消息对象
     *
     * @param obj <code>WeChatXmlData</code>对象
     * @return 指定的消息对象
     */
    abstract protected T createInstance(WeChatXmlData obj);

    /**
     * 处理微信XML消息对象的方法
     *
     * @param obj 泛型对象
     * @return 返回微信的消息对象
     * @throws Exception 捕获并抛出的异常信息
     */
    abstract protected WeChatMessage processMessage(T obj) throws Exception;
}
