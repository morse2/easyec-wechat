package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券中的修改代金券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateWeChatCash extends AbstractUpdateWeChatCard<UpdateWeChatCashInfo> {

    private static final long serialVersionUID = -2725900555722066952L;

    public UpdateWeChatCash(UpdateWeChatCashInfo cardInfo) {
        super(cardInfo);
    }

    public UpdateWeChatCash() {
        super();
    }

    @Override
    @JsonProperty("cash")
    public UpdateWeChatCashInfo getCardInfo() {
        return this.cardInfo;
    }
}
