package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class SelectDataProvider {

    @DataProvider(name = "controlledOpenSelectTestData")
    public static Object[][] controlledOpenSelectTestData() {
        return new Object[][] {
                {"Ten"},
                {"Twenty"},
                {"Thirty"},
        };
    }
}
