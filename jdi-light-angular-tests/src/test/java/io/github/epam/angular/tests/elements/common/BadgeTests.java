package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.BadgePosition.ABOVE;
import static com.epam.jdi.light.angular.elements.enums.BadgePosition.AFTER;
import static com.epam.jdi.light.angular.elements.enums.BadgePosition.BEFORE;
import static com.epam.jdi.light.angular.elements.enums.BadgePosition.BELOW;
import static com.epam.jdi.light.angular.elements.enums.BadgeSize.LARGE;
import static com.epam.jdi.light.angular.elements.enums.BadgeSize.MEDIUM;
import static com.epam.jdi.light.angular.elements.enums.BadgeSize.SMALL;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.badgePage;
import static io.github.com.enums.Colors.AMBER_ACCENT_2;
import static io.github.com.enums.Colors.DEEP_PURPLE;
import static io.github.com.enums.Colors.RED;
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
        textWithBadge.show();
    }

    @Test(description = "The test checks color of the badge and content (string/number)")
    public void colorAndContentBadgeTest() {
        iconWithBadge.is().displayed()
                .has().text("15")
                .and().has().color(RED.value());
        buttonWithBadge.is().displayed()
                .has().text("8")
                .and().has().color(AMBER_ACCENT_2.value());
        customSizeBadge.is().displayed()
                .has().text("Best")
                .and().has().color(DEEP_PURPLE.value());
    }

    @Test(description = "Test checks if the badge is disabled/enabled")
    public void disabledBadgeTest() {
        toggleDisabledBadge.is().disabled();

        toggleDisabledBadge.click();
        toggleDisabledBadge.is().enabled();

        toggleDisabledBadge.click();
        toggleDisabledBadge.is().disabled();
    }

    @Test(description = "Test checks the visibility of the badge")
    public void hiddenBadgeTest() {
        toggleVisibilityBadge.is().displayed();
        toggleVisibilityBadge.click();
        toggleVisibilityBadge.is().hidden();
        toggleVisibilityBadge.click();
        toggleVisibilityBadge.is().displayed();
    }

    @Test(description = "Test checks if badge overlaps")
    public void overlapBadgeTest() {
        textWithBadge.is().overlap(false);

        buttonWithBadge.is().overlap(true);
    }

    @Test(description = "Test check position of the badge")
    public void positionOfTheBadgeTest() {
        buttonWithBadge.has().positionVertical(ABOVE)
                .and().has().positionHorizontal(BEFORE);

        textWithBadge.has().positionVertical(ABOVE)
                .and().has().positionHorizontal(AFTER);

        bellowPositionBadge.has().positionVertical(BELOW)
                .and().has().positionHorizontal(AFTER);
    }

    @Test(description = "Test checks size of the badge")
    public void sizeOfTheBadgeTest() {
        largeBadge.is().displayed()
                .and().has().size(LARGE);

        smallBadge.is().displayed()
                .and().has().size(SMALL);

        textWithBadge.is().displayed()
                .and().has().size(MEDIUM);
    }
}
