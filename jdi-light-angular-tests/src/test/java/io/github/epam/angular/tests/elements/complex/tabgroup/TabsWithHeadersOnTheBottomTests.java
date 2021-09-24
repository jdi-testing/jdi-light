package io.github.epam.angular.tests.elements.complex.tabgroup;

import org.testng.annotations.Test;

import static com.jdiai.tools.StringUtils.format;
import static io.github.com.pages.AngularPage.tabsSection;
import static com.jdiai.tools.StringUtils.format;

public class TabsWithHeadersOnTheBottomTests extends TestsTabGroupBase {

    @Test
    public void verifyTabsWithHeadersOnTheBottom() {
        String classForTest = "mat-tab-group mat-primary mat-tab-group-inverted-header";
        tabsSection.tabWithHeadersOnTheBottom.is().displayed();
        tabsSection.tabWithHeadersOnTheBottom.has().attr(CLASS_ATTR, classForTest);
        tabsSection.tabWithHeadersOnTheBottom.has().attr("headerposition", "below");
    }

    @Test
    public void verifyTabsWithHeadersOnTheBottomTitles() {
        tabsSection.tabWithHeadersOnTheBottom.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyTabWithHeadersOnTheBottomPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.tabWithHeadersOnTheBottom.clickTab(tabNumberForTest);
        tabsSection.tabWithHeadersOnTheBottom.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeTabWithHeaderOnTheBottomIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabWithHeadersOnTheBottom.clickTab(tabNumberForTest);
        tabsSection.tabWithHeadersOnTheBottom.is().assertTabIsHighlighted(tabNumberForTest);
    }
}
