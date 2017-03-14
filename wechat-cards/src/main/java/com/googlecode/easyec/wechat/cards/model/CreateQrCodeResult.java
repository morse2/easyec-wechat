package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 创建二维码 返回结果类
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateQrCodeResult extends BaseResult {

    private String ticket;                  //获取的二维码ticket，凭借此ticket调用通过ticket换取二维码接口可以在有效时间内换取二维码

    private String url;                     //二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片

    private String showQrcodeUrl;         //二维码显示地址，点击后跳转二维码页面

    @JsonProperty("ticket")
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }
    @JsonProperty("show_qrcode_url")
    public void setShowQrcodeUrl(String showQrcodeUrl) {
        this.showQrcodeUrl = showQrcodeUrl;
    }

    public String getTicket() {
        return ticket;
    }

    public String getUrl() {
        return url;
    }

    public String getShowQrcodeUrl() {
        return showQrcodeUrl;
    }
}
