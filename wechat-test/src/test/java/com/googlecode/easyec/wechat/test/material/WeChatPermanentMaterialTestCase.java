package com.googlecode.easyec.wechat.test.material;

import com.googlecode.easyec.wechat.material.handler.AddArticleImageRequestHandler;
import com.googlecode.easyec.wechat.material.handler.AddArticleRequestHandler;
import com.googlecode.easyec.wechat.material.handler.AddMaterialRequestHandler;
import com.googlecode.easyec.wechat.material.handler.BatchGetMaterialsRequestHandler;
import com.googlecode.easyec.wechat.material.model.*;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

import static com.googlecode.easyec.wechat.material.enums.MaterialTypes.*;

/**
 * Created by JunJie on 2/23/16.
 */
public class WeChatPermanentMaterialTestCase extends BaseTest {

    @Test
    public void uploadArticleImg() throws Exception {
        AddArticleImage image = new AddArticleImage();
        image.setCredential(getCredential());
        image.setName("image.jpg");
        image.setData(
            getFileData("material/image.jpg")
        );

        AddArticleImageResult result = handleRequest(
            new AddArticleImageRequestHandler(jsonObjectFactory, baseUri, image)
        );

        Assert.assertNotNull(result);
    }

    @Test
    public void addArticle() throws Exception {
        AddArticles articles = new AddArticles();
        articles.setCredential(getCredential());

        Article a1 = new Article();
        a1.setContent("<html><body><h1>Hello WeChat!</h1><div><img src='http://mmbiz.qpic.cn/mmbiz/X2JU8UNibIBuO81fFibxQzVtk9FQvqrpjmW1VXqWzwsWzjhAnjLo62F6MXLuudadia4PgZ0krVaesvX6KK7VJicQ2g/0'></div></body></html>");
        a1.setShowCover(false);
        a1.setAuthor("JunJie");
        a1.setDigest("这是摘要");
        a1.setSourceUrl("http://www.baidu.com");
        a1.setTitle("这是一篇测试文章");
        a1.setThumbMediaId("uoekZseLjQLUAq5bbZLeIOwts-z9pvjSoW-qpBA4vW8");

        articles.addArticle(a1);

        AddArticlesResult result = handleRequest(
            new AddArticleRequestHandler(jsonObjectFactory, baseUri, articles)
        );

        Assert.assertNotNull(result);
    }

    @Test
    public void addMaterialAsImage() throws Exception {
        AddMaterial material = new AddMaterial();
        material.setCredential(getCredential());
        material.setType(image);
        material.setName("test_image1.jpg");
        material.setContent(getFileData("material/image.jpg"));

        AddMaterialResult result = handleRequest(
            new AddMaterialRequestHandler(jsonObjectFactory, baseUri, material)
        );

        Assert.assertNotNull(result);
    }

    @Test
    public void addMaterialAsVoice() throws Exception {
        AddMaterial material = new AddMaterial();
        material.setCredential(getCredential());
        material.setType(voice);
        material.setName("test_v1.mp3");
        material.setContent(getFileData("material/test.mp3"));

        AddMaterialResult result = handleRequest(
            new AddMaterialRequestHandler(jsonObjectFactory, baseUri, material)
        );

        Assert.assertNotNull(result);
    }

    @Test
    public void addMaterialAsVideo() throws Exception {
        AddMaterial material = new AddMaterial();
        material.setCredential(getCredential());
        material.setType(video);
        material.setName("test_v1.mp4");
        material.setContent(getFileData("material/test.mp4"));

        material.setTitle("测试视频");
        material.setDescription("这是视频的描述");

        AddMaterialResult result = handleRequest(
            new AddMaterialRequestHandler(jsonObjectFactory, baseUri, material)
        );

        Assert.assertNotNull(result);
    }

    @Test
    public void batchGetMaterials() throws Exception {
        BatchGetMaterials query = new BatchGetMaterials();
        query.setCredential(getCredential());
        query.setType(news);

        BatchGetMaterialsResult result = handleRequest(
            new BatchGetMaterialsRequestHandler(jsonObjectFactory, baseUri, query)
        );

        Assert.assertNotNull(result);
    }

    private byte[] getFileData(String file) throws IOException {
        InputStream in = new ClassPathResource(file).getInputStream();
        return IOUtils.toByteArray(in);
    }
}
