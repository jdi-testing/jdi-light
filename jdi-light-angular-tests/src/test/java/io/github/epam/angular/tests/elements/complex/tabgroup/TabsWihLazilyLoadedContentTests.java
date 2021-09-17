package io.github.epam.angular.tests.elements.complex.tabgroup;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.pages.AngularPage.tabsSection;
import static com.jdiai.tools.StringUtils.format;

public class TabsWihLazilyLoadedContentTests extends TestsTabGroupBase {

    @Test
    public void verifyTabsWithLazyLoadedContent() {
        tabsSection.tabsWithLazyLoadedContent.is().displayed();
        tabsSection.tabsWithLazyLoadedContent.has().attr(CLASS_ATTR, TAB_GROUP_DEFAULT_CLASS);
    }

    @Test
    public void verifyTabsWithLazyLoadedContentTitles() {
        tabsSection.tabsWithLazyLoadedContent.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyTabWithLazyLoadedContent() {
        int tabNumberForTest = 3;
        refresh();
        tabsSection.tabsWithLazyLoadedContent.clickTab(tabNumberForTest);
        SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("MMM d, yyyy, h:mm:ss aa");
        dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String timeForTest = dateTimeInGMT.format(new Date());
        String stringForTest = format("Content %s - Loaded: %s", tabNumberForTest, timeForTest);
        tabsSection.tabsWithLazyLoadedContent.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeTabWithLazyLoadedContentIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithLazyLoadedContent.clickTab(tabNumberForTest);
        tabsSection.tabsWithLazyLoadedContent.is().assertTabIsHighlighted(tabNumberForTest);
    }
}
