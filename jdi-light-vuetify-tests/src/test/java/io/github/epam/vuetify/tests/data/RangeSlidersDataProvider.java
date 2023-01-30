package io.github.epam.vuetify.tests.data;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

public class RangeSlidersDataProvider {
    @DataProvider(name = "rangeSliderColorTestData")
    public Object[][] rangeSliderColorTestData() {
        return new Object[][] {
                {Colors.RED_TRANSPARENT_055.value()},
        };
    }
}
