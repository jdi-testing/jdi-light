package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class FloatingActionButtonDataProvider {

    @DataProvider(name = "animatedButtonsTestData")
    public Object[][] animatedButtonsTestData() {
        return new Object[][] {
                {1, "Item One", "Last click: Add"},
                {2, "Item Two", "Last click: Edit"},
                {3, "Item Three", "Last click: Expand"},
        };
    }
}
