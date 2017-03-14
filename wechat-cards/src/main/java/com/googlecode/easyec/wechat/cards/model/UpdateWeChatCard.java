package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import org.springframework.util.Assert;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 修改微信卡券数据的对象类
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateWeChatCard extends AbstractCredentialCtrl {


    @JsonProperty("card_id")
    private String cardId;

    private AbstractUpdateWeChatCard chatCard;

    public UpdateWeChatCard(AbstractUpdateWeChatCard chatCard){
        Assert.notNull(chatCard);
        this.chatCard = chatCard;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
