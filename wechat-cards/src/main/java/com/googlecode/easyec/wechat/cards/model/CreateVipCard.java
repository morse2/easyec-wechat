package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 创建会员卡数据的对象类
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class CreateVipCard extends AbstractCredentialCtrl {

    private WeChatVipMember card;



    public CreateVipCard(WeChatVipMember card) {
        this.card = card;
    }



    @JsonProperty("card")
    public WeChatVipMember getCard() {
        return card;
    }

    public void setCard(WeChatVipMember card) {
        this.card = card;
    }




}
