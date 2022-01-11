package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class SnackbarsDataProvider {

    @DataProvider(name = "customizedSnackbarDataProvider")
    public Object[][] customizedSnackbarTestData() {
        return new Object[][]{
                {1, "This is an error message!", "error"}, {2, "This is a warning message!", "warning"},
                {3, "This is an information message!", "info"}, {4, "This is a success message!", "success"}
        };
    }

    @DataProvider(name = "positionedSnackbarDataProvider")
    public Object[][] positionedSnackbarTestData() {
        return new Object[][]{
                {1, "Top Center"}, {2, "Top Right"},
                {3, "Bottom Right"}, {4, "Bottom Center"},
                {5, "Bottom Left"}, {6, "Top Left"}
        };
    }

    @DataProvider(name = "complementaryProjectsSnackbarDataProvider")
    public Object[][] complementaryProjectsSnackbarTestData() {
        return new Object[][]{
                {1, "I love snacks."}, {2, "This is a success message!"}
        };
    }
}
