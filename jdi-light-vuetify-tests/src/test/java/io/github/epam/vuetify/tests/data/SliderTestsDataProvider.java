package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class SliderTestsDataProvider {
    @DataProvider(name = "validationSliderTestData")
    public Object[][] validationSliderTestData() {
        return new Object[][] {
                {1, "50", "Only 40 in stock"},
                {1, "20", ""},
                {2, "50", "Only 40 in stock"},
                {2, "20", "40 in stock"},
        };
    }
}
