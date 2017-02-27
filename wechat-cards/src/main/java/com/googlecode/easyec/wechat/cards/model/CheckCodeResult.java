package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信卡券管理中核查导入code的结果类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckCodeResult {

    @JsonProperty("exist_code")
    private List<String> existCodes = new ArrayList<String>();
    @JsonProperty("not_exist_code")
    private List<String> notExistCodes = new ArrayList<String>();

    public List<String> getExistCodes() {
        return existCodes;
    }

    public void setExistCodes(List<String> existCodes) {
        if (CollectionUtils.isNotEmpty(existCodes)) {
            this.existCodes.addAll(existCodes);
        }
    }

    public List<String> getNotExistCodes() {
        return notExistCodes;
    }

    public void setNotExistCodes(List<String> notExistCodes) {
        if (CollectionUtils.isNotEmpty(notExistCodes)) {
            this.notExistCodes.addAll(notExistCodes);
        }
    }
}
