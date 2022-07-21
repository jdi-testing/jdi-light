package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.PURPLE_DARKEN_2;
import static io.github.com.enums.Colors.TEAL;

public class TextFieldsTestsDataProvider {

    @DataProvider(name = "customColorsTextFieldTestDataProvider")
    public static Object[][] customColorsTextFieldTestsData() {
        return new Object[][] {
                {1, PURPLE_DARKEN_2.value()},
                {2, BLUE_DARKEN_2.value()},
                {3, TEAL.value()}
        };
    }
}
