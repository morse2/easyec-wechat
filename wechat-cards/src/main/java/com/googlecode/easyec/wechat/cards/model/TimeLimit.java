package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 卡券高级信息的使用时段限制的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeLimit implements Serializable {

    private static final long serialVersionUID = 4227623437949066900L;

    public enum TimeType {
        MONDAY,     // 星期一
        TUESDAY,    // 星期二
        WEDNESDAY,  // 星期三
        THURSDAY,   // 星期四
        FRIDAY,     // 星期五
        SATURDAY,   // 星期六
        SUNDAY      // 星期日
    }

    private TimeType timeType;
    @JsonProperty("begin_hour")
    private Integer beginHour;
    @JsonProperty("begin_minute")
    private Integer beginMinute;
    @JsonProperty("end_hour")
    private Integer endHour;
    @JsonProperty("end_minute")
    private Integer endMinute;

    @JsonProperty("type")
    public String getType() {
        return timeType != null ? timeType.name() : null;
    }

    public TimeType getTimeType() {
        return timeType;
    }

    public void setTimeType(TimeType timeType) {
        this.timeType = timeType;
    }

    public Integer getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(Integer beginHour) {
        this.beginHour = beginHour;
    }

    public Integer getBeginMinute() {
        return beginMinute;
    }

    public void setBeginMinute(Integer beginMinute) {
        this.beginMinute = beginMinute;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public Integer getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
    }
}
