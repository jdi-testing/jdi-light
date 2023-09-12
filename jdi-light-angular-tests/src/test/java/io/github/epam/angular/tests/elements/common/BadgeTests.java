package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.light.angular.elements.enums.BadgeSize;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.BadgePosition.ABOVE;
import static com.epam.jdi.light.angular.elements.enums.BadgePosition.AFTER;
import static com.epam.jdi.light.angular.elements.enums.BadgePosition.BEFORE;
import static com.epam.jdi.light.angular.elements.enums.BadgePosition.BELOW;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.badgePage;
import static io.github.com.enums.Colors.AMBER_ACCENT_2;
import static io.github.com.enums.Colors.DEEP_PURPLE;
import static io.github.com.enums.Colors.RED;
import static io.github.com.pages.BadgePage.belowPositionBadge;
import static io.github.com.pages.BadgePage.buttonWithBadge;
import static io.github.com.pages.BadgePage.elementWithCustomSizeBadge;
import static io.github.com.pages.BadgePage.iconWithBadge;
import static io.github.com.pages.BadgePage.textWithBadge;
import static io.github.com.pages.BadgePage.buttonToggleDisabledBadge;
import static io.github.com.pages.BadgePage.buttonToggleVisibilityBadge;
import static io.github.com.pages.BadgePage.textWithLargeBadge;
import static io.github.com.pages.BadgePage.textWithSmallBadge;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        badgePage.open();
        waitCondition(() -> badgePage.isOpened());
        badgePage.checkOpened();
        textWithBadge.show();
    }


    @Test(description = "Test checks if the badge is disabled/enabled")
    public void disabledBadgeTest() {
        buttonToggleDisabledBadge
                .has().badgeDisabled();
        buttonToggleDisabledBadge.click();
        buttonToggleDisabledBadge
                .has().badgeEnabled();
        buttonToggleDisabledBadge.click();
        buttonToggleDisabledBadge
                .has().badgeDisabled();
    }

    @Test(description = "Test checks the visibility of the badge")
    public void hiddenBadgeTest() {
        buttonToggleVisibilityBadge
                .has().badgeDisplayed();
        buttonToggleVisibilityBadge.click();
        buttonToggleVisibilityBadge
                .has().badgeHidden();
        buttonToggleVisibilityBadge.click();
        buttonToggleVisibilityBadge
                .has().badgeDisplayed();
    }

    @Test(description = "Test checks if badge overlaps")
    public void overlapBadgeTest() {
        textWithLargeBadge
                .has().badgeOverlap(true);
        buttonWithBadge
                .has().badgeOverlap(true);
    }

    @Test(description = "Test check position of the badge")
    public void positionOfTheBadgeTest() {
        buttonWithBadge
                .has().badgePositionVertical(ABOVE);
        buttonWithBadge
                .has().badgePositionHorizontal(BEFORE);

        textWithBadge
                .has().badgePositionVertical(ABOVE);
        textWithBadge
                .has().badgePositionHorizontal(AFTER);

        belowPositionBadge
                .has().badgePositionVertical(BELOW);
        belowPositionBadge
                .has().badgePositionHorizontal(AFTER);
    }

    @Test(description = "Test checks size of the badge")
    public void sizeOfTheBadgeTest() {
        textWithLargeBadge
                .has().badgeDisplayed();
        textWithLargeBadge
                .has().badgeSize(BadgeSize.LARGE);

        textWithSmallBadge
                .has().badgeDisplayed();
        textWithSmallBadge.has().badgeSize(BadgeSize.SMALL);

        textWithBadge
                .has().badgeDisplayed();
        textWithBadge
                .has().badgeSize(BadgeSize.MEDIUM);
    }

    @Test(description = "simple checks for badge")
    public void checkIfTextHasBadge() {
        textWithBadge
                .has().badgeDisabled();
        textWithBadge
                .badge()
                .has().text("4");
    }

    @Test(description = "The test checks color of the badge and content (string/number) using badge()")
    public void colorAndContentBadgeTest() {
        iconWithBadge.badge()
                .is().displayed()
                .has().text("15")
                .and()
                .has().color(RED.value());

        buttonWithBadge.badge()
                .is().displayed()
                .has().text("8")
                .and().has().color(AMBER_ACCENT_2.value());

        elementWithCustomSizeBadge.badge()
                .is().displayed()
                .has().text("Best")
                .and().has().color(DEEP_PURPLE.value());
    }
}
