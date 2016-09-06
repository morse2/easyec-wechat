package com.googlecode.easyec.wechat.pay.converter;

import com.googlecode.easyec.wechat.pay.TransactionType;
import com.googlecode.easyec.wechat.xml.converter.XmlElementConverter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by JunJie on 9/5/16.
 */
public class TransactionTypeConverter implements XmlElementConverter<TransactionType> {

    @Override
    public TransactionType from(String val) {
        if (StringUtils.isNotBlank(val)) {
            for (TransactionType type : TransactionType.values()) {
                if (type.getValue().equals(val)) return type;
            }
        }

        return null;
    }

    @Override
    public String to(TransactionType val) {
        return val.getValue();
    }
}
