package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class SubheaderTestsDataProvider {

    @DataProvider(name = "gridTestData")
    public static Object[][] gridTestData() {
        return new Object[][] {
                {1, "May"},
                {2, "June"},
        };
    }

    @DataProvider(name = "socialMediaTestData")
    public static Object[][] socialMediaTestData() {
        return new Object[][] {
                {1, "Places to Be"},
                {2, "Places to See"},
        };
    }
}
