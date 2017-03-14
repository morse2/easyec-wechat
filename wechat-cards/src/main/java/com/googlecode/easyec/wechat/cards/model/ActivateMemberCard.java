package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 激活微信会员卡数据的对象类
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivateMemberCard extends AbstractCredentialCtrl {

    @JsonProperty(value = "membership_number", required = true)
    private String membershipNumber;                //会员卡编号，由开发者填入，作为序列号显示在用户的卡包里。可与Code码保持等值。

    @JsonProperty(value = "code", required = true)
    private String code;                            //创建会员卡时获取的初始code。

    @JsonProperty(value = "card_id")
    private String cardId;                          //卡券

    @JsonProperty(value = "activate_begin_time")
    private Long activateBeginTime;                  //激活后的有效起始时间。若不填写默认以创建时的 data_info 为准。Unix时间戳格式。

    @JsonProperty(value = "activate_end_time")
    private Long activateEndTime;                    //激活后的有效截至时间。若不填写默认以创建时的 data_info 为准。Unix时间戳格式

    @JsonProperty(value = "init_bonus")
    private Long initBonus;                       //初始积分，不填为0。

    @JsonProperty(value = "init_balance")
    private Long initBalance;                    //初始余额，不填为0。

    @JsonProperty(value = "init_custom_field_value1")
    private String initCustomFieldValue1;        //创建时字段custom_field1定义类型的初始值，限制为4个汉字，12字节。

    @JsonProperty(value = "init_custom_field_value2")
    private String initCustomFieldValue2;        //创建时字段custom_field2定义类型的初始值，限制为4个汉字，12字节。

    @JsonProperty(value = "init_custom_field_value3")
    private String initCustomFieldValue3;        //创建时字段custom_field3定义类型的初始值，限制为4个汉字，12字节。


    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getActivateBeginTime() {
        return activateBeginTime;
    }

    public void setActivateBeginTime(Long activateBeginTime) {
        this.activateBeginTime = activateBeginTime;
    }

    public Long getActivateEndTime() {
        return activateEndTime;
    }

    public void setActivateEndTime(Long activateEndTime) {
        this.activateEndTime = activateEndTime;
    }

    public Long getInitBonus() {
        return initBonus;
    }

    public void setInitBonus(Long initBonus) {
        this.initBonus = initBonus;
    }

    public Long getInitBalance() {
        return initBalance;
    }

    public void setInitBalance(Long initBalance) {
        this.initBalance = initBalance;
    }

    public String getInitCustomFieldValue1() {
        return initCustomFieldValue1;
    }

    public void setInitCustomFieldValue1(String initCustomFieldValue1) {
        this.initCustomFieldValue1 = initCustomFieldValue1;
    }

    public String getInitCustomFieldValue2() {
        return initCustomFieldValue2;
    }

    public void setInitCustomFieldValue2(String initCustomFieldValue2) {
        this.initCustomFieldValue2 = initCustomFieldValue2;
    }

    public String getInitCustomFieldValue3() {
        return initCustomFieldValue3;
    }

    public void setInitCustomFieldValue3(String initCustomFieldValue3) {
        this.initCustomFieldValue3 = initCustomFieldValue3;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
