package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class SelectDataProvider {

    @DataProvider(name = "simpleSelectTestData")
    public Object[][] simpleSelectTestData() {
        return new Object[][]{
                {"Henry"},
                {"Abbott"},
                {"Wilkerson"},
                {"Snyder"}
        };
    }

    @DataProvider(name = "categoryGroupingSelectTestData")
    public Object[][] categoryGroupingSelectTestData() {
        return new Object[][]{
                {"Category 1"},
                {"Category 2"}
        };
    }

    @DataProvider(name = "groupingSelectTestData")
    public Object[][] groupingSelectTestData() {
        return new Object[][]{
                {"Option 1"},
                {"Option 3"}
        };
    }

    @DataProvider(name = "ageSelectTestData")
    public Object[][] ageSelectTestData() {
        return new Object[][]{
                {"Ten"},
                {"Twenty"},
                {"Thirty"}
        };
    }

    @DataProvider(name = "nameNativeErrorSelectTestData")
    public Object[][] nameNativeErrorSelectTestData() {
        return new Object[][]{
                {"Olivier"},
                {"Hai"},
                {"Kevin"}
        };
    }
}
