package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 微信卡券管理的货架数据模型的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LandingPage extends AbstractCredentialCtrl implements Serializable {

    private static final long serialVersionUID = 8230840045002318532L;

    public enum Scene {
        NearBy("SCENE_NEAR_BY"),   // 附近
        Menu("SCENE_MENU"),        // 自定义菜单
        QrCode("SCENE_QRCODE"),    // 二维码
        Article("SCENE_ARTICLE"),  // 公众号文章
        H5("SCENE_H5"),            // H5页面
        Ivr("SCENE_IVR"),          // 自动回复
        CardCustomCell("SCENE_CARD_CUSTOM_CELL");   // 卡券自定义cell

        private String value;

        Scene(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Card implements Serializable {

        private static final long serialVersionUID = -4460794141744420821L;
        @JsonProperty("card_id")
        private String cardId;
        @JsonProperty("thumb_url")
        private String thumbUrl;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }
    }

    @JsonProperty("banner")
    private String bannerUrl;
    @JsonProperty
    private String title;
    @JsonProperty("can_share")
    private boolean canShare;
    @JsonProperty("card_list")
    private List<Card> cards = new ArrayList<Card>();
    private Scene scene;

    @JsonProperty("scene")
    public String getSceneValue() {
        return scene != null ? scene.getValue() : null;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCanShare() {
        return canShare;
    }

    public void setCanShare(boolean canShare) {
        this.canShare = canShare;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        if (CollectionUtils.isNotEmpty(cards)) {
            this.cards.addAll(cards);
        }
    }

    public void addCard(Card card) {
        if (card != null) {
            this.cards.add(card);
        }
    }
}
