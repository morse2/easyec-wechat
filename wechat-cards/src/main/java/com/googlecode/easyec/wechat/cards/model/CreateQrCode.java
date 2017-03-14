package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 微信创建二维码 结构对象类
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateQrCode extends AbstractCredentialCtrl {


    private String actionName;

    private Integer expireSeconds;                      //指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为永久有效。

    private ActionInfo actionInfo;

    @JsonProperty("action_info")
    public ActionInfo getActionInfo() {
        return actionInfo;
    }

    @JsonProperty("expire_seconds")
    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    @JsonProperty("action_name")
    public String getActionName() {
        return actionName;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
    }
}
