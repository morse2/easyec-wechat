package com.googlecode.easyec.wechat.cards;

/**
 * 微信卡券代码的类型
 *
 * @author JunJie
 */
public enum WeChatVipCardNameType {

    /**
     * 等级
     */
    Level("FIELD_NAME_TYPE_LEVEL"),
    /**
     * 优惠券
     */
    Coupon("FIELD_NAME_TYPE_COUPON"),
    /**
     * 印花
     */
    Stamp("FIELD_NAME_TYPE_STAMP"),
    /**
     * 折扣
     */
    Discount("FIELD_NAME_TYPE_DISCOUNT"),
    /**
     * 成就
     */
    Achievemen("FIELD_NAME_TYPE_ACHIEVEMEN"),
    /**
     * 里程
     */
    Mileage("FIELD_NAME_TYPE_MILEAGE"),
    /**
     * 集点
     */
    Points("FIELD_NAME_TYPE_POINTS"),
    /**
     * 次数
     */
    Tims("FIELD_NAME_TYPE_TIMS");

    private String value;

    WeChatVipCardNameType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
