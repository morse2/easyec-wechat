package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 核销 查询code接口
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class QueryCode extends AbstractCredentialCtrl {

    @JsonProperty(value = "card_id")
    private String cardId;                              //单张卡券的唯一标准

    @JsonProperty(value = "code", required = true)
    private String code;                                //卡券ID代表一类卡券。自定义code卡券必填。

    @JsonProperty(value = "check_consume")
    private boolean checkConsume;                        //是否校验code核销状态，填入true和false时的code异常状态返回数据不同


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCheckConsume() {
        return checkConsume;
    }

    public void setCheckConsume(boolean checkConsume) {
        this.checkConsume = checkConsume;
    }
}
