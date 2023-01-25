package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class RangeSliderTestsDataProvider {
    @DataProvider(name = "trackRangeSliderColorTestData")
    public Object[][] trackRangeSliderColorTestData() {
        return new Object[][] {
                {"244", "67", "54"},
        };
    }
}
