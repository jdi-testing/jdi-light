package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class ImagesTestsDataProvider {

    @DataProvider(name = "measurementImagesDataProvider")
    public Object[][] measurementImagesDataProvider() {
        return new Object[][]{
                {300, 300, 169},
                {200, 200, 113},
                {248, 248, 140}
        };
    }
}
