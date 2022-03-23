package io.github.epam.test.data;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.testng.annotations.DataProvider;

public class SnackbarsDataProvider {

    @DataProvider(name = "customizedSnackbarDataProvider")
    public Object[][] customizedSnackbarTestData() {
        return new Object[][]{
                {1, "This is an error message!", "error"},
                {2, "This is a warning message!", "warning"},
                {3, "This is an information message!", "info"},
                {4, "This is a success message!", "success"}
        };
    }

    @DataProvider(name = "positionedSnackbarDataProvider")
    public Object[][] positionedSnackbarTestData() {
        return new Object[][]{
                {1, Position.TOP_CENTER},
                {2, Position.TOP_RIGHT},
                {3, Position.BOTTOM_RIGHT},
                {4, Position.BOTTOM_CENTER},
                {5, Position.BOTTOM_LEFT},
                {6, Position.TOP_LEFT}
        };
    }

    @DataProvider(name = "messageLengthSnackbarDataProvider")
    public static Object[][] messageLengthSnackbarTestData() {
        return new Object[][] {
                {1, "I love snacks."},
                {2, "I love candy. I love cookies. I love cupcakes. I love cheesecake. I love chocolate."},
                {3, "I love candy. I love cookies. I love cupcakes."},
                {4, "I love candy. I love cookies. I love cupcakes. I love cheesecake. I love chocolate."},
        };
    }

    @DataProvider(name = "consecutiveSnackbarsDataProvider")
    public static Object[][] consecutiveSnackbarsTestData() {
        return new Object[][] {
                {1, "Message A", "SHOW MESSAGE A"},
                {2, "Message B", "SHOW MESSAGE B"},
        };
    }
}
