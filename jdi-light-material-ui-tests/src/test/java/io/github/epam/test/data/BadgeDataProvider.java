package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class BadgeDataProvider {

    @DataProvider
    public static Object[][] alignmentBadges() {
        return new Object[][]{
                {1, "-1", "TopRightRectangle"},
                {2, "5", "BottomRightRectangle"},
                {3, "6", "BottomLeftRectangle"},
                {4, "7", "TopLeftRectangle"},
        };
    }

}
