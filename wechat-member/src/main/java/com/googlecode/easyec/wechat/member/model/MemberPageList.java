package com.googlecode.easyec.wechat.member.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.spirit.dao.dialect.impl.NoOpPageDialect;
import com.googlecode.easyec.spirit.dao.paging.AbstractPage;
import com.googlecode.easyec.spirit.dao.paging.PageLineIterator;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Created by 平功元 on 2016/3/14.
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties("page")
public class MemberPageList extends AbstractCredentialCtrl {

    @JsonProperty("next_openid")
    private String nextOpenId;
    private AbstractPage page;
    private int total;
    private int count;
    private Map<String, List<String>> data;
    public MemberPageList() {
        this.page = new AbstractPage(new NoOpPageDialect()) {

            List<String> result;

            @Override
            @SuppressWarnings("unchecked")
            public <T> List<T> getRecords() {
                return result == null
                        ? Collections.<T>emptyList()
                        : (List<T>) result;
            }

            @Override
            @SuppressWarnings("unchecked")
            public <T> void setRecords(List<T> records) {
                this.result = (List<String>) records;
            }
        };

        this.page.setCurrentPage(1);
    }
    @JsonProperty("total")
    public void setTotal(int total) {
        page.setTotalRecordsCount(total);
    }
    @JsonProperty("count")
    public void setCount(int count) {
        page.setPageSize(count);
    }

    @JsonProperty("data")
    public void setData(Map<String, List<String>> data) {
        if (data != null && data.containsKey("openid")) {
            setData(data.get("openid"));
        }
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

    public void setData(List<String> data) {
        page.setRecords(data);
    }


    public String getNextOpenId() {
        return nextOpenId;
    }


    public List<String> getData() {
        return page.getRecords();
    }


    public int getTotal() {
        return page.getTotalRecordsCount();
    }


    public int getCount() {
        return page.getPageSize();
    }

    public void compute() {
        if (getCount() < 1) {
            setCount(getTotal());
        }

        page.compute();
    }

    public boolean next() {
        if (page.getNextPageAvailable()) {
            page.setCurrentPage(
                    page.getCurrentPage() + 1
            );

            return true;
        }

        return false;
    }

    public List<String> getCurrentPageData() {
        PageLineIterator<Integer> line = page.getPageLineIterator();
        return getData().subList(
                line.getFirstLineNumber() - 1,
                line.getLastLineNumber()
        );
    }
}
