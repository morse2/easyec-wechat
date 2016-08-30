package com.googlecode.easyec.wechat.oauth2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 当OAuth获取类型为snsapi_userinfo时候,
 * 调用获取用户信息接口后,返回的用户信息的数据模型类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebUserInfo implements Serializable {

    private static final long serialVersionUID = -2390907196879780065L;
    @JsonProperty
    private String openid;
    @JsonProperty
    private String nickname;
    @JsonProperty
    private String sex;
    @JsonProperty
    private String province;
    @JsonProperty
    private String city;
    @JsonProperty
    private String country;
    @JsonProperty("headimgurl")
    private String headImgUrl;
    @JsonProperty
    private String[] privilege;
    @JsonProperty
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
