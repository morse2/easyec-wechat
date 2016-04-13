package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import com.googlecode.easyec.wechat.material.enums.MaterialTypes;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 查询微信永久素材列表的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties("credential")
public class BatchGetMaterials extends AbstractCredentialCtrl {

    private MaterialTypes type;
    private int count = 20;
    private int offset;

    public MaterialTypes getType() {
        return type;
    }

    public void setType(MaterialTypes type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    /**
     * 从全部素材的该偏移位置开始返回，
     * 0表示从第一个素材返回
     *
     * @param offset 大于或等于0的整数
     */
    public void setOffset(int offset) {
        if (offset < 0) offset = 0;
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    /**
     * 返回素材的数量，取值在1到20之间
     *
     * @param count 1-20之间的数
     */
    public void setCount(int count) {
        if (count > 0 && count <= 20) {
            this.count = count;
        }
    }
}
