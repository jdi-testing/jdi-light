package io.github.epam.angular.tests.elements.complex.tabgroup;

import org.testng.annotations.Test;

import static io.github.com.pages.AngularPage.tabsSection;

public class TabsWithCustomizingThemesTests extends TestsTabGroupBase {

    @Test
    public void verifyCustomThemeTabs() {
        String classForTest = "mat-tab-group mat-background-primary mat-primary";
        tabsSection.tabGroupThemeExample.is().displayed();
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, classForTest);
    }

    @Test
    public void verifyCustomThemeTabsTitles() {
        tabsSection.tabGroupThemeExample.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyCustomThemeTabPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.tabGroupThemeExample.clickTab(tabNumberForTest);
        tabsSection.tabGroupThemeExample.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeCustomThemeTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabGroupThemeExample.clickTab(tabNumberForTest);
        tabsSection.tabGroupThemeExample.is().assertTabIsHighlighted(tabNumberForTest);
    }

    @Test
    public void verifyCustomThemeTabsBackgroundColor() {
        tabsSection.matButtonToggleGroupBackgroundColor.clickButtonToggleByValue(ACCENT);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-primary mat-background-accent");
        tabsSection.matButtonToggleGroupBackgroundColor.clickButtonToggleByValue(PRIMARY);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-primary mat-background-primary");
    }
}
