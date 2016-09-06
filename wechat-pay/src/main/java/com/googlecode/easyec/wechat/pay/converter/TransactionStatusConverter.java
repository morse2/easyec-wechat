package com.googlecode.easyec.wechat.pay.converter;

import com.googlecode.easyec.wechat.pay.TransactionStatus;
import com.googlecode.easyec.wechat.xml.converter.XmlElementConverter;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 微信支付交易状态枚举的转换类
 *
 * @author JunJie
 */
public class TransactionStatusConverter implements XmlElementConverter<TransactionStatus> {

    @Override
    public TransactionStatus from(String val) {
        if (isNotBlank(val)) {
            for (TransactionStatus status : TransactionStatus.values()) {
                if (status.getValue().equals(val)) return status;
            }
        }

        return null;
    }

    @Override
    public String to(TransactionStatus val) {
        return val != null ? val.getValue() : null;
    }
}
