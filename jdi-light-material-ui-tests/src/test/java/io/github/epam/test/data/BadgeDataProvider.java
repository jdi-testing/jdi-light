package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static io.github.com.pages.displaydata.BadgePage.badgeDifferentPosition;

public class BadgeDataProvider {

    @DataProvider
    public static Object[][] alignmentBadges() {
        return new Object[][]{
                {badgeDifferentPosition.get(1), "-1", "TopRightRectangle"},
                {badgeDifferentPosition.get(2), "5", "BottomRightRectangle"},
                {badgeDifferentPosition.get(3), "6", "BottomLeftRectangle"},
                {badgeDifferentPosition.get(4), "7", "TopLeftRectangle"},
        };
    }

}
