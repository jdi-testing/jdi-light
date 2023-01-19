package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.material.elements.utils.enums.Position.TOP;
import static com.epam.jdi.light.material.elements.utils.enums.Position.LEFT;
import static com.epam.jdi.light.material.elements.utils.enums.Position.RIGHT;
import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM;

public class PopperDataProvider {

    @DataProvider
    public Object[][] positionedPopperDataProvider() {
        return new Object[][] {
            {1, "TOP", TOP.toString()},
            {2, "LEFT", LEFT.toString()},
            {3, "RIGHT", RIGHT.toString()},
            {4, "BOTTOM", BOTTOM.toString()}
        };
    }
}
