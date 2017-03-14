package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券信息的对象基类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractWeChatCardInfo<B extends AbstractWeChatCardBaseInfo> implements Serializable {

    private static final long serialVersionUID = 4587686392354079694L;
    @JsonProperty(value = "base_info", required = true)
    private B baseInfo;
    @JsonProperty("advanced_info")
    private WeChatCardAdvancedInfo advancedInfo;

    protected AbstractWeChatCardInfo(B baseInfo, WeChatCardAdvancedInfo advancedInfo) {
        Assert.notNull(baseInfo, "WeChat base info must be present.");
        Assert.notNull(advancedInfo, "WeChat advanced info must be present.");

        this.baseInfo = baseInfo;
        this.advancedInfo = advancedInfo;
    }

    public void setBaseInfo(B baseInfo) {
        this.baseInfo = baseInfo;
    }

    public B getBaseInfo() {
        return baseInfo;
    }

    public void setAdvancedInfo(WeChatCardAdvancedInfo advancedInfo) {
        this.advancedInfo = advancedInfo;
    }

    public WeChatCardAdvancedInfo getAdvancedInfo() {
        return advancedInfo;
    }
}
