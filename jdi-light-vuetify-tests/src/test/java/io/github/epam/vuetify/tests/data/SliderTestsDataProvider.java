package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class SliderTestsDataProvider {
    @DataProvider(name = "validationSliderTestData")
    public Object[][] validationSliderTestData() {
        return new Object[][] {
            {1, 50, "Only 40 in stock"},
            {2, 50, "Only 40 in stock"}
        };
    }

    @DataProvider(name = "stepSliderTestData")
    public Object[][] stepSliderTestData() {
        return new Object[][] {
            {30, 30},
            {26, 30},
            {24, 20}
        };
    }
}
