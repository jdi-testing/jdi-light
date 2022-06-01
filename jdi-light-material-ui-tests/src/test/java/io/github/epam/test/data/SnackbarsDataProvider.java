package io.github.epam.test.data;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.testng.annotations.DataProvider;

public class SnackbarsDataProvider {

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
}
