package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Image;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.ImagesTestsData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.imagesPage;
import static io.github.com.pages.ImagesPage.aspectRatioImage;
import static io.github.com.pages.ImagesPage.containImages;
import static io.github.com.pages.ImagesPage.gradientsImages;
import static io.github.com.pages.ImagesPage.gridImages;
import static io.github.com.pages.ImagesPage.heightImages;
import static io.github.com.pages.ImagesPage.placeholderImage;
import static io.github.com.pages.ImagesPage.slider;

public class ImagesTests extends TestsInit {

    ImagesTestsData imagesTestsData = new ImagesTestsData();

    @BeforeClass
    public void before() {
        imagesPage.open();
        waitCondition(() -> imagesPage.isOpened());
        imagesPage.checkOpened();
    }

    @Test
    public void aspectRatioImageTests() {
        aspectRatioImage.is().displayed();
        aspectRatioImage.has().sourcePath("https://cdn.vuetifyjs.com/images/parallax/material.jpg");
        for(ImagesTestsData.AspectRatioImageTestDataObject dataObject: imagesTestsData.aspectRatioImageTestData()) {
            slider.slideHorizontalTo(dataObject.getSliderPosition());
            aspectRatioImage.has().width(dataObject.getWidth());
            aspectRatioImage.has().height(dataObject.getHeight());
        }
    }

    @Test
    public void containImagesTests() {
        List<Double> heights = imagesTestsData.containImagesHeights();
        int i = 0;
        for (Image image : containImages) {
            image.is().displayed();
            image.has().sourcePath("https://picsum.photos/510/300?random");
            image.has().width(642.25);
            image.has().height(heights.get(i));
            i++;
        }
    }

    @Test
    public void gradientsImagesTests() {
        for(Image image : gradientsImages) {
            image.is().displayed();
            image.has().sourcePath("https://cdn.vuetifyjs.com/images/parallax/material2.jpg");
            image.has().width(516.984);
            image.has().height(290.797);
            image.has().gradient();
        }
    }

    @Test
    public void heightImagesTests() {
        for(Image image : heightImages) {
            image.is().displayed();
            image.has().sourcePath("https://picsum.photos/350/165?random");
            image.has().limitedHeight();
            image.has().width(775.5);
            image.has().height(125);
        }
    }

    @Test
    public void placeholderImageTests() {
        placeholderImage.is().displayed();
        placeholderImage.has().sourcePath("https://picsum.photos/id/11/100/60");
        placeholderImage.has().width(500);
        placeholderImage.has().height(300);
        placeholderImage.is().loading();
    }

    @Test
    public void gridImagesTests() {
        List<String> lazySrc = imagesTestsData.gridImagesLazySrcTestData();
        List<String> src = imagesTestsData.gridImagesSrcTestData();
        int i = 0;
        for (Image image : gridImages) {
            image.is().displayed();
            image.has().sourcePath(lazySrc.get(i), src.get(i));
            image.has().width(516.984);
            image.has().height(516.984);
            i++;
        }
    }
}
