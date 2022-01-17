package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        badgePage.open();
        badgePage.isOpened();
    }

    @Test
    public void simpleBadgeTest() {
        primaryColorBadge.is().displayed();
        primaryColorBadge.has().counterValue("4");
        primaryColorBadge.has().primaryColor();
        primaryColorBadge.has().position("TopRightRectangle");

        errorColorBadge.is().displayed();
        errorColorBadge.has().counterValue("4");
        errorColorBadge.has().errorColor();
        errorColorBadge.has().position("TopRightRectangle");
    }

    @Test
    public void variousBadgeTest() {
        secondaryColorBadge.is().displayed();
        secondaryColorBadge.has().counterValue("1");
        secondaryColorBadge.has().secondaryColor();
        secondaryColorBadge.has().position("TopRightRectangle");
        buttonReduce.click();
        secondaryColorBadge.has().counterValue("0");
        secondaryColorBadge.is().invisible();
        switchShowZero.uncheck();
        secondaryColorBadge.has().secondaryColor();
        switchShowZero.check();
        secondaryColorBadge.is().invisible();
        buttonIncrease.click();
        secondaryColorBadge.has().counterValue("1");
        secondaryColorBadge.has().secondaryColor();

        int loop = 0;
        while (loop < 10) {
            buttonIncrease.click();
            loop++;
        }
        secondaryColorBadge.has().counterValue("10+");
    }

    @Test
    public void dotBadgeTest() {
        dotBadge.is().displayed();
        dotBadge.is().dot();
        dotBadge.has().secondaryColor();
        dotBadge.has().position("TopRightRectangle");
        switchShowBadge.uncheck();
        dotBadge.is().invisible();
    }

    @Test
    public void alignmentBadgeTest() {

        badgeDifferentPosition.get(1).is().displayed();
        badgeDifferentPosition.get(1).has().counterValue("-1");
        badgeDifferentPosition.get(1).has().primaryColor();
        badgeDifferentPosition.get(1).has().position("TopRightRectangle");

        badgeDifferentPosition.get(2).is().displayed();
        badgeDifferentPosition.get(2).has().counterValue("5");
        badgeDifferentPosition.get(2).has().primaryColor();
        badgeDifferentPosition.get(2).has().position("BottomRightRectangle");

        badgeDifferentPosition.get(3).is().displayed();
        badgeDifferentPosition.get(3).has().counterValue("6");
        badgeDifferentPosition.get(3).has().primaryColor();
        badgeDifferentPosition.get(3).has().position("BottomLeftRectangle");

        badgeDifferentPosition.get(4).is().displayed();
        badgeDifferentPosition.get(4).has().counterValue("7");
        badgeDifferentPosition.get(4).has().primaryColor();
        badgeDifferentPosition.get(4).has().position("TopLeftRectangle");
    }
}
