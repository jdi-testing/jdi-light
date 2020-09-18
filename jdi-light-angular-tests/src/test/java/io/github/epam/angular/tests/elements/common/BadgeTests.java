package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.light.angular.elements.common.Badge;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.BadgeSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BadgeTests extends TestsInit {
    public String getColor(String bgValue) {
        switch (bgValue) {
            case "rgba(103, 58, 183, 1)" :
                return "violet";
            case "rgba(244, 67, 54, 1)" :
                return "red";
            default: return "unknown color";
        }
    }
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicBadgeTest() {
        String color = getColor(textWithBadge.badge().color());
        String color2 = getColor(iconWithBadge.badge().color());

        String color3 = getColor(textButton.with(Badge.class).color());

        badgeWithText.is().displayed();
        badgeWithButton.is().displayed();
        badgeWithIcon.is().displayed();
    }

    @Test
    public void badgeTextTest() {
        badgeWithText.has().text("4");
        badgeWithButton.has().text("8");
        badgeWithIcon.has().text("15");
    }

    @Test
    public void hiddenMessageTest() {
        hiddenText.isNotExist();
        buttonWithBadge.click();
        hiddenText.is().displayed();
        hiddenText.has().text("Top secret message");
        buttonWithBadge.click();
    }

    @Test
    public void textOnShowMessageButtonTest() {
        textOnButton.has().text("Show message");
        buttonWithBadge.click();
        textOnButton.has().text("Hide message");
        buttonWithBadge.click();
    }
}
