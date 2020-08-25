package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.tabsSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class ButtonToggleUnitTests extends TestsInit {

    public static final String CLASS_ATTR = "class";
    public static final String ACCENT = "accent";
    public static final String PRIMARY = "primary";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyCustomThemeHighlighterColor() {
        tabsSection.matButtonToggleGroupColor.clickButtonByValue(ACCENT);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-background-primary mat-accent");
        tabsSection.matButtonToggleGroupColor.clickButtonByValue(PRIMARY);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-background-primary mat-primary");
    }
}

