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

/**
 * To see an example of Chips web element please visit
 * https://material-ui.com/ru/components/badges/
 */

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        badgePage.open();
    }

    @Test
    public void simpleBadgeTest() {
        primaryColorBadge.is().displayed();
        primaryColorBadge.is().displayedSvg();
        primaryColorBadge.has().counterValue("4");
        primaryColorBadge.has().iconVisibilityStatus("colorPrimary");
        primaryColorBadge.has().iconPosition("TopRightRectangle");

        errorColorBadge.is().displayed();
        errorColorBadge.is().displayedSvg();
        errorColorBadge.has().counterValue("4");
        errorColorBadge.has().iconVisibilityStatus("colorError");
        errorColorBadge.has().iconPosition("TopRightRectangle");
    }

    @Test
    public void variousBadgeTest() {
        secondaryColorBadge.is().displayed();
        secondaryColorBadge.is().displayedSvg();
        secondaryColorBadge.has().counterValue("1");
        secondaryColorBadge.has().iconVisibilityStatus("colorSecondary");
        secondaryColorBadge.has().iconPosition("TopRightRectangle");
        buttonReduce.click();
        secondaryColorBadge.has().counterValue("0");
        secondaryColorBadge.has().iconVisibilityStatus("invisible");
        switchShowZero.uncheck();
        secondaryColorBadge.has().iconVisibilityStatus("colorSecondary");
        switchShowZero.check();
        secondaryColorBadge.has().iconVisibilityStatus("invisible");
        buttonIncrease.click();
        secondaryColorBadge.has().counterValue("1");
        secondaryColorBadge.has().iconVisibilityStatus("colorSecondary");

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
        dotBadge.is().displayedSvg();
        dotBadge.has().dot();
        dotBadge.has().iconVisibilityStatus("colorSecondary");
        dotBadge.has().iconPosition("TopRightRectangle");
        switchShowBadge.uncheck();
        dotBadge.has().iconVisibilityStatus("invisible");
    }

    @Test
    public void alignmentBadgeTest() {

        badgeDifferentPosition.get(1).is().displayed();
        badgeDifferentPosition.get(1).is().displayedSvg();
        badgeDifferentPosition.get(1).has().counterValue("-1");
        badgeDifferentPosition.get(1).has().iconVisibilityStatus("colorPrimary");
        badgeDifferentPosition.get(1).has().iconPosition("TopRightRectangle");

        badgeDifferentPosition.get(2).is().displayed();
        badgeDifferentPosition.get(2).is().displayedSvg();
        badgeDifferentPosition.get(2).has().counterValue("5");
        badgeDifferentPosition.get(2).has().iconVisibilityStatus("colorPrimary");
        badgeDifferentPosition.get(2).has().iconPosition("BottomRightRectangle");

        badgeDifferentPosition.get(3).is().displayed();
        badgeDifferentPosition.get(3).is().displayedSvg();
        badgeDifferentPosition.get(3).has().counterValue("6");
        badgeDifferentPosition.get(3).has().iconVisibilityStatus("colorPrimary");
        badgeDifferentPosition.get(3).has().iconPosition("BottomLeftRectangle");

        badgeDifferentPosition.get(4).is().displayed();
        badgeDifferentPosition.get(4).is().displayedSvg();
        badgeDifferentPosition.get(4).has().counterValue("7");
        badgeDifferentPosition.get(4).has().iconVisibilityStatus("colorPrimary");
        badgeDifferentPosition.get(4).has().iconPosition("TopLeftRectangle");
    }
}
