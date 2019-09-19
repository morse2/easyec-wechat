package com.googlecode.wechat.miniprogram.session.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EncryptedUserInfo implements Serializable {

    private static final long serialVersionUID = 4743304018605899631L;
    private String openid;
    private String nickname;
    private String gender;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    private Watermark watermark;

    @JsonProperty("openId")
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @JsonProperty("nickName")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("province")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("avatarUrl")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("unionId")
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @JsonProperty("watermark")
    public void setWatermark(Watermark watermark) {
        this.watermark = watermark;
    }

    public String getOpenid() {
        return openid;
    }

    public String getNickname() {
        return nickname;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public Watermark getWatermark() {
        return watermark;
    }
}
