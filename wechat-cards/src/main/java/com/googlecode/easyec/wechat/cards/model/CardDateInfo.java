package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 微信卡券的日期类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true,
        value = {"dateType"}
)
public class CardDateInfo implements Serializable {

    private static final long serialVersionUID = 5413635463308789753L;

    public enum DateType {
        /**
         * 表示固定时长
         */
        FixTerm("DATE_TYPE_FIX_TERM"),
        /**
         * 表示固定日期区间
         */
        FixTimeRange("DATE_TYPE_FIX_TIME_RANGE"),
        /**
         * 表示永久有效
         */
        Permanent("DATE_TYPE_PERMANENT");

        private String value;

        DateType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private DateType dateType;          // 使用时间的类型
    @JsonProperty("begin_timestamp")
    private Long beginTime;          // ype为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间
    @JsonProperty("end_timestamp")
    private Long endTime;            // 表示结束时间，建议设置为截止日期的23:59:59过期
    @JsonProperty("fixed_term")
    private Long fixedTerm;          // type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0
    @JsonProperty("fixed_begin_term")
    private Long fixedBeginTerm;     // type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0
    @JsonProperty("fixed_end_term")
    private Long fixedEndTerm;       // 可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间

    @JsonProperty("type")
    public String getType() {
        return dateType != null ? dateType.getValue() : null;
    }

    public DateType getDateType() {
        return dateType;
    }

    public void setDateType(DateType dateType) {
        this.dateType = dateType;
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

    public Long getFixedTerm() {
        return fixedTerm;
    }

    public void setFixedTerm(Long fixedTerm) {
        this.fixedTerm = fixedTerm;
    }

    public Long getFixedBeginTerm() {
        return fixedBeginTerm;
    }

    public void setFixedBeginTerm(Long fixedBeginTerm) {
        this.fixedBeginTerm = fixedBeginTerm;
    }

    public Long getFixedEndTerm() {
        return fixedEndTerm;
    }

    public void setFixedEndTerm(Long fixedEndTerm) {
        this.fixedEndTerm = fixedEndTerm;
    }
}
