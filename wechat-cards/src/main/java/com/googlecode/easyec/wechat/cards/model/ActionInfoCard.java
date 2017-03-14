package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 创建二维码 详细信息信息
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionInfoCard implements Serializable {

    private String code;                            //卡券Code码,use_custom_code字段为true的卡券必须填写，非自定义code不必填写

    private String cardId;                          //卡券ID

    private String openId;                          //指定领取者的openid，只有该用户能领取。bind_openid字段为true的卡券必须填写，非指定openid不必填写。

    private boolean isUniqueCode;                   //指定下发二维码，生成的二维码随机分配一个code，领取后不可再次扫描。填写true或false。默认false。

    private Integer outerId;                        //领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。用户领取卡券后触发的事件推送中会带上此自定义场景值


    @JsonProperty(value = "code", required = true)
    public String getCode() {
        return code;
    }

    @JsonProperty("card_id")
    public String getCardId() {
        return cardId;
    }

    @JsonProperty("openid")
    public String getOpenId() {
        return openId;
    }

    @JsonProperty("is_unique_code")
    public boolean isUniqueCode() {
        return isUniqueCode;
    }

    @JsonProperty("outer_id")
    public Integer getOuterId() {
        return outerId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }


    public void setUniqueCode(boolean uniqueCode) {
        isUniqueCode = uniqueCode;
    }

    public void setOuterId(Integer outerId) {
        this.outerId = outerId;
    }
}
