package com.googlecode.easyec.wechat.cards;

/**
 * 微信卡券代码的类型
 *
 * @author JunJie
 */
public enum WeChatCardCodeType {

    /**
     * 文本
     */
    Text("CODE_TYPE_TEXT"),
    /**
     * 带code显示的一维码（条形码）
     */
    Barcode("CODE_TYPE_BARCODE"),
    /**
     * 带code显示的二维码
     */
    QrCode("CODE_TYPE_QRCODE"),
    /**
     * 不带code显示的一维码（条形码）
     */
    OnlyBarcode("CODE_TYPE_ONLY_BARCODE"),
    /**
     * 不带code显示的二维码
     */
    OnlyQrCode("CODE_TYPE_ONLY_QRCODE"),
    /**
     * 不显示code和条形码
     */
    None("CODE_TYPE_NONE");

    private String value;

    WeChatCardCodeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
