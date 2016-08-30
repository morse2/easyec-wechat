package com.googlecode.easyec.wechat.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 微信自定义菜单类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties("credential")
public class Menu extends AbstractCredentialCtrl {

    @JsonProperty("menuid")
    private String menuId;
    @JsonProperty("button")
    private List<Button> buttons = new ArrayList<Button>();

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        if (CollectionUtils.isNotEmpty(buttons)) {
            this.buttons.addAll(buttons);
        }
    }

    public void addButton(Button button) {
        if (button != null) this.buttons.add(button);
    }
}
