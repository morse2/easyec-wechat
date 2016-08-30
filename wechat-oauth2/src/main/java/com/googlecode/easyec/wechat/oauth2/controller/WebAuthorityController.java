package com.googlecode.easyec.wechat.oauth2.controller;

import com.googlecode.easyec.wechat.utils.WeChatUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.join;

/**
 * Web OAuth2.0授权的控制器类
 *
 * @author JunJie
 */
public class WebAuthorityController {

    /**
     * 判断签名是否合法有效
     *
     * @param token   令牌
     * @param request 请求的参数
     * @return bool值
     */
    protected boolean isSignatureValid(String token, HttpServletRequest request) {
        String signature = WebUtils.findParameterValue(request, "signature");
        String timestamp = WebUtils.findParameterValue(request, "timestamp");
        String nonce = WebUtils.findParameterValue(request, "nonce");

        if (isBlank(signature) || isBlank(timestamp) || isBlank(nonce)) return false;

        List<String> arr = Arrays.asList(token, timestamp, nonce);
        Collections.sort(arr);

        return WeChatUtils.sha1Hex(
            join(arr, "")
        ).equals(signature);
    }

    /**
     * 打印echostr参数
     *
     * @param request  <code>HttpServletRequest</code>对象
     * @param response <code>HttpServletResponse</code>对象
     * @throws IOException 输出时异常
     */
    protected void printEchoString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        pw.print(
            WebUtils.findParameterValue(request, "echostr")
        );
    }
}
