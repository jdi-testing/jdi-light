package io.github.epam.angular.tests.elements.complexgroups.tabgroup;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.pages.AngularPage.tabsSection;

public class TabsWithDynamicHeightBasedOnTabContentTests extends TestsTabGroupBase {

    @Test
    public void verifyDynamicHeightBasedOnContentsTabs() {
        String classForTest = "mat-tab-group mat-primary mat-tab-group-dynamic-height";
        tabsSection.tabDynamicHeightBasedOnContent.is().displayed();
        tabsSection.tabDynamicHeightBasedOnContent.has().attr(CLASS_ATTR, classForTest);
    }

    @Test
    public void verifyDynamicHeightBasedOnContentsTabsTitles() {
        List<String> listForTest = Arrays.asList("Short tab", "Long tab");
        tabsSection.tabDynamicHeightBasedOnContent.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyDynamicHeightBasedOnContentsTabPanelContentByNumber() {
        int tabNumberForTest = 2;
        String stringForTest = "Large content";
        tabsSection.tabDynamicHeightBasedOnContent.clickTab(tabNumberForTest);
        tabsSection.tabDynamicHeightBasedOnContent.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeDynamicHeightBasedOnContentsTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabDynamicHeightBasedOnContent.clickTab(tabNumberForTest);
        tabsSection.tabDynamicHeightBasedOnContent.is().assertTabIsHighlighted(tabNumberForTest);
    }
}
