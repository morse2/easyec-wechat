package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 修改微信会员卡的基础信息类
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
    ignoreUnknown = true,
    value = { "use_all_locations","get_limit" }
)
public class UpdateMemberWeChatMemberCardBaseInfo extends AbstractUpdateMemberCardBaseInfo {

}
