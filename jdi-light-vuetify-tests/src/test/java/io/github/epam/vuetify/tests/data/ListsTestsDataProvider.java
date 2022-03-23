package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class ListsTestsDataProvider {


    @DataProvider(name = "basicFunctionalityTestsData")
    public static Object[][] basicFunctionalityTestsData() {
        return new Object[][] {
            {1, "Real-Time"},
            {2, "Audience"},
            {3, "Conversions"}
        };
    }
}
