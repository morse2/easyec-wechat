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
public abstract class AbstractWeChatCardInfo implements Serializable {

    private static final long serialVersionUID = -2961311120899158761L;
    @JsonProperty(value = "base_info", required = true)
    private AbstractWeChatCardBaseInfo baseInfo;
    @JsonProperty("advanced_info")
    private WeChatCardAdvancedInfo advancedInfo;

    protected AbstractWeChatCardInfo(AbstractWeChatCardBaseInfo baseInfo, WeChatCardAdvancedInfo advancedInfo) {
        Assert.notNull(baseInfo, "WeChat base info must be present.");
        Assert.notNull(advancedInfo, "WeChat advanced info must be present.");

        this.baseInfo = baseInfo;
        this.advancedInfo = advancedInfo;
    }

    public AbstractWeChatCardBaseInfo getBaseInfo() {
        return baseInfo;
    }

    public WeChatCardAdvancedInfo getAdvancedInfo() {
        return advancedInfo;
    }
}
