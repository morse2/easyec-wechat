package com.googlecode.wechat.miniprogram.session.utils;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;

import static java.security.Security.addProvider;
import static java.security.Security.getProvider;
import static javax.crypto.Cipher.DECRYPT_MODE;

public class EncoderUtils {

    private EncoderUtils() {}

    /**
     * 解密数据的方法。
     *
     * @param base64Data 加密的数据
     * @param sessionKey session key
     * @param iv         iv参数值
     * @return 解密后的数据
     * @throws Exception 解密失败的异常
     */
    public static byte[] decode(String base64Data, String sessionKey, String iv) throws Exception {
        if (getProvider("BC") == null) addProvider(new BouncyCastleProvider());
        // secret key
        SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(sessionKey), "AES");
        // iv parameter
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(Base64.decodeBase64(iv)));
        // create cipher instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        //设置为解密模式
        cipher.init(DECRYPT_MODE, key, params);
        return cipher.doFinal(Base64.decodeBase64(base64Data));
    }
}
