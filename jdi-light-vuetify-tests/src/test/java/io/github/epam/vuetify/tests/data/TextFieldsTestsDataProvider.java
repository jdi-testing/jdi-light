package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

public class TextFieldsTestsDataProvider {

    @DataProvider(name = "counterTextFieldTestDataProvider")
    public static Object[][] counterTextFieldTestsData() {
        return new Object[][] {
                {1, "Preliminary report", "Preliminary report".length(), 25},
                {2, "California is a state in the western United States", "California is a state in the western United States".length(), 25},
                {3, "Preliminary report", 2, 5},
                {4, "Preliminary report", 2, 5}
        };
    }

    @DataProvider(name = "customColorsTextFieldTestDataProvider")
    public static Object[][] customColorsTextFieldTestsData() {
        return new Object[][] {
                {1, "purple"},
                {2, "blue"},
                {3, "teal"}
        };
    }
}
