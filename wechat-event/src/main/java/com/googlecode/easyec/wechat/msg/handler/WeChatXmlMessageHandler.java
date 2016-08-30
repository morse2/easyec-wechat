package com.googlecode.easyec.wechat.msg.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.msg.converter.XmlContentConverter;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.xml.WeChatXmlObject;
import com.googlecode.easyec.wechat.utils.WeChatUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.dom4j.dom.DOMCDATA;
import org.dom4j.dom.DOMElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.util.Assert;
import org.w3c.dom.Element;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;
import static org.apache.commons.lang3.time.DateFormatUtils.format;
import static org.springframework.beans.BeanUtils.instantiate;
import static org.springframework.beans.BeanUtils.instantiateClass;

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
        WeChatXmlObject result = streamObjectFactory.readValue(
            data, WeChatXmlObject.class
        );

        Assert.notNull(result, "Cannot resolve XML data.");

        T obj = doCast(result);
        if (accept(obj)) {
            WeChatMessage ret = processMessage(obj);
            if (ret == null) return null;

            WeChatXmlObject xmlToRet = _createReturnXml(ret);
            if (xmlToRet != null) {
                return streamObjectFactory.writeValue(xmlToRet);
            }
        }

        logger.debug("Message cannot be accept, so ignore and return null.");

        return null;
    }

    /**
     * 执行将XML数据对象转换为目标业务对象的方法
     *
     * @param obj
     * @return
     */
    private T doCast(WeChatXmlObject obj) {
        T msg = createInstance(obj);

        // 解析属性
        _parseProperties(obj, msg);

        return msg;
    }

    /**
     * 解析自定义的属性和值
     *
     * @param obj <code>WeChatXmlObject</code>对象
     * @param msg 微信消息对象
     */
    private void _parseProperties(WeChatXmlObject obj, WeChatMessage msg) {
        // 设置公共属性
        msg.setFrom(obj.getFrom());
        msg.setTo(obj.getTo());
        msg.setMsgType(obj.getMsgType());
        msg.setCreateTime(
            WeChatUtils.parseDate(obj.getCreateTime())
        );

        // 处理自定义属性
        BeanWrapper bw = new BeanWrapperImpl(msg);
        PropertyDescriptor[] descriptors = bw.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            if (bw.isWritableProperty(descriptor.getName())) {
                Method method = descriptor.getWriteMethod();
                if (!method.isAnnotationPresent(XmlElementMapping.class)) {
                    logger.debug("No annotation was present. Property: [" + descriptor.getName() + "].");

                    continue;
                }

                XmlElementMapping anno = method.getAnnotation(XmlElementMapping.class);
                String name = anno.name();

                Element e = IteratorUtils.find(
                    obj.getElements().iterator(),
                    PredicateUtils.orPredicate(
                        new LocalNamePredicate(name),
                        new NodeNamePredicate(name)
                    )
                );

                if (e == null) {
                    logger.debug("No element was found. Name: [{}].", name);

                    continue;
                }

                Class<? extends XmlContentConverter> cv = anno.converter();
                if (cv.isInterface()) {
                    logger.warn("XmlContentConverter cannot be a interface. Converter class: [{}].", cv);

                    continue;
                }

                String val = trim(e.getTextContent());
                bw.setPropertyValue(
                    new PropertyValue(
                        descriptor.getName(),
                        instantiate(cv).from(val)
                    )
                );
            }
        }
    }

    /* 创建返回的XML对象 */
    private WeChatXmlObject _createReturnXml(WeChatMessage msg) {
        WeChatXmlObject xml = new WeChatXmlObject();
        xml.setMsgType(msg.getMsgType());
        xml.setFrom(msg.getFrom());
        xml.setTo(msg.getTo());
        xml.setCreateTime(
            format(msg.getCreateTime(), "yyyyMMddHHmmss")
        );


        List<Element> elements = new ArrayList<Element>();
        BeanWrapper bw = new BeanWrapperImpl(msg);
        PropertyDescriptor[] descriptors = bw.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            if (bw.isReadableProperty(descriptor.getName())) {
                Method method = descriptor.getReadMethod();
                if (!method.isAnnotationPresent(XmlElementMapping.class)) {
                    logger.debug("There is no set annotation XmlElementMapping.");

                    continue;
                }

                XmlElementMapping anno = method.getAnnotation(XmlElementMapping.class);

                Class<? extends XmlContentConverter> cv = anno.converter();
                if (cv.isInterface()) {
                    logger.warn("XmlContentConverter cannot be a interface. Converter class: [{}].", cv);

                    continue;
                }

                String val = instantiateClass(cv).to(
                    bw.getPropertyValue(descriptor.getName())
                );

                DOMElement ele = new DOMElement(anno.name());
                ele.add(new DOMCDATA(val));
                elements.add(ele);
            }
        }

        xml.setElements(elements);

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
     * @param obj <code>WeChatXmlObject</code>对象
     * @return 指定的消息对象
     */
    abstract protected T createInstance(WeChatXmlObject obj);

    /**
     * 处理微信XML消息对象的方法
     *
     * @param obj 泛型对象
     * @return 返回微信的消息对象
     * @throws Exception 捕获并抛出的异常信息
     */
    abstract protected WeChatMessage processMessage(T obj) throws Exception;

    /**
     * <code>Element</code>的LocalName属性值判断类
     */
    private class LocalNamePredicate implements Predicate<Element> {

        private String name;

        public LocalNamePredicate(String name) {
            this.name = name;
        }

        @Override
        public boolean evaluate(Element object) {
            return name != null && name.equals(object.getLocalName());
        }
    }

    /**
     * <code>Element</code>的NodeName属性值判断类
     */
    private class NodeNamePredicate implements Predicate<Element> {

        private String name;

        public NodeNamePredicate(String name) {
            this.name = name;
        }

        @Override
        public boolean evaluate(Element object) {
            return name != null && name.equals(object.getNodeName());
        }
    }
}
