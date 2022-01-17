package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.badgePage;
import static io.github.com.pages.displaydata.BadgePage.badgeDifferentPosition;
import static io.github.com.pages.displaydata.BadgePage.buttonIncrease;
import static io.github.com.pages.displaydata.BadgePage.buttonReduce;
import static io.github.com.pages.displaydata.BadgePage.dotBadge;
import static io.github.com.pages.displaydata.BadgePage.errorColorBadge;
import static io.github.com.pages.displaydata.BadgePage.primaryColorBadge;
import static io.github.com.pages.displaydata.BadgePage.secondaryColorBadge;
import static io.github.com.pages.displaydata.BadgePage.switchShowBadge;
import static io.github.com.pages.displaydata.BadgePage.switchShowZero;

import com.epam.jdi.light.material.elements.displaydata.Badge;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BadgeTests extends TestsInit {

    @DataProvider
    public static Object[][] alignmentBadges() {
        return new Object[][]{
                {badgeDifferentPosition.get(1), "-1", "TopRightRectangle"},
                {badgeDifferentPosition.get(2), "5", "BottomRightRectangle"},
                {badgeDifferentPosition.get(3), "6", "BottomLeftRectangle"},
                {badgeDifferentPosition.get(4), "7", "TopLeftRectangle"},
        };
    }

    @BeforeMethod
    public void before() {
        badgePage.open();
        badgePage.isOpened();
    }

    @Test
    public void simpleBadgeTest() {
        primaryColorBadge.is().displayed()
                .and().has().text("4")
                .and().primaryColor()
                .and().position("TopRightRectangle");

        errorColorBadge.is().displayed()
                .and().has().text("4")
                .and().errorColor()
                .and().position("TopRightRectangle");
    }

    @Test
    public void variousBadgeTest() {
        secondaryColorBadge.is().displayed();
        secondaryColorBadge.has().text("1")
                .and().secondaryColor()
                .and().position("TopRightRectangle");

        buttonReduce.click();
        secondaryColorBadge.has().text("0").and().is().notVisible();

        switchShowZero.uncheck();
        secondaryColorBadge.has().secondaryColor();
        switchShowZero.check();
        secondaryColorBadge.is().notVisible();

        buttonIncrease.click();
        for (int i = 1; i <= 10; i++) {
            secondaryColorBadge.has().text(String.valueOf(i));
            buttonIncrease.click();
        }
        secondaryColorBadge.has().text("10+");
    }

    @Test
    public void dotBadgeTest() {
        dotBadge.is().displayed().and().is().dot()
                .and().has().secondaryColor().and().position("TopRightRectangle");

        switchShowBadge.uncheck();
        dotBadge.is().notVisible();
    }

    @Test(dataProvider = "alignmentBadges")
    public void alignmentBadgeTest(Badge badge, String text, String position) {
        badge.is().displayed()
                .and().has().text(text)
                .and().primaryColor()
                .and().position(position);
    }
}
