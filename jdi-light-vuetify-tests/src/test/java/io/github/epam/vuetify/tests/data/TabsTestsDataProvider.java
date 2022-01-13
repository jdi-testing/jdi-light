package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class TabsTestsDataProvider {

    @DataProvider(name = "alignWithTitleTabsTestsData")
    public static Object[][] alignWithTitleTabsTestsData() {
        return new Object[][]{
                {1, "WEB"}, {2, "SHOPPING"}, {3, "VIDEOS"},
                {4, "IMAGES"}, {5, "NEWS"}
        };
    }

    @DataProvider(name = "centerActiveTabsTestsData")
    public static Object[][] centerActiveTabsTestsData() {
        return new Object[][]{
                {1, "ONE"}, {2, "TWO"}, {5, "FIVE"}, {8, "EIGHT"}
        };
    }

    @DataProvider(name = "fixedTabsTestsData")
    public static Object[][] fixedTabsTestsData() {
        return new Object[][]{
                {1, "OPTION"}, {2, "ANOTHER SELECTION"}, {3, "ITEMS"}, {4, "ANOTHER SCREEN"}
        };
    }

    @DataProvider(name = "growTabsTestsData")
    public static Object[][] growTabsTestsData() {
        return new Object[][]{
                {1, "APPETIZERS"}, {2, "ENTREES"}, {3, "DESERTS"}, {4, "COCKTAILS"}
        };
    }
}
