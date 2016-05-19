package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * Created by 平功元 on 2016/4/25.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetIndustryEntity extends AbstractCredentialCtrl {

    @JsonProperty("industry_id1")
    private String industryId1;

    @JsonProperty("industry_id2")
    private String industryId2;

    public String getIndustryId1() {
        return industryId1;
    }

    public void setIndustryId1(String industryId1) {
        this.industryId1 = industryId1;
    }

    public String getIndustryId2() {
        return industryId2;
    }

    public void setIndustryId2(String industryId2) {
        this.industryId2 = industryId2;
    }
}
