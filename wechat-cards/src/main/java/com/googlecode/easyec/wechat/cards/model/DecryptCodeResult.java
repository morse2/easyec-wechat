package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 核销卡券接口 返回结果
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DecryptCodeResult extends BaseResult {

    private String code;                          //用户在该公众号内的唯一身份标识

    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }
}
