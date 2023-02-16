package io.github.epam.vuetify.tests.data;

import com.google.common.collect.ImmutableList;
import org.testng.annotations.DataProvider;

public class RangeSlidersDataProvider {
    @DataProvider(name = "rangeSliderColorTestData")
    public Object[][] rangeSliderColorTestData() {
        return new Object[][] {
            {"rgba(248, 248, 248, 1)",
                "rgba(132, 168, 242, 1)",
                "rgba(73, 128, 241, 1)",
                "rgba(6, 83, 244, 1)"},
        };
    }

    @DataProvider(name = "stepRangeSliderTestData")
    public Object[][] stepRangeSliderTestData() {
        return new Object[][] {
            {30, 40, 30, 40},
            {26, 44, 30, 40},
            {24, 46, 20, 50},
        };
    }

    @DataProvider(name = "successRangeSliderTestData")
    public Object[][] successRangeSliderTestData() {
        return new Object[][] {
            {2, ImmutableList.of("SuccessText1", "SuccessText2")},
            {3, ImmutableList.of("SuccessText1", "SuccessText2", "SuccessText3")}
        };
    }

    @DataProvider(name = "errorRangeSliderTestData")
    public Object[][] errorRangeSliderTestData() {
        return new Object[][] {
            {2, ImmutableList.of("errorText1", "errorText2")},
            {3, ImmutableList.of("errorText1", "errorText2", "errorText3")}
        };
    }
}
