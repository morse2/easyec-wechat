package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 微信卡券管理中导入自定义code的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportCode extends AbstractCredentialCtrl {

    @JsonProperty("card_id")
    private String cardId;
    @JsonProperty("code")
    private Set<String> codes = new HashSet<String>();

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Set<String> getCodes() {
        return codes;
    }

    public void setCodes(Set<String> codes) {
        if (CollectionUtils.isNotEmpty(codes)) {
            this.codes.addAll(codes);
        }
    }

    public void addCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            this.codes.add(code);
        }
    }
}
