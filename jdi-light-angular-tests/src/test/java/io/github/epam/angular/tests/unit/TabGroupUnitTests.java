package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.tabsSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class TabGroupUnitTests extends TestsInit {

    public static final String CLASS_ATTR = "class";
    public static final String ACCENT = "accent";
    public static final String PRIMARY = "primary";
    private static final List<String> TABS_TITLES_DEFAULT_LIST = Arrays.asList("First", "Second", "Third");
    private static final List<String> TABS_LINKS_TITLES = Arrays.asList("First", "Second", "Third", "Disabled Link");

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void clickTest() {
        int tabNumberForTest = 3;
        tabsSection.basicTab.clickTab(tabNumberForTest);
        assertTrue(tabsSection.basicTab.tabIsHighlighted(tabNumberForTest));
    }

    @Test
    public void clickByNameTest() {
        int tabNumberForTest = 3;
        String tabNameForeTest = "Third";
        tabsSection.basicTab.clickTab(tabNameForeTest);
        assertTrue(tabsSection.basicTab.tabIsHighlighted(tabNumberForTest));
    }

    @Test
    public void tabsTitlesContainValuesTest() {
        assertTrue(tabsSection.basicTab.tabsTitlesContainValues(TABS_TITLES_DEFAULT_LIST));
    }

    @Test
    public void tabIsHighlightedTest() {
        int tabNumberForTest = 3;
        tabsSection.basicTab.clickTab(tabNumberForTest);
        assertTrue(tabsSection.basicTab.tabIsHighlighted(tabNumberForTest));
    }

    @Test
    public void tabPanelContainsValueTest() {
        int tabNumberForTest = 2;
        String stringForTest = format("Content %s", tabNumberForTest);
        tabsSection.basicTab.clickTab(tabNumberForTest);
        assertTrue(tabsSection.basicTab.tabPanelContainsValue(stringForTest));
    }

    @Test
    public void clickTabLinkTest() {
        String tabNameForeTest = "Third";
        tabsSection.tabsNavBar.clickTabLink(tabNameForeTest);
        assertTrue(tabsSection.tabsNavBar.tabWithLinkIsHighlighted(tabNameForeTest));
    }

    @Test
    public void tabsLinksTitlesContainValuesTest() {
        assertTrue(tabsSection.tabsNavBar.tabsLinksTitlesContainValues(TABS_LINKS_TITLES));
    }

    @Test
    public void tabWithLinkIsHighlightedTest() {
        String tabNameForeTest = "Third";
        tabsSection.tabsNavBar.clickTabLink(tabNameForeTest);
        assertTrue(tabsSection.tabsNavBar.tabWithLinkIsHighlighted(tabNameForeTest));
    }

    @Test
    public void verifyCustomThemeHighlighterColor() {
        tabsSection.matButtonToggleGroupColor.clickButtonToggleByValue(ACCENT);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-background-primary mat-accent");
        tabsSection.matButtonToggleGroupColor.clickButtonToggleByValue(PRIMARY);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-background-primary mat-primary");
    }
}
