package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 修改code 返回结果类
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateWeChatCardResult extends BaseResult {

    boolean sendCheck;         //此次更新是否需要提审，true为需要，false为不需要。

    @JsonProperty("send_check")
    public void setSendCheck(boolean sendCheck) {
        this.sendCheck = sendCheck;
    }

    public boolean isSendCheck() {
        return sendCheck;
    }
}
