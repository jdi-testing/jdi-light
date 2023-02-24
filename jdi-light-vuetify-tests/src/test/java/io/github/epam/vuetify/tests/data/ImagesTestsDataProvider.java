package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class ImagesTestsDataProvider {

    @DataProvider(name = "aspectRatioImagesDataProvider")
    public Object[][] aspectRatioImagesDataProvider() {
        return new Object[][]{
                {300.0, 300, 169},
                {200.0, 200, 113},
                {248.0, 248, 140}
        };
    }
}
