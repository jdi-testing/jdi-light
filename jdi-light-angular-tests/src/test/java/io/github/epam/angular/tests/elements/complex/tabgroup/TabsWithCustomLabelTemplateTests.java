package io.github.epam.angular.tests.elements.complex.tabgroup;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.pages.AngularPage.tabsSection;

public class TabsWithCustomLabelTemplateTests extends TestsTabGroupBase {

    @Test
    public void verifyCustomLabelTemplateTabs() {
        tabsSection.tabWithCustomLabel.is().displayed();
        tabsSection.tabWithCustomLabel.has().attr(CLASS_ATTR, TAB_GROUP_DEFAULT_CLASS);
    }

    @Test
    public void verifyCustomLabelTemplateTabsTitles() {
        List<String> listForTest = Arrays.asList("thumb_up\nFirst", "thumb_up\nSecond", "thumb_up\nThird");
        tabsSection.tabWithCustomLabel.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyCustomLabelTemplateTabPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.tabWithCustomLabel.clickTab(tabNumberForTest);
        tabsSection.tabWithCustomLabel.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeCustomLabelTemplateTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabWithCustomLabel.clickTab(tabNumberForTest);
        tabsSection.tabWithCustomLabel.is().assertTabIsHighlighted(tabNumberForTest);
    }
}
