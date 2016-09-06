package com.googlecode.easyec.wechat.pay.converter;

import com.googlecode.easyec.wechat.xml.converter.XmlElementConverter;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 交易金额的转换实现类
 *
 * @author JunJie
 */
public class TransactionAmountConverter implements XmlElementConverter<Integer> {

    @Override
    public Integer from(String val) {
        return NumberUtils.toInt(val, 0);
    }

    @Override
    public String to(Integer val) {
        return String.valueOf(val);
    }
}
