package io.github.epam.angular.tests.elements.complex.tabgroup;

import org.testng.annotations.Test;

import static io.github.com.pages.AngularPage.tabsSection;

public class TabsBasicTests extends TestsTabGroupBase {

    @Test
    public void verifyTabs() {
        tabsSection.basicTab.is().displayed();
        tabsSection.basicTab.has().attr(CLASS_ATTR, TAB_GROUP_DEFAULT_CLASS);
    }

    @Test
    public void verifyTabsTitles() {
        tabsSection.basicTab.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyTabPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.basicTab.clickTab(tabNumberForTest);
        tabsSection.basicTab.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.basicTab.clickTab(tabNumberForTest);
        tabsSection.basicTab.is().assertTabIsHighlighted(tabNumberForTest);
    }
}
