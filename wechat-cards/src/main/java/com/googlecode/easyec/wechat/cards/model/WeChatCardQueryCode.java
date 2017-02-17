package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 微信卡券管理中
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCardQueryCode implements Serializable {

    private static final long serialVersionUID = 1682601475254786116L;
    @JsonProperty
    private String code;
    @JsonProperty("card_id")
    private String cardId;
    @JsonProperty("check_consume")
    private boolean check;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
