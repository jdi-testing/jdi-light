package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class AvatarsTestsDataProvider {

    @DataProvider(name = "avatarsWithSizeTestData")
    public Object[][] avatarsWithSizeTestData() {
        return new Object[][] {
            {1, 36},
            {2, 48},
            {3, 62}
        };
    }
}
