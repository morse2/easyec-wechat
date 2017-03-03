package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 微信会员卡的日期类型的对象类
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true,
        value = {"dateType"}
)
public class MemberCardDateInfo extends CardDateInfo {

    private static final long serialVersionUID = -1930659178589094400L;
}
