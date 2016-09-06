package com.googlecode.easyec.wechat.xml;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.xml.converter.XmlElementConverter;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.trim;
import static org.springframework.beans.BeanUtils.instantiate;
import static org.springframework.beans.BeanUtils.instantiateClass;

/**
 * 微信基于XML格式的数据对象类
 *
 * @author JunJie
 */
@XmlRootElement(name = "xml")
public class WeChatXmlData implements Serializable {

    private static final long serialVersionUID = -4759134307988161797L;
    private static Logger logger = LoggerFactory.getLogger(WeChatXmlData.class);

    @XmlAnyElement
    private List<Element> elements = new ArrayList<Element>();

    /**
     * 该方法用于返回一个当前不可变的<code>Element</code>对象集合
     *
     * @return 不可变的List对象
     */
    public List<Element> getElements() {
        return unmodifiableList(elements);
    }

    /**
     * 判断当前XML文档中是否有子元素存在
     *
     * @return bool值
     */
    public boolean hasElements() {
        return isNotEmpty(elements);
    }

    /**
     * 设置一组XML子元素
     *
     * @param elements <code>Element</code>对象
     */
    public void setElements(List<Element> elements) {
        if (hasElements()) this.elements.addAll(elements);
    }

    /**
     * 向当前子元素列表中添加一个<code>Element</code>对象
     *
     * @param element 元素对象实现
     */
    public void addElement(Element element) {
        if (element != null) this.elements.add(element);
    }

    /**
     * 解析给定类的setXXX方法上设定的注解，
     * 该注解名为<code>XmlElementMapping</code>。
     * 该方法负责解析上述注解并且将当前已有的元素
     * 设置到给定的类型对象中，最后返回该类型对象
     * 的实例变量。
     *
     * @param cls Class
     * @param <T> Generic of class
     * @return instance of class
     */
    public <T> T resolve(Class<T> cls) {
        BeanWrapper bw = new BeanWrapperImpl(cls);
        PropertyDescriptor[] descriptors = bw.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            if (bw.isWritableProperty(descriptor.getName())) {
                Method method = descriptor.getWriteMethod();
                if (!method.isAnnotationPresent(XmlElementMapping.class)) {
                    logger.debug("No annotation was present. Property: [" + descriptor.getName() + "].");

                    continue;
                }

                XmlElementMapping ann = method.getAnnotation(XmlElementMapping.class);
                String name = ann.name();

                Element e = IteratorUtils.find(
                    this.elements.iterator(),
                    PredicateUtils.orPredicate(
                        new LocalNamePredicate(name),
                        new NodeNamePredicate(name)
                    )
                );

                if (e == null) {
                    logger.debug("No element was found. Name: [{}].", name);

                    continue;
                }

                Class<? extends XmlElementConverter<?>> cv = ann.converter();
                if (cv.isInterface()) {
                    logger.warn("XmlElementConverter cannot be a interface. Converter class: [{}].", cv);

                    continue;
                }

                bw.setPropertyValue(
                    new PropertyValue(
                        descriptor.getName(),
                        instantiate(cv).from(
                            trim(e.getTextContent())
                        )
                    )
                );
            }
        }

        return cls.cast(bw.getWrappedInstance());
    }

    /**
     * 该方法负责解析给定对象中的getXXX方法上设置的
     * <code>XmlElementMapping</code>注解，并且
     * 获取该方法中的属性值，构造创建出Element对象的
     * 实例，用于最后解析成xml文档的子元素
     *
     * @param obj 一个Java对象
     */
    @SuppressWarnings("unchecked")
    public void merge(Object obj) {
        DocumentImpl doc = new DocumentImpl();
        BeanWrapper bw = new BeanWrapperImpl(obj);
        PropertyDescriptor[] descriptors = bw.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            if (bw.isReadableProperty(descriptor.getName())) {
                Method method = descriptor.getReadMethod();
                if (!method.isAnnotationPresent(XmlElementMapping.class)) {
                    logger.debug("There is no set annotation XmlElementMapping.");

                    continue;
                }

                XmlElementMapping ann = method.getAnnotation(XmlElementMapping.class);

                Class<? extends XmlElementConverter> cv = ann.converter();
                if (cv.isInterface()) {
                    logger.warn("XmlElementConverter mustn't be a interface. Converter class: [{}].", cv);

                    continue;
                }

                String val = instantiateClass(cv).to(
                    bw.getPropertyValue(descriptor.getName())
                );

                if (isBlank(val)) {
                    logger.warn("No content within element [{}]. So ignore this element.", ann.name());

                    continue;
                }

                Element ele = doc.createElement(ann.name());
                ele.appendChild(doc.createCDATASection(val));

                addElement(ele);
            }
        }
    }

    /**
     * <code>Element</code>的LocalName属性值判断类
     */
    private class LocalNamePredicate implements Predicate<Element> {

        private String name;

        private LocalNamePredicate(String name) {
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

        private NodeNamePredicate(String name) {
            this.name = name;
        }

        @Override
        public boolean evaluate(Element object) {
            return name != null && name.equals(object.getNodeName());
        }
    }
}
