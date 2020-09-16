package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.BadgeSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicBadgeTest() {
        textWithBadge.show();
        textWithBadge.getBadge().is().displayed();
        textWithBadge.getBadge().has().text("4");
    }
//
//    @Test
//    public void badgeTextTest() {
//        badgeWithText.has().text("4");
//        badgeWithButton.has().text("8");
//        badgeWithIcon.has().text("15");
//    }
//
//    @Test
//    public void hiddenMessageTest() {
//        hiddenText.isNotExist();
//        buttonWithBadge.click();
//        hiddenText.is().displayed();
//        hiddenText.has().text("Top secret message");
//        buttonWithBadge.click();
//    }
//
//    @Test
//    public void textOnShowMessageButtonTest() {
//        textOnButton.has().text("Show message");
//        buttonWithBadge.click();
//        textOnButton.has().text("Hide message");
//        buttonWithBadge.click();
//    }
}
