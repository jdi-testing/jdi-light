package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM_CENTER;
import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM_LEFT;
import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM_RIGHT;
import static com.epam.jdi.light.material.elements.utils.enums.Position.TOP_CENTER;
import static com.epam.jdi.light.material.elements.utils.enums.Position.TOP_LEFT;
import static com.epam.jdi.light.material.elements.utils.enums.Position.TOP_RIGHT;

public class SnackbarsDataProvider {

    @DataProvider(name = "positionedSnackbarDataProvider")
    public Object[][] positionedSnackbarTestData() {
        return new Object[][]{
                {1, TOP_CENTER.toString()},
                {2, TOP_RIGHT.toString()},
                {3, BOTTOM_RIGHT.toString()},
                {4, BOTTOM_CENTER.toString()},
                {5, BOTTOM_LEFT.toString()},
                {6, TOP_LEFT.toString()}
        };
    }
}
