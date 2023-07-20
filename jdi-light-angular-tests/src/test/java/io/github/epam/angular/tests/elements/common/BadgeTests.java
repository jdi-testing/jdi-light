package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.badgePage;
import static io.github.com.pages.BadgePage.bellowPositionBadge;
import static io.github.com.pages.BadgePage.buttonWithBadge;
import static io.github.com.pages.BadgePage.customSizeBadge;
import static io.github.com.pages.BadgePage.iconWithBadge;
import static io.github.com.pages.BadgePage.largeBadge;
import static io.github.com.pages.BadgePage.smallBadge;
import static io.github.com.pages.BadgePage.textWithBadge;
import static io.github.com.pages.BadgePage.toggleDisabledBadge;
import static io.github.com.pages.BadgePage.toggleVisibilityBadge;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        badgePage.open();
        waitCondition(() -> badgePage.isOpened());
        badgePage.checkOpened();
    }

    @Test
    public void basicBadgeTest() {
        textWithBadge.show();
        textWithBadge.badge().is().displayed();
        textWithBadge.badge().has().text("4");
        textWithBadge.has().color("Violet");
    }

    @Test
    public void buttonBadgeTest() {
        buttonWithBadge.show();
        buttonWithBadge.badge().is().displayed();
        buttonWithBadge.badge().has().text("8");
        buttonWithBadge.has().color("Yellow");
    }

    @Test
    public void iconBadgeTest() {
        iconWithBadge.show();
        iconWithBadge.badge().is().displayed();
        iconWithBadge.badge().has().text("15");
        iconWithBadge.has().color("Red");
    }

    @Test
    public void badgeWithTextTest() {
        customSizeBadge.badge().is().displayed();
        customSizeBadge.badge().has().text("Best");
        customSizeBadge.has().color("Violet");

    }

    @Test
    public void disabledBadgeTest() {
        toggleDisabledBadge.is().disabled();
        toggleVisibilityBadge.click();
        toggleVisibilityBadge.is().enabled();
        toggleVisibilityBadge.click();
        toggleDisabledBadge.is().disabled();
    }

    @Test
    public void hiddenBadgeTest() {
        toggleVisibilityBadge.is().displayed();
        toggleVisibilityBadge.click();
        toggleVisibilityBadge.is().hidden();
        toggleVisibilityBadge.click();
        toggleVisibilityBadge.is().displayed();
    }

    @Test
    public void overlapBadgeTest() {
        textWithBadge.is().overlap(false);
        buttonWithBadge.is().overlap(true);
    }

    @Test
    public void positionOfTheBadgeTest() {
        buttonWithBadge.has().positionVertical("above");
        buttonWithBadge.has().positionHorizontal("before");

        textWithBadge.has().positionVertical("above");
        textWithBadge.has().positionHorizontal("after");

        bellowPositionBadge.has().positionVertical("below");
        bellowPositionBadge.has().positionHorizontal("after");
    }

    @Test
    public void sizeOfTheBadgeTest() {
        largeBadge.badge().is().displayed();
        largeBadge.has().size("large");

        smallBadge.badge().is().displayed();
        smallBadge.has().size("small");

        textWithBadge.badge().is().displayed();
        textWithBadge.has().size("medium");
    }
}
