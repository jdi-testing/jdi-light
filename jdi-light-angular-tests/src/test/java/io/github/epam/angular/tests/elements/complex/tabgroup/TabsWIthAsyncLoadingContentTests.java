package io.github.epam.angular.tests.elements.complex.tabgroup;

import org.testng.annotations.Test;

import static io.github.com.pages.AngularPage.tabsSection;

public class TabsWIthAsyncLoadingContentTests extends TestsTabGroupBase {

    @Test
    public void verifyTabsAsyncLoadingContent() {
        tabsSection.tabsAsyncLoadingContent.is().displayed();
        tabsSection.tabsAsyncLoadingContent.has().attr(CLASS_ATTR, TAB_GROUP_DEFAULT_CLASS);
    }

    @Test
    public void verifyCustomThemeAsyncLoadingContentTabsTitles() {
        tabsSection.tabsAsyncLoadingContent.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyAsyncLoadingContentTabPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.tabsAsyncLoadingContent.clickTab(tabNumberForTest);
        tabsSection.tabsAsyncLoadingContent.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeAsyncLoadingContentTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsAsyncLoadingContent.clickTab(tabNumberForTest);
        tabsSection.tabsAsyncLoadingContent.is().assertTabIsHighlighted(tabNumberForTest);
    }
}
