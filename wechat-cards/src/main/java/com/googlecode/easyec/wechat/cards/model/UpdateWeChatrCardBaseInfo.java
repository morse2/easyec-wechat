package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 修改微信卡券的基础信息类
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
    ignoreUnknown = true,
    value = { "cardCodeType" }
)
public class UpdateWeChatrCardBaseInfo extends AbstractUpdateCardBaseInfo {

}
