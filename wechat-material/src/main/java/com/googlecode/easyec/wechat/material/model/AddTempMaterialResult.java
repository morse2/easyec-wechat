package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.material.enums.MaterialTypes;
import com.googlecode.easyec.wechat.utils.WeChatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示新增微信临时素材的结果信息
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddTempMaterialResult {

    private MaterialTypes type;
    private String mediaId;
    private Date createAt;
    private Date expireDate;

    public MaterialTypes getType() {
        return type;
    }

    public void setType(MaterialTypes type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    @JsonProperty("media_id")
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @JsonProperty("created_at")
    public void setCreateAt(String createAt) {
        Date d = WeChatUtils.parseDate(createAt);
        if (d != null) {
            setCreateAt(d);
            setExpireDate(DateUtils.addDays(d, 3));
        }
    }

    @JsonProperty("type")
    public void setType(String type) {
        try {
            setType(MaterialTypes.valueOf(type));
        } catch (IllegalArgumentException e) {
            // no op
        }
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
