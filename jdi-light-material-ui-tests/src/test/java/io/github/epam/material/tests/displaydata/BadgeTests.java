package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.badgePage;
import static io.github.com.pages.displaydata.BadgePage.badge;
import static io.github.com.pages.displaydata.BadgePage.badgeButton;
import static io.github.com.pages.displaydata.BadgePage.badgeCounter;
import static io.github.com.pages.displaydata.BadgePage.badgeCounterWithDifferentPosition;
import static io.github.com.pages.displaydata.BadgePage.badgeDifferentPosition;
import static io.github.com.pages.displaydata.BadgePage.badgeSwitch;
import static io.github.com.pages.displaydata.BadgePage.badgeWithVariableCounter;
import static io.github.com.pages.displaydata.BadgePage.dotBadge;
import static io.github.com.pages.displaydata.BadgePage.dot;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

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
        primaryBadge.is().displayed();
        primaryBadge.is().displayedSvg();
        primaryBadgeCounter.is().text("4");
        primaryBadgeCounter.has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorPrimary"));

        errorBadge.is().displayed();
        errorBadge.is().displayedSvg();
        errorBadgeCounter.is().text("4");
        errorBadgeCounter.has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorError"));
    }

    @Test
    public void variousBadgeTest() {
        variousBadge.is().displayed();
        variousBadge.is().displayedSvg();
        variousBadgeCounter.is().text("1");
        variousBadgeCounter.has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorSecondary"));

        buttonReduce.click();
        variousBadgeCounter.is().text("0");
        variousBadgeCounter.has().classValue(containsString("MuiBadge-invisible"));

        switchShowZero.uncheck();
        variousBadgeCounter.has().classValue(not(containsString("MuiBadge-invisible")));
        buttonIncrease.click();
        variousBadgeCounter.is().text("1");

        int loop = 0;
        while (loop < 10) {
            buttonIncrease.click();
            loop++;
        }
        variousBadgeCounter.is().text("10+");
    }

    @Test
    public void dotBadgeTest() {
        dotBadge.is().displayed();
        dotBadge.is().displayedSvg();

        dot.has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorSecondary"));
        switchShowBadge.uncheck();
        dot.has().classValue(containsString("MuiBadge-invisible"));
    }

    @Test
    public void alignmentBadgeTest() {

        badgeDifferentPosition.get(1).is().displayed();
        badgeDifferentPosition.get(1).is().displayedSvg();
        badgeCounterWithDifferentPosition.get(1).is().text("-1");
        badgeCounterWithDifferentPosition.get(1).has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorPrimary"));

        badgeDifferentPosition.get(2).is().displayed();
        badgeDifferentPosition.get(2).is().displayedSvg();
        badgeCounterWithDifferentPosition.get(2).is().text("5");
        badgeCounterWithDifferentPosition.get(2).has().classValue(containsString("MuiBadge-anchorOriginBottomRightRectangle MuiBadge-colorPrimary"));

        badgeDifferentPosition.get(3).is().displayed();
        badgeDifferentPosition.get(3).is().displayedSvg();
        badgeCounterWithDifferentPosition.get(3).is().text("6");
        badgeCounterWithDifferentPosition.get(3).has().classValue(containsString("MuiBadge-anchorOriginBottomLeftRectangle MuiBadge-colorPrimary"));

        badgeDifferentPosition.get(4).is().displayed();
        badgeDifferentPosition.get(4).is().displayedSvg();
        badgeCounterWithDifferentPosition.get(4).is().text("7");
        badgeCounterWithDifferentPosition.get(4).has().classValue(containsString("MuiBadge-anchorOriginTopLeftRectangle MuiBadge-colorPrimary"));
    }
}
