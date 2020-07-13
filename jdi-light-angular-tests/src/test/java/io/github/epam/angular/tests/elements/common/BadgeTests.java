package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.badgeSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicBadgeTest() {
        badgeSection.badgeWithText.is().displayed();
        badgeSection.badgeWithButton.is().displayed();
        badgeSection.badgeWithIcon.is().displayed();
    }

    @Test
    public void badgeTextTest() {
        badgeSection.badgeWithText.has().text("4");
        badgeSection.badgeWithButton.has().text("8");
        badgeSection.badgeWithIcon.has().text("15");
    }

    @Test
    public void hiddenMessageTest() {
        badgeSection.hiddenText.isNotExist();
        badgeSection.buttonWithBadge.click();
        badgeSection.hiddenText.is().displayed();
        badgeSection.hiddenText.has().text("Top secret message");
    }

    @Test
    public void textOnShowMessageButtonTest() {
        badgeSection.textOnButton.has().text("Show message");
        badgeSection.buttonWithBadge.click();
        badgeSection.textOnButton.has().text("Hide message");
    }
}
