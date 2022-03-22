package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class ListsTestsDataProvider {


    @DataProvider(name = "denseListTestsData")
    public static Object[][] denseListTestsData() {
        return new Object[][]{
            {1, "Real-Time"},
            {2, "Audience"},
            {3, "Conversions"}
        };
    }

    @DataProvider(name = "threeLineListTestsData")
    public static Object[][] threeLineListTestsData() {
        return new Object[][]{
            {1, "Brunch this weekend?", "Ali Connors"},
            {2, "Summer BBQ 4", "to Alex, Scott, Jennifer"},
            {3, "Oui oui", "Sandra Adams"}
        };
    }

    @DataProvider(name = "actionAndItemGroupsListTestsData")
    public static Object[][] actionAndItemGroupsListTestsData() {
        return new Object[][]{
            {1}, {2}, {3}
        };
    }
}
