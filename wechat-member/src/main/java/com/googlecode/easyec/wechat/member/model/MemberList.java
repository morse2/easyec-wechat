package com.googlecode.easyec.wechat.member.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Created by 平功元 on 2016/3/14.
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberList extends Member {

    private List<Member> members;
    @JsonProperty("user_list")
    public List<Member> getMembers() {
        return members;
    }

    @JsonProperty("user_info_list")
    public void setMembers(List<Member> members) {
        if (members != null) {
            this.members = members;
        }
    }
}
