package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Image;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.ImagesTestsData;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
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

    private final ImagesTestsData imagesTestsData = new ImagesTestsData();

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
        for (ImagesTestsData.AspectRatioImageTestDataObject dataObject : imagesTestsData.aspectRatioImageTestData()) {
            slider.slideHorizontalTo(String.valueOf(dataObject.getSliderPosition()));
            aspectRatioImage.has().width(dataObject.getWidth());
            aspectRatioImage.has().height(dataObject.getHeight());
        }
    }

    @Test
    public void containImagesTests() {
        for (Image image : containImages) {
            image.show();
            waitCondition(() -> !image.hasSourcePath().equals("")); //because images uploading after image frame is shown
            jdiAssert(image.hasSourcePath(), Matchers.containsString("https://jdi-testing.github.io/jdi-light/vuetify/pictures/"));
        }
    }

    @Test
    public void gradientsImagesTests() {
        for (Image image : gradientsImages) {
            image.is().displayed();
            image.has().sourcePath("https://cdn.vuetifyjs.com/images/parallax/material2.jpg");
            image.has().gradient();
        }
    }

    @Test
    public void heightImagesTests() {
        for (Image image : heightImages) {
            image.show();
            image.is().displayed();
            waitCondition(() -> !image.hasSourcePath().equals(""));
            jdiAssert(image.hasSourcePath(), Matchers.containsString("https://jdi-testing.github.io/jdi-light/vuetify/pictures/"));
            image.has().limitedHeight();
            image.has().height(125);
        }
    }

    @Test
    public void placeholderImageTests() {
        placeholderImage.is().displayed();
        placeholderImage.has().sourcePath("https://jdi-testing.github.io/jdi-light/vuetify/pictures/placeholder_60.jpeg");
        placeholderImage.has().width(500);
        placeholderImage.has().height(300);
        placeholderImage.is().loading();
    }

    @Test
    public void gridImagesTests() {
        final List<String> lazySrc = imagesTestsData.gridImagesLazySrcTestData();
        final List<String> src = imagesTestsData.gridImagesSrcTestData();
        int imageIndex = 0;
        for (Image image : gridImages) {
            image.is().displayed();
            image.has().sourcePath(lazySrc.get(imageIndex), src.get(imageIndex));
            imageIndex++;
        }
    }
}
