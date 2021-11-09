package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PURPLE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.TEAL;

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
                {1, PURPLE_DARKEN_2.value()},
                {2, BLUE_DARKEN_2.value()},
                {3, TEAL.value()}
        };
    }
}
