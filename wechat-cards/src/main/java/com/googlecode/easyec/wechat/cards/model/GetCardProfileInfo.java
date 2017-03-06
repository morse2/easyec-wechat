package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 拉取卡券概况数据  查询时间区间需<=62天，否则报错{errcode: 61501，errmsg: "date range error"}；

 2. 传入时间格式需严格参照示例填写”2015-06-15”，否则报错{errcode":61500,"errmsg":"date format error"}
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class GetCardProfileInfo extends AbstractCredentialCtrl {

    @JsonProperty(value = "begin_date", required = true)
    private String beginDate;                              //查询数据的起始时间  2017-01-01 必须按照此样式

    @JsonProperty(value = "end_date", required = true)
    private String endDate;                                 //查询数据的截至时间 2017-01-01 必须按照此样式

    @JsonProperty(value = "cond_source", required = true)
    private int condSource;                                 //卡券来源，0为公众平台创建的卡券数据、1是API创建的卡券数据


    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCondSource() {
        return condSource;
    }

    public void setCondSource(int condSource) {
        this.condSource = condSource;
    }
}
