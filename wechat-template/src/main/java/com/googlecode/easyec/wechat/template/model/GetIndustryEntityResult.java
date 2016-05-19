package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by 平功元 on 2016/4/26.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetIndustryEntityResult {


    private GetIndustryValue primaryIndustry;//主营行业


    private GetIndustryValue secondaryIndustry;//副营行业

    public GetIndustryValue getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(GetIndustryValue primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    @JsonProperty("primary_industry")
    public void setPrimaryIndustry(String firstClass, String secondClass) {
        if (firstClass != null && secondClass != null) {
            GetIndustryValue gv = new GetIndustryValue();
            gv.setFirstClass(firstClass);
            gv.setSecondClass(secondClass);
            setPrimaryIndustry(gv);
        } else {
            return;
        }
    }

    public GetIndustryValue getSecondaryIndustry() {
        return secondaryIndustry;
    }

    public void setSecondaryIndustry(GetIndustryValue secondaryIndustry) {
        this.secondaryIndustry = secondaryIndustry;
    }

    @JsonProperty("secondary_industry")
    public void setSecondaryIndustry(String firstClass, String secondClass) {
        if (firstClass != null && secondClass != null) {
            GetIndustryValue gv1 = new GetIndustryValue();
            gv1.setFirstClass(firstClass);
            gv1.setSecondClass(secondClass);
            setSecondaryIndustry(gv1);
        } else {
            return;
        }
    }
}
