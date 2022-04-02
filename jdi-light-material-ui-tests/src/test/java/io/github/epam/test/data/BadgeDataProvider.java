package io.github.epam.test.data;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.testng.annotations.DataProvider;

public class BadgeDataProvider {

    @DataProvider
    public Object[][] alignmentBadges() {
        return new Object[][]{
                {1, "-1", Position.TOP_RIGHT},
                {2, "5", Position.BOTTOM_RIGHT},
                {3, "6", Position.BOTTOM_LEFT},
                {4, "7", Position.TOP_LEFT},
        };
    }

}
