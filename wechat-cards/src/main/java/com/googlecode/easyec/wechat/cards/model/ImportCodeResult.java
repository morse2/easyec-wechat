package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信卡券管理中导入自定义code返回结果的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportCodeResult {

    @JsonProperty("succ_code")
    private String successCount;
    @JsonProperty("duplicate_code")
    private String duplicateCount;
    @JsonProperty("fail_code")
    private String failCount;

    public String getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(String successCount) {
        this.successCount = successCount;
    }

    public String getDuplicateCount() {
        return duplicateCount;
    }

    public void setDuplicateCount(String duplicateCount) {
        this.duplicateCount = duplicateCount;
    }

    public String getFailCount() {
        return failCount;
    }

    public void setFailCount(String failCount) {
        this.failCount = failCount;
    }
}
