package io.github.epam.test.data;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.testng.annotations.DataProvider;

public class BadgeDataProvider {

    @DataProvider
    public static Object[][] alignmentBadges() {
        return new Object[][]{
                {1, "-1", Position.TOP.getPosition() + Position.RIGHT.getPosition()},
                {2, "5", Position.BOTTOM.getPosition() + Position.RIGHT.getPosition()},
                {3, "6", Position.BOTTOM.getPosition() + Position.LEFT.getPosition()},
                {4, "7", Position.TOP.getPosition() + Position.LEFT.getPosition()},
        };
    }

}
