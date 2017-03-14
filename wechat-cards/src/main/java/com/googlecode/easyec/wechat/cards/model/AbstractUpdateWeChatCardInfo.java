package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示修改微信卡券信息的对象基类
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractUpdateWeChatCardInfo implements Serializable {

    private static final long serialVersionUID = -2961311120899158761L;
    @JsonProperty(value = "base_info", required = true)
    private AbstractUpdateCardBaseInfo baseInfo;


    protected AbstractUpdateWeChatCardInfo(AbstractUpdateCardBaseInfo baseInfo) {
        Assert.notNull(baseInfo, "WeChat base info must be present.");
        this.baseInfo = baseInfo;

    }

    public AbstractUpdateCardBaseInfo getBaseInfo() {
        return baseInfo;
    }

}
