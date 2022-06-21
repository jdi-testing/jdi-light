package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.material.elements.utils.enums.Position.TOP_RIGHT;
import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM_RIGHT;
import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM_LEFT;
import static com.epam.jdi.light.material.elements.utils.enums.Position.TOP_LEFT;

public class BadgeDataProvider {

    @DataProvider
    public Object[][] alignmentBadges() {
        return new Object[][]{
                {1, "-1", TOP_RIGHT.toString()},
                {2, "5", BOTTOM_RIGHT.toString()},
                {3, "6", BOTTOM_LEFT.toString()},
                {4, "7", TOP_LEFT.toString()},
        };
    }

}
