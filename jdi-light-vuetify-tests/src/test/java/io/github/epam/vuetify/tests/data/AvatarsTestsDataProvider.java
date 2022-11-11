package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.INDIGO;
import static io.github.com.enums.Colors.ORANGE;
import static io.github.com.enums.Colors.TEAL;

public class AvatarsTestsDataProvider {

    @DataProvider(name = "colorAvatarTestData")
    public Object[][] colorAvatarTestData() {
        return new Object[][]{
                {1, INDIGO.value()},
                {2, TEAL.value()},
                {3, ORANGE.value()}
        };
    }

    @DataProvider(name = "sizeAvatarsTestData")
    public Object[][] sizeAvatarsTestData() {
        return new Object[][]{
                {1, 36},
                {2, 48},
                {3, 62}
        };
    }

    @DataProvider(name = "textAvatarsTestData")
    public Object[][] textAvatarsTestData() {
        return new Object[][]{
                {1, "36"},
                {2, "48"},
                {3, "62"}
        };
    }
}
