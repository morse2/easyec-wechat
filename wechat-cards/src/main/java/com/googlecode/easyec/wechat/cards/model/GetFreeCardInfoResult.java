package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取免费券数据 返回数据
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class GetFreeCardInfoResult implements Serializable {

    private List<FreeCardInfo> info = new ArrayList<FreeCardInfo>();

    @JsonProperty("list")
    public void setInfo(List<FreeCardInfo> info) {
        this.info = info;
    }

    public List<FreeCardInfo> getInfo() {
        return info;
    }
}
