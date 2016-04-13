package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.googlecode.easyec.wechat.utils.WeChatUtils.parseJsonObject;

/**
 * Created by JunJie on 4/13/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchGetMaterialsResult {

    private int totalCount;
    private int itemCount;

    private List<MaterialItem> items = new ArrayList<MaterialItem>();

    public int getTotalCount() {
        return totalCount;
    }

    @JsonProperty("total_count")
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    @JsonProperty("item_count")
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<MaterialItem> getItems() {
        return items;
    }

    @JsonProperty("item")
    public void setItems(List<Map> items) {
        for (Map map : items) {
            // 如果包含content属性, 则说明是图文
            if (map.containsKey("content")) {
                this.items.add(
                    parseJsonObject(map, NewsItem.class)
                );
            }
            // 否则则认为是非图文的素材
            else {
                this.items.add(
                    parseJsonObject(map, GenericMaterialItem.class)
                );
            }
        }
    }
}
