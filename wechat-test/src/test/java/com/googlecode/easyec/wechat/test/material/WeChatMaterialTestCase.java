package com.googlecode.easyec.wechat.test.material;

import com.googlecode.easyec.wechat.material.enums.MaterialTypes;
import com.googlecode.easyec.wechat.material.handler.AddTempMaterialRequestHandler;
import com.googlecode.easyec.wechat.material.handler.QueryTempMaterialRequestHandler;
import com.googlecode.easyec.wechat.material.model.AddTempMaterial;
import com.googlecode.easyec.wechat.material.model.AddTempMaterialResult;
import com.googlecode.easyec.wechat.material.model.QueryTempMaterial;
import com.googlecode.easyec.wechat.material.model.QueryTempMaterialResult;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import static com.googlecode.easyec.wechat.material.enums.MaterialTypes.*;

/**
 * Created by JunJie on 2/15/16.
 */
public class WeChatMaterialTestCase extends BaseTest {

    @Test
    public void addTempImage() throws Exception {
        _addTempMaterial("material/image.jpg", "test_image.jpg", image);
    }

    @Test
    public void addTempVideo() throws Exception {
        _addTempMaterial("material/test.mp4", "test_video.mp4", video);
    }

    @Test
    public void addTempVoice() throws Exception {
        _addTempMaterial("material/test.mp3", "test_voice.mp3", voice);
    }

    @Test
    public void queryTempMaterial() throws Exception {
        String mediaIdV = "IkzDXtltE559T_hQcUrZtEURqbzXYpv0OtMXhMFRvU8W6EIMSe8thrNAyQOme4oK";
        String mediaidI = "8Ag3oJ2aFaUtlPbfHTEs38djqDzIPFv2r5JeKhbhI9y9ypSVQYYsNFla3L-4UA1L";

        QueryTempMaterial material = new QueryTempMaterial();
        material.setCredential(getCredential());
        material.setMediaId(mediaidI);

        QueryTempMaterialResult result = handleRequest(
            new QueryTempMaterialRequestHandler(jsonObjectFactory, baseUri, material)
        );

        Assert.assertNotNull(result);
    }

    private void _addTempMaterial(String file, String name, MaterialTypes type) throws Exception {
        ClassPathResource cpr = new ClassPathResource(file);

        AddTempMaterial material = new AddTempMaterial();
        material.setType(type);
        material.setName(name);
        material.setContent(
            IOUtils.toByteArray(cpr.getInputStream())
        );

        material.setCredential(getCredential());

        switch (type) {
            case image:
            case thumb:
                material.setMimeType("image/jpeg");
                break;
            case video:
                material.setMimeType("video/mp4");
                break;
            case voice:
                material.setMimeType("voice/mp3");
        }

        AddTempMaterialResult result = handleRequest(
            new AddTempMaterialRequestHandler(jsonObjectFactory, baseUri, material)
        );

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getMediaId());

        logger.info("Media id: [" + result.getMediaId() + "].");
    }
}
