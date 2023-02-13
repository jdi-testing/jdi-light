package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class DataIteratorDataProvider {

    @DataProvider(name = "groupByDataIteratorTestData")
    public Object[][] groupByDataIteratorTestData() {
        return new Object[][] {
                {"calories", "159", 1},
                {"calories", "237", 1},
                {"calories", "262", 1},
                {"calories", "305", 1},
                {"iron", "1%", 2},
                {"iron", "7%", 1},
                {"iron", "8%", 1}
        };
    }
}
