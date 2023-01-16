package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.ImagesTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.imagesPage;
import static io.github.com.pages.ImagesPage.altImage;
import static io.github.com.pages.ImagesPage.aspectRatioImage;
import static io.github.com.pages.ImagesPage.containImages;
import static io.github.com.pages.ImagesPage.gradientsImages;
import static io.github.com.pages.ImagesPage.placeholderImage;
import static io.github.com.pages.ImagesPage.slider;

public class ImagesTests extends TestsInit {

    @BeforeClass
    public void before() {
        imagesPage.open();
        waitCondition(() -> imagesPage.isOpened());
        imagesPage.checkOpened();
    }

    @Test(dataProvider = "measurementImagesDataProvider", dataProviderClass = ImagesTestsDataProvider.class)
    public void measurementImagesTest(double sliderValue, int width, int height) {
        aspectRatioImage.is().displayed();
        slider.slideHorizontalTo(sliderValue);
        aspectRatioImage.has().width(width);
        aspectRatioImage.has().height(height);
    }

    @Test
    public void altImageTest() {
        altImage.show();
        altImage.has().altText("Empty Subway");
    }

    @Test
    public void containImageTest() {
        containImages.get(4).show();
        containImages.get(4).is().contain();
        containImages.get(1).is().notContain();
    }

    @Test
    public void themeImagesTest() {
        aspectRatioImage.show();
        aspectRatioImage.has().lightTheme();
    }

    @Test
    public void sourceImageTest() {
        gradientsImages.forEach(gradientsImage -> {
            gradientsImage.show();
            gradientsImage.has().sourcePath("https://cdn.vuetifyjs.com/images/parallax/material2.jpg");
        });
    }

    @Test
    public void gradientsImagesTest() {
        gradientsImages.forEach(gradientsImage -> {
            gradientsImage.show();
            gradientsImage.has().gradient();
        });
        aspectRatioImage.has().noGradient();
    }

    @Test
    public void placeholderImageTest() {
        placeholderImage.show();
        placeholderImage.has().placeholder();
        aspectRatioImage.has().noPlaceholder();
    }
}
