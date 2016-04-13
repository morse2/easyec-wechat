package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.utils.WeChatUtils;

import java.util.Date;

/**
 * Created by JunJie on 4/13/16.
 */
public class MaterialItem {

    private String mediaId;
    private Date updateTime;

    public String getMediaId() {
        return mediaId;
    }

    @JsonProperty("media_id")
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @JsonProperty("update_time")
    public void setUpdateTime(String str) {
        Date d = WeChatUtils.parseDate(str);
        if (d != null) setUpdateTime(d);
    }
}
