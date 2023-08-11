package io.github.epam.data;

import org.testng.annotations.DataProvider;

public class ButtonsTestsDataProvider {

    @DataProvider(name = "textButtonsTestsData")
    public static Object[][] textButtonsTestsData() {
        return new Object[][] {
            {1, "Basic", ""},
            {2, "Primary", "primary"},
            {3, "Accent", "accent"},
            {4, "Warn", "warn"},
            {5, "Disabled", ""},
            {6, "Link", ""}
        };
    }

    @DataProvider(name = "textFabButtonsTestsData")
    public static Object[][] textFabButtonsTestsData() {
        return new Object[][] {
            {1, "Basic", "", "Basic"},
            {2, "Primary", "primary", "Primary"},
            {3, "Accent", "accent", "Accent"},
            {4, "Warn", "warn", "Warn"},
            {5, "Disabled", "", "Disabled"},
            {6, "favorite", "", "Icon with a heart icon"},
            {7, "Link", "", "Link"}
        };
    }

    @DataProvider(name = "textIconButtonsTestsData")
    public static Object[][] textIconButtonsTestsData() {
        return new Object[][] {
            {1, "favorite", "", "Basic"},
            {2, "favorite", "primary", "Primary"},
            {3, "favorite", "accent", "Accent"},
            {4, "favorite", "warn", "Warn"},
            {5, "favorite", "", "Disabled"}
        };
    }
}
