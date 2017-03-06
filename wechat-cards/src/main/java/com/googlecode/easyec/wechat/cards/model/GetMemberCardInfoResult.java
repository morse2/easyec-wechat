package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 拉取会员卡数据接口 返回数据
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class GetMemberCardInfoResult implements Serializable {

    private static final long serialVersionUID = -234301913209273585L;

    private List<MemberCardInfo> cardProfileInfos = new ArrayList<MemberCardInfo>();

    @JsonProperty("list")
    public void setCardProfileInfos(List<MemberCardInfo> cardProfileInfos) {
        this.cardProfileInfos = cardProfileInfos;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
