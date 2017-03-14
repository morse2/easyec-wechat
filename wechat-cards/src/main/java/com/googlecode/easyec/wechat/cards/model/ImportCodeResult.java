package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信卡券管理中导入自定义code返回结果的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportCodeResult extends BaseResult {


    private int successCount;

    private int duplicateCount;

    private int failCount;

    public int getSuccessCount() {
        return successCount;
    }
    @JsonProperty("fail_code")
    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getDuplicateCount() {
        return duplicateCount;
    }
    @JsonProperty("duplicate_code")
    public void setDuplicateCount(int duplicateCount) {
        this.duplicateCount = duplicateCount;
    }

    public int getFailCount() {
        return failCount;
    }
    @JsonProperty("succ_code")
    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }
}
