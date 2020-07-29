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

public class TabsUnitTests extends TestsInit {

    private final List<String> TABS_TITLES_DEFAULT_LIST = Arrays.asList("First", "Second", "Third");
    List<String> TABS_LINKS_TITLES = Arrays.asList("First", "Second", "Third", "Disabled Link");

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void clickTest() {
        int tabNumberForTest = 3;
        tabsSection.basicTabsSection.clickTab(tabNumberForTest);
        assertTrue(tabsSection.basicTabsSection.tabIsHighlighted(tabNumberForTest));
    }

    @Test
    public void clickByNameTest() {
        int tabNumberForTest = 3;
        String tabNameForeTest = "Third";
        tabsSection.basicTabsSection.clickTab(tabNameForeTest);
        assertTrue(tabsSection.basicTabsSection.tabIsHighlighted(tabNumberForTest));
    }

    @Test
    public void tabsTitlesContainValuesTest() {
        assertTrue(tabsSection.basicTabsSection.tabsTitlesContainValues(TABS_TITLES_DEFAULT_LIST));
    }

    @Test
    public void tabIsHighlightedTest() {
        int tabNumberForTest = 1;
        assertTrue(tabsSection.basicTabsSection.tabIsHighlighted(tabNumberForTest));
    }

    @Test
    public void tabPanelContainsValueTest() {
       int tabNumberForTest = 2;
        String stringForTest = String.format("Content %s", tabNumberForTest);
        tabsSection.basicTabsSection.clickTab(tabNumberForTest);
        assertTrue(tabsSection.basicTabsSection.tabPanelContainsValue(stringForTest));
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

}
