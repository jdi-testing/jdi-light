package io.github.epam.angular.tests.elements.complexgroups.tabgroup;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.pages.AngularPage.tabsSection;

public class TabsWithDynamicallyChangingTabsTests extends TestsTabGroupBase {

    @Test
    public void verifyDynamicallyChangingTabs() {
        tabsSection.dynamicallyChangingTabs.is().displayed();
        tabsSection.dynamicallyChangingTabs.has().attr(CLASS_ATTR, TAB_GROUP_DEFAULT_CLASS);
    }

    @Test
    public void verifyDynamicallyChangingTabsTitles() {
        tabsSection.dynamicallyChangingTabs.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyActiveDynamicallyChangingTabPanelContentByText() {
        String tabForTest = "New";
        tabsSection.addNewTabButton.click();
        tabsSection.dynamicallyChangingTabs.clickTab(tabForTest);
        String stringForTest = String.format("Contents for %s tab Delete Tab", tabForTest);
        tabsSection.dynamicallyChangingTabs.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void verifyActiveDynamicallyChangingTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.dynamicallyChangingTabs.clickTab(tabNumberForTest);
        tabsSection.dynamicallyChangingTabs.is().assertTabIsHighlighted(tabNumberForTest);
    }

    @Test
    public void verifyDynamicallyChangingTabsCountAfterAddingNewTabs() {
        int clicksCount = 2;
        int tabsCountForTest = tabsSection.dynamicallyChangingTabs.getTabsCount() + clicksCount;
        for (int i = 0; i < clicksCount; i++) {
            tabsSection.addNewTabButton.click();
        }
        tabsSection.dynamicallyChangingTabs.is().assertTabsCount(tabsCountForTest);
    }

    @Test
    public void addedWithCheckDynamicallyChangingTabIsHighlighted() {
        tabsSection.selectAfterAddingCheckbox.click();
        tabsSection.addNewTabButton.click();
        int tabsCount = tabsSection.dynamicallyChangingTabs.getTabsCount();
        tabsSection.dynamicallyChangingTabs.is().assertTabIsHighlighted(tabsCount);
    }

    @Test
    public void selectedByIndexTabIsHighlighted() {
        int indexForTest = 2;
        int tabNumberForTest = indexForTest + 1;
        tabsSection.selectByIndexInput.clear();
        tabsSection.selectByIndexInput.sendKeys(String.valueOf(indexForTest));
        tabsSection.dynamicallyChangingTabs.is().assertTabIsHighlighted(tabNumberForTest);
    }

    @Test
    public void selectedByIndexTabIsNormalizedToTabsCount() {
        int indexForTest = 10;
        int tabNumberForTest = tabsSection.dynamicallyChangingTabs.getTabsCount();
        tabsSection.selectByIndexInput.sendKeys(String.valueOf(indexForTest));
        tabsSection.dynamicallyChangingTabs.is().assertTabIsHighlighted(tabNumberForTest);
    }

    @Test
    public void verifyTabsCountAfterDeleteTab() {
        List<String> listForTest = Arrays.asList("Second", "Third");
        tabsSection.selectByIndexInput.clear();
        tabsSection.deleteTabButton.click();
        tabsSection.dynamicallyChangingTabs.is().assertTabsTitles(listForTest);
    }
}
