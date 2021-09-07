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

        badge.get(1).is().displayed();
        badge.get(1).is().displayedSvg();
        badgeCounter.get(1).is().text("4");
        badgeCounter.get(1).has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorPrimary"));

        badge.get(2).is().displayed();
        badge.get(2).is().displayedSvg();
        badgeCounter.get(2).is().text("4");
        badgeCounter.get(2).has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorError"));
    }

    @Test
    public void variousBadgeTest() {

        badgeWithVariableCounter.is().displayed();
        badgeWithVariableCounter.is().displayedSvg();
        badgeCounter.get(3).is().text("1");
        badgeCounter.get(3).has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorSecondary"));

        badgeButton.get(1).click();
        badgeCounter.get(3).is().text("0");
        badgeCounter.get(3).has().classValue(containsString("MuiBadge-invisible"));

        badgeSwitch.get(1).uncheck();
        badgeCounter.get(3).has().classValue(not(containsString("MuiBadge-invisible")));
        badgeButton.get(2).click();
        badgeCounter.get(3).is().text("1");
    }

    @Test
    public void dotBadgeTest() {

        dotBadge.is().displayed();
        dotBadge.is().displayedSvg();

        dot.has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorSecondary"));
        badgeSwitch.get(2).uncheck();
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
