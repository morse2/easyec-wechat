package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信卡券管理中查询导入code数目的结果类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryCodeCountResult {

    @JsonProperty
    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
