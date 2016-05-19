package com.googlecode.easyec.wechat.template.model;

import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * Created by 平功元 on 2016/4/26.
 */
public class GetIndustryValue extends AbstractCredentialCtrl {

    private  String  firstClass;

    private  String secondClass;

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }
}
