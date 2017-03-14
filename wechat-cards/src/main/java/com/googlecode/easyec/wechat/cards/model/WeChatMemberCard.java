package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 微信卡券管理中会员卡数据结构的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatMemberCard extends AbstractWeChatCard<WeChatMemberCardInfo> {

    private static final long serialVersionUID = 956851635619942297L;

    public WeChatMemberCard() {
        super(new WeChatMemberCardInfo());
        setCardType("MEMBER_CARD");
    }

    @Override
    @JsonProperty("member_card")
    public WeChatMemberCardInfo getCardInfo() {
        return this.cardInfo;
    }
}
