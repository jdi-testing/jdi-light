package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.ImagesTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.imagesPage;
import static io.github.com.pages.ImagesPage.altImage;
import static io.github.com.pages.ImagesPage.altImageContainer;
import static io.github.com.pages.ImagesPage.aspectRatioImage;
import static io.github.com.pages.ImagesPage.aspectRatioImageContainer;
import static io.github.com.pages.ImagesPage.containImages;
import static io.github.com.pages.ImagesPage.containImagesContainer;
import static io.github.com.pages.ImagesPage.gradientsImagesContainer;
import static io.github.com.pages.ImagesPage.gradientsImages;
import static io.github.com.pages.ImagesPage.placeholderImage;
import static io.github.com.pages.ImagesPage.placeholderImageContainer;
import static io.github.com.pages.ImagesPage.slider;

public class ImagesTests extends TestsInit {

    @BeforeClass
    public void before() {
        imagesPage.open();
        waitCondition(() -> imagesPage.isOpened());
        imagesPage.checkOpened();
    }

    @Test(dataProvider = "measurementImagesDataProvider", dataProviderClass = ImagesTestsDataProvider.class,
            description = "Test checks aspect ration slider for image")
    public void measurementImagesTest(double sliderValue, int width, int height) {
        aspectRatioImageContainer.show();
        aspectRatioImage.is().displayed();
        slider.setValue(sliderValue);
        aspectRatioImage.has().width(width).and().height(height);
    }

    @Test(description = "Test checks alternative text for image")
    public void altImageTest() {
        altImageContainer.show();
        waitCondition(() -> altImage.isDisplayed());
        altImage.is().displayed();
        altImage.has().altText("Empty Subway");
    }

    @Test(description = "Test checks that image is contain")
    public void containImageTest() {
        containImagesContainer.show();
        waitCondition(() -> containImages.size() > 4);
        containImages.get(4).is().contain();
        containImages.get(1).is().notContain();
    }

    @Test(description = "Test checks that image has light theme")
    public void themeImagesTest() {
        aspectRatioImageContainer.show();
        aspectRatioImage.is().displayed().and().has().lightTheme();
    }

    @Test(description = "Test checks image source")
    public void sourceImageTest() {
        gradientsImagesContainer.show();
        waitCondition(() -> gradientsImages.size() == 3);
        gradientsImages.has().size(3);
        gradientsImages.forEach(image -> {
            waitCondition(image::isLoaded);
            image.has().sourcePath("https://cdn.vuetifyjs.com/images/parallax/material2.jpg");
        });
    }

    @Test(description = "Test checks that image has gradient or not")
    public void gradientsImagesTest() {
        gradientsImagesContainer.show();
        waitCondition(() -> gradientsImages.size() == 3);
        gradientsImages.has().size(3);
        gradientsImages.forEach(image -> {
            waitCondition(image::isLoaded);
            image.has().gradient();
        });
        aspectRatioImage.has().noGradient();
    }

    @Test(description = "Test checks that image has placeholder or not")
    public void placeholderImageTest() {
        placeholderImageContainer.show();
        waitCondition(() -> placeholderImage.isDisplayed());
        placeholderImage.is().displayed();
        placeholderImage.has().placeholder();
        aspectRatioImageContainer.show();
        aspectRatioImage.has().noPlaceholder();
    }

    @Test(description = "Test checks image loading state")
    public void loadingImageTest() {
        placeholderImageContainer.show();
        waitCondition(() -> placeholderImage.isDisplayed());
        placeholderImage.is().notLoaded();
        aspectRatioImageContainer.show();
        placeholderImage.is().notLoaded();
    }
}
