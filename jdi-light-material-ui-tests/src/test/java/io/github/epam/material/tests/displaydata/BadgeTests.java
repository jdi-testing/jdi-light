package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.displaydata.BadgePage.*;
import static org.hamcrest.Matchers.not;

public class BadgeTests extends TestsInit {

    @Test
    public void simpleBadgeTest() {
        openSection("Badge");

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
        openSection("Badge");

        badgeWithVariableCounter.is().displayed();
        badgeWithVariableCounter.is().displayedSvg();
        badgeCounter.get(3).is().text("1");
        badgeCounter.get(3).has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorSecondary"));

        badgeButton.get(1).click();
        badgeCounter.get(3).is().text("0");
        badgeCounter.get(3).has().classValue(containsString("MuiBadge-invisible"));

        badgeToggler.get(1).click();
        badgeCounter.get(3).has().classValue(not(containsString("MuiBadge-invisible")));
        badgeButton.get(2).click();
        badgeCounter.get(3).is().text("1");
    }

    @Test
    public void dotBadgeTest() {
        openSection("Badge");

        dotBadge.is().displayed();
        dotBadge.is().displayedSvg();

        dot.has().classValue(containsString("MuiBadge-anchorOriginTopRightRectangle MuiBadge-colorSecondary"));
        badgeToggler.get(2).click();
        dot.has().classValue(containsString("MuiBadge-invisible"));
    }

    @Test
    public void alignmentBadgeTest() {
        openSection("Badge");

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
