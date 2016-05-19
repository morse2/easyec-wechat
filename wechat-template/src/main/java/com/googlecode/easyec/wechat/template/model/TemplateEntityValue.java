package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by 平功元 on 2016/4/25.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateEntityValue {

    private TemplateValue first;

    private TemplateValue keynote1;

    private TemplateValue keynote2;

    private TemplateValue keynote3;

    private TemplateValue remark;

    public TemplateValue getFirst() {
        return first;
    }
    @JsonProperty("first")
    public void setFirst(TemplateValue first) {
        this.first = first;
    }

    public void setFirst(String color, String value) {
        TemplateValue tv = new TemplateValue();
        tv.setValue(value);
        tv.setColor(color);
        setFirst(tv);
    }
    @JsonProperty("keynote1")
    public TemplateValue getKeynote1() {
        return keynote1;
    }

    public void setKeynote1(TemplateValue keynote1) {
        this.keynote1 = keynote1;
    }

    public void setKeynote1(String color, String value) {
        TemplateValue tv1 = new TemplateValue();
        tv1.setValue(value);
        tv1.setColor(color);
        setKeynote1(tv1);
    }
    @JsonProperty("keynote2")
    public TemplateValue getKeynote2() {
        return keynote2;
    }

    public void setKeynote2(TemplateValue keynote2) {
        this.keynote2 = keynote2;
    }

    public void setKeynote2(String color, String value) {
        TemplateValue tv2 = new TemplateValue();
        tv2.setValue(value);
        tv2.setColor(color);
        setKeynote2(tv2);
    }
    @JsonProperty("keynote3")
    public TemplateValue getKeynote3() {
        return keynote3;
    }

    public void setKeynote3(TemplateValue keynote3) {
        this.keynote3 = keynote3;
    }

    public void setKeynote3(String color, String value) {
        TemplateValue tv3 = new TemplateValue();
        tv3.setValue(value);
        tv3.setColor(color);
        setKeynote3(tv3);
    }
    @JsonProperty("remark")
    public TemplateValue getRemark() {
        return remark;
    }

    public void setRemark(TemplateValue remark) {
        this.remark = remark;
    }

    public void setRemark( String color,String value) {
        TemplateValue tvk = new TemplateValue();
        tvk.setValue(value);
        tvk.setColor(color);
        setRemark(tvk);
    }
}
