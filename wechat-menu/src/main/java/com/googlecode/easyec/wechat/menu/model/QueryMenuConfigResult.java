package com.googlecode.easyec.wechat.menu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.BooleanUtils;

/**
 * 微信获取自定义菜单配置信息的对象类
 *
 * @author JunJie
 */
public class QueryMenuConfigResult {

    private boolean open;
    @JsonProperty("selfmenu_info")
    private Menu menu;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @JsonProperty("is_menu_open")
    public void setOpen(String openStr) {
        setOpen(BooleanUtils.toBoolean(openStr, "1", "0"));
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
