package com.googlecode.easyec.wechat.member.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import com.googlecode.easyec.wechat.member.enums.MemberSex;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Created by 平功元 on 2016/3/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member extends AbstractCredentialCtrl {
    private static final long serialVersionUID = -5800728959513498322L;
    private Long uidPk;
    @JsonProperty("unionid")
    private String unionId;
    @JsonProperty("openid")
    private String openId;
    private boolean subscribe;
    @JsonProperty("nickname")
    private String nickname;
    private MemberSex sex;
    @JsonProperty("country")
    private String country;
    @JsonProperty("province")
    private String province;
    @JsonProperty("city")
    private String city;
    @JsonProperty("language")
    private String language;
    @JsonProperty("headimgurl")
    private String headImgUrl;
    @JsonProperty("subscribe_time")
    private Integer subscribeTime;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("groupid")
    private String groupId;
    @JsonProperty("privilege")
    private List<String> privilegeList;


    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public MemberSex getSex() {
        return sex;
    }

    public void setSex(MemberSex sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Integer subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<String> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public boolean isSubscribe() {
        return subscribe;

    }


    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    @JsonProperty("subscribe")
    public void setSubscribe(Integer subscribe) {
        setSubscribe(subscribe != null && new Integer(1).equals(subscribe));
    }


    @JsonProperty("sex")
    public void setSex(Integer sex){
        if(sex !=null && new Integer(1).equals(sex)){
            setSex(MemberSex.Male);
        } else if(new Integer(2).equals(sex)){
            setSex(MemberSex.Female);
        }else {
            setSex(MemberSex.Unknown);
        }
    }



}
