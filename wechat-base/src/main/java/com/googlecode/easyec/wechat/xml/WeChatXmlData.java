package com.googlecode.easyec.wechat.xml;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.xml.annotation.XmlListMapping;
import com.googlecode.easyec.wechat.xml.annotation.XmlObjectMapping;
import com.googlecode.easyec.wechat.xml.converter.XmlElementConverter;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.trim;
import static org.springframework.beans.BeanUtils.instantiateClass;

/**
 * 微信基于XML格式的数据对象类
 *
 * @author JunJie
 */
@XmlRootElement(name = "xml")
public class WeChatXmlData implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(WeChatXmlData.class);
    private static final long serialVersionUID = -9081713530571912988L;

    @XmlAnyElement
    private final List<Element> elements = new ArrayList<>();

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
        return _resolve(cls, this.elements);
    }

    /**
     * 该方法负责解析给定对象中的getXXX方法上设置的
     * <code>XmlElementMapping</code>注解，并且
     * 获取该方法中的属性值，构造创建出Element对象的
     * 实例，用于最后解析成xml文档的子元素
     *
     * @param obj 一个Java对象
     */
    public void merge(Object obj) {
        _merge(obj, this.elements);
    }

    @SuppressWarnings("unchecked")
    private void _merge(Object obj, List<Element> elements) {
        DocumentImpl doc = new DocumentImpl();
        BeanWrapper bw = new BeanWrapperImpl(obj);
        PropertyDescriptor[] descriptors = bw.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            if (bw.isReadableProperty(descriptor.getName())) {
                Method method = descriptor.getReadMethod();
                if (method.isAnnotationPresent(XmlElementMapping.class)) {
                    XmlElementMapping ann = method.getAnnotation(XmlElementMapping.class);
                    Class<? extends XmlElementConverter<Object>> cv =
                        (Class<? extends XmlElementConverter<Object>>) ann.converter();
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
                    elements.add(ele);
                }
                // if is XmlObjectMapping
                if (method.isAnnotationPresent(XmlObjectMapping.class)) {
                    XmlObjectMapping ann = method.getAnnotation(XmlObjectMapping.class);
                    Object pv = bw.getPropertyValue(descriptor.getName());
                    if (pv == null) {
                        logger.warn("No object was present. [{}].", ann.name());

                        continue;
                    }

                    Element ele = doc.createElement(ann.name());
                    List<Element> children = new ArrayList<>();
                    _merge(pv, children);
                    children.forEach(ele::appendChild);
                    elements.add(ele);
                }
                // if is XmlListMapping
                if (method.isAnnotationPresent(XmlListMapping.class)) {
                    XmlListMapping ann = method.getAnnotation(XmlListMapping.class);
                    List<Object> pv = (List<Object>) bw.getPropertyValue(descriptor.getName());
                    if (pv == null) {
                        logger.warn("No list object was present. [{}].", ann.name());

                        continue;
                    }

                    Element ele = doc.createElement(ann.name());
                    pv.forEach(o -> {
                        List<Element> children = new ArrayList<>();
                        _merge(o, children);
                        children.forEach(ele::appendChild);
                    });
                    elements.add(ele);
                }
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private <T> T _resolve(Class<T> cls, List<Element> elements) {
        final BeanWrapper bw = new BeanWrapperImpl(cls);
        PropertyDescriptor[] descriptors = bw.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : descriptors) {
            if (bw.isWritableProperty(descriptor.getName())) {
                final Method method = descriptor.getWriteMethod();
                if (method.isAnnotationPresent(XmlElementMapping.class)) {
                    final XmlElementMapping ann = method.getAnnotation(XmlElementMapping.class);
                    elements.stream()
                        .filter(e -> nameMatches(e, ann.name()))
                        .findFirst()
                        .ifPresent(e -> {
                            Class<? extends XmlElementConverter<?>> cv = ann.converter();
                            if (cv.isInterface()) {
                                logger.warn("XmlElementConverter cannot be a interface. Converter class: [{}].", cv);

                                return;
                            }

                            bw.setPropertyValue(
                                new PropertyValue(
                                    descriptor.getName(),
                                    instantiateClass(cv).from(
                                        trim(e.getTextContent())
                                    )
                                )
                            );
                        });
                }
                // if is XmlObjectMapping
                if (method.isAnnotationPresent(XmlObjectMapping.class)) {
                    final XmlObjectMapping ann = method.getAnnotation(XmlObjectMapping.class);
                    elements.stream()
                        .filter(e -> nameMatches(e, ann.name()))
                        .findFirst()
                        .ifPresent(e -> {
                            Object obj = _resolve(ann.value(), collectChildren(e));
                            if (obj != null) {
                                bw.setPropertyValue(new PropertyValue(descriptor.getName(), obj));
                            }
                        });
                }
                // if is XmlListMapping
                if (method.isAnnotationPresent(XmlListMapping.class)) {
                    final XmlListMapping ann = method.getAnnotation(XmlListMapping.class);
                    Class<? extends List> listCls = ann.listType();
                    if (listCls.isInterface()) {
                        throw new IllegalArgumentException("listType mustn't be an interface type.");
                    }

                    List list = instantiateClass(listCls);
                    elements.stream()
                        .filter(e -> nameMatches(e, ann.name()))
                        .forEach(e -> {
                            Object obj = _resolve(ann.value(), collectChildren(e));
                            if (obj != null) {
                                //noinspection unchecked
                                list.add(obj);
                            }
                        });

                    bw.setPropertyValue(new PropertyValue(descriptor.getName(), list));
                }
            }
        }

        return cls.cast(bw.getWrappedInstance());
    }

    private boolean nameMatches(Element e, String name) {
        return e != null && (StringUtils.equals(name, e.getLocalName()) || StringUtils.equals(name, e.getNodeName()));
    }

    private List<Element> collectChildren(Element e) {
        NodeList nodes = e.getChildNodes();
        if (nodes == null) return emptyList();

        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                elements.add(((Element) node));
            }
        }

        return elements;
    }
}
