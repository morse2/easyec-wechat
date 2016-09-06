package com.googlecode.easyec.wechat.test.pay;

import com.googlecode.easyec.wechat.pay.handler.WeChatCloseOrderRequestHandler;
import com.googlecode.easyec.wechat.pay.handler.WeChatPlaceUnifiedOrderRequestHandler;
import com.googlecode.easyec.wechat.pay.handler.WeChatQueryOrderRequestHandler;
import com.googlecode.easyec.wechat.pay.model.*;
import com.googlecode.easyec.wechat.test.BaseTest;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;

import static com.googlecode.easyec.wechat.pay.TransactionCurrency.CNY;
import static com.googlecode.easyec.wechat.pay.TransactionType.Native;
import static com.googlecode.easyec.wechat.pay.utils.TransactionUtils.*;

/**
 * Created by JunJie on 9/2/16.
 */
public class WeChatPayTestCase extends BaseTest {

    private String apiKey = "XXX";

    @Test
    public void resolveXml() throws Exception {
        FileInputStream fis = new FileInputStream("/Users/JunJie/Desktop/trade_result.xml");
        try {
            byte[] bs = IOUtils.toByteArray(fis);
            WeChatXmlData xml = jaxbObjectFactory.readValue(bs, WeChatXmlData.class);
            WeChatTransactionResult result = xml.resolve(WeChatTransactionResult.class);
            Assert.notNull(result);
            Assert.isTrue(result.isSuccess());
        } finally {
            IOUtils.closeQuietly(fis);
        }
    }

    @Test
    public void createTransactionAndQR() throws Exception {
        BigDecimal amount = new BigDecimal(0.012d);

        WeChatTransaction ts = new WeChatTransaction();
        ts.setDeviceInfo("013467007045764");
        ts.setGoodsInfo("拓高科技 - 项目费");
        ts.setOutOrderNo("201609061325001");
        ts.setCurrencyType(CNY.name());
        ts.setTotalAmount(getTransactionAmount(amount));
        ts.setTerminalIp("123.12.12.123");
        ts.setStartTime(getTimestamp(new Date()));
        ts.setCallbackUrl("http://www.weixin.qq.com/wxpay/pay.php");
        ts.setType(Native.getValue());
        ts.setGoodsId("12235413214070356458058");

        _setCommonProperties(ts);

        WeChatTransactionResult result = handleRequest(
            new WeChatPlaceUnifiedOrderRequestHandler(
                jaxbObjectFactory, getBaseUri(), ts, apiKey
            )
        );

        Assert.notNull(result);
        Assert.isTrue(result.isSuccess());
        Assert.notNull(result.getCodeUrl());

        QRCode code = QRCode.from(result.getCodeUrl());
        ByteArrayOutputStream bos = code.to(ImageType.JPG).stream();
        FileOutputStream fos = new FileOutputStream("/Users/JunJie/Desktop/trade.jpg");

        try {
            IOUtils.write(bos.toByteArray(), fos);
            fos.flush();
        } finally {
            IOUtils.closeQuietly(bos);
            IOUtils.closeQuietly(fos);
        }
    }

    @Test
    public void queryTransaction() throws Exception {
        WeChatTransactionQuery req = new WeChatTransactionQuery();
        req.setOutOrderNo("201609061325001");

        _setCommonProperties(req);

        WeChatTransactionQueryResult result = handleRequest(
            new WeChatQueryOrderRequestHandler(jaxbObjectFactory, getBaseUri(), req, apiKey)
        );

        Assert.notNull(result);
        Assert.isTrue(result.isSuccess());
    }

    @Test
    public void closeTransaction() throws Exception {
        WeChatTransactionClose req = new WeChatTransactionClose();
        req.setOutOrderNo("201609061325001");

        _setCommonProperties(req);

        WeChatTransactionCloseResult result = handleRequest(
            new WeChatCloseOrderRequestHandler(jaxbObjectFactory, getBaseUri(), req, apiKey)
        );

        Assert.notNull(result);
        Assert.isTrue(result.isSuccess());
    }

    private void _setCommonProperties(BaseWeChatTransaction req) {
        req.setAppid("wx8da45fbfaa24c91d");
        req.setMerchantId("1385150902");
    }
}
