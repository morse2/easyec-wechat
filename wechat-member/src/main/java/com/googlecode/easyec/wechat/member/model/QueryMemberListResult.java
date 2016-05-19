package com.googlecode.easyec.wechat.member.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by 平功元 on 2016/3/15.
 */
public class QueryMemberListResult {

    @JsonProperty("total")
    private int total;

    @JsonProperty("count")
     private  int count;
    @JsonProperty("next_openid")
     private String nextOpenId;
     private List<String> data;

    public QueryMemberListResult() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
    @JsonProperty("data")
    public void setData(Map<String, List<String>> data) {
        if (data != null && data.containsKey("openid")) {
            setData(data.get("openid"));
        }
    }
}
