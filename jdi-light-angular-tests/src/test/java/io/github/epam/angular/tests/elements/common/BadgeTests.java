package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.BadgeSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class BadgeTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
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
}
