package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class SelectDataProvider {

    @DataProvider(name = "ageSelectTestData")
    public static Object[][] ageSelectTestData() {
        return new Object[][] {
                {"Ten"},
                {"Twenty"},
                {"Thirty"},
        };
    }
}
