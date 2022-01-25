package io.github.epam.angular.tests.elements.complex.tabgroup;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.jdiai.tools.StringUtils.format;
import static io.github.com.pages.AngularPage.tabsSection;

public class TabsWithNavBarTests extends TestsTabGroupBase {

    @Test
    public void verifyTabsWithLinks() {
        String classForTest = "mat-tab-nav-bar mat-tab-header mat-primary mat-background-primary";
        tabsSection.tabsNavBar.is().displayed();
        tabsSection.tabsNavBar.has().attr(CLASS_ATTR, classForTest);
    }

    @Test
    public void verifyTabsLinksTitles() {
        List<String> listForTest = Arrays.asList("First", "Second", "Third", "Disabled Link");
        tabsSection.tabsNavBar.is().assertTabsLinksTitles(listForTest);
    }

    @Test
    public void verifyTabWithLinkIsHighLighted() {
        String tabTitleForTest = "Third";
        tabsSection.tabsNavBar.clickTabLink(tabTitleForTest);
        tabsSection.tabsNavBar.is().assertTabWithLinkIsHighlighted(tabTitleForTest);
    }

    @Test
    public void verifyTabsWithLinkTitlesAfterAdding() {
        tabsSection.addLinkButton.click();
        tabsSection.addLinkButton.click();
        int numberForTest = tabsSection.tabsNavBar.getTabLinksCount() - 1;
        List<String> listForTest = Collections.singletonList(format("Link %s", numberForTest));
        tabsSection.tabsNavBar.is().assertTabsLinksTitles(listForTest);
    }

    @Test
    public void verifyTabWithLinkBackgroundColor() {
        tabsSection.toggleBackgroundButton.click();
        tabsSection.tabsNavBar.has().attr(CLASS_ATTR, "mat-tab-nav-bar mat-tab-header mat-primary " +
                "mat-background-primary");
    }
}
