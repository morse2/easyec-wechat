package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 修改会员卡 日期类型
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true,
        value = {"dateType"}
)
public class UpdateMemberDateInfo implements Serializable {


    private static final long serialVersionUID = -2806862416147737028L;
    @JsonProperty("type")
    private int type;                // 有效期类型，仅支持更改type为1的时间戳，不支持填入2
    @JsonProperty("begin_timestamp")
    private Long beginTime;          // ype为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间
    @JsonProperty("end_timestamp")
    private Long endTime;            // 表示结束时间，建议设置为截止日期的23:59:59过期

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
