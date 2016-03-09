package com.googlecode.easyec.wechat.menu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信查询自定义菜单的结果类
 *
 * @author JunJie
 */
public class QueryMenuResult {

    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    @JsonProperty("menu")
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
