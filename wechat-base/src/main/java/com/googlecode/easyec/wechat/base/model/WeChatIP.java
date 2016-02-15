package com.googlecode.easyec.wechat.base.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示微信IP地址列表的对象类
 *
 * @author JunJie
 */
public class WeChatIP {

    @JsonProperty("ip_list")
    private List<String> ipList = new ArrayList<String>();

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }
}
