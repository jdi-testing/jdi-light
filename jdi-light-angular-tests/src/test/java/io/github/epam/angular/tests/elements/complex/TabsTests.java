package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.tabsSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class TabsTests extends TestsInit {

    private final String CLASS_ATTR = "class";
    private final String ACCENT = "accent";
    private final String PRIMARY = "primary";
    private final String DYNAMIC_CONTENT = "Content %s";
    private final String TAB_GROUP_DEFAULT_CLASS = "mat-tab-group mat-primary";
    private final List<String> TITLES_DEFAULT_LIST = Arrays.asList("First", "Second", "Third");

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    /* BASIC TABS */
    @Test
    public void verifyTabs() {
        tabsSection.basicTabsSection.is().displayed();
        tabsSection.basicTabsSection.has().attr(CLASS_ATTR, TAB_GROUP_DEFAULT_CLASS);
    }

    @Test
    public void verifyTabsTitles() {
        tabsSection.basicTabsSection.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyTabPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.basicTabsSection.clickTab(tabNumberForTest);
        tabsSection.basicTabsSection.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.basicTabsSection.clickTab(tabNumberForTest);
        tabsSection.basicTabsSection.is().assertTabIsHighlighted(tabNumberForTest);
    }

    /* USING TABS WITH A CUSTOM LABEL TEMPLATE*/
    @Test
    public void verifyCustomLabelTemplateTabs() {
        tabsSection.tabsWithCustomLabel.is().displayed();
        tabsSection.tabsWithCustomLabel.has().attr(CLASS_ATTR, TAB_GROUP_DEFAULT_CLASS);
    }

    @Test
    public void verifyCustomLabelTemplateTabsTitles() {
        List<String> listForTest = Arrays.asList("thumb_up\nFirst", "thumb_up\nSecond", "thumb_up\nThird");
        tabsSection.tabsWithCustomLabel.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyCustomLabelTemplateTabPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.basicTabsSection.clickTab(tabNumberForTest);
        tabsSection.basicTabsSection.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeCustomLabelTemplateTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithCustomLabel.clickTab(tabNumberForTest);
        tabsSection.tabsWithCustomLabel.is().assertTabIsHighlighted(tabNumberForTest);
    }

    /*TAB GROUP WITH DYNAMIC HEIGHT BASED ON TAB CONTENTS*/
    @Test
    public void verifyDynamicHeightBasedOnContentsTabs() {
        String classForTest = "mat-tab-group mat-primary mat-tab-group-dynamic-height";
        tabsSection.tabsWithDynamicHeightBasedOnContent.is().displayed();
        tabsSection.tabsWithDynamicHeightBasedOnContent.has().attr(CLASS_ATTR, classForTest);
    }

    @Test
    public void verifyDynamicHeightBasedOnContentsTabsTitles() {
        List<String> listForTest = Arrays.asList("Short tab", "Long tab");
        tabsSection.tabsWithDynamicHeightBasedOnContent.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyDynamicHeightBasedOnContentsTabPanelContentByNumber() {
        int tabNumberForTest = 2;
        String stringForTest = "Large content";
        tabsSection.tabsWithDynamicHeightBasedOnContent.clickTab(tabNumberForTest);
        tabsSection.tabsWithDynamicHeightBasedOnContent.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeDynamicHeightBasedOnContentsTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithDynamicHeightBasedOnContent.clickTab(tabNumberForTest);
        tabsSection.tabsWithDynamicHeightBasedOnContent.is().assertTabIsHighlighted(tabNumberForTest);
    }

    /*TAB GROUP WITH DYNAMICALLY CHANGING TABS*/
    @Test
    public void verifyDynamicallyChangingTabs() {
        tabsSection.tabsWithDynamicChangingCount.is().displayed();
        tabsSection.tabsWithDynamicChangingCount.has().attr(CLASS_ATTR, TAB_GROUP_DEFAULT_CLASS);
    }

    @Test
    public void verifyDynamicallyChangingTabsTitles() {
        tabsSection.tabsWithDynamicChangingCount.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyActiveDynamicallyChangingTabPanelContentByText() {
        String tabForTest = "New";
        tabsSection.addNewTabButton.click();
        tabsSection.tabsWithDynamicChangingCount.clickTab(tabForTest);
        String stringForTest = String.format("Contents for %s tab Delete Tab", tabForTest);
        tabsSection.tabsWithDynamicChangingCount.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void verifyActiveDynamicallyChangingTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithDynamicChangingCount.clickTab(tabNumberForTest);
        tabsSection.tabsWithDynamicChangingCount.is().assertTabIsHighlighted(tabNumberForTest);
    }

    @Test
    public void verifyDynamicallyChangingTabsCountAfterAddingNewTabs() {
        int clicksCount = 2;
        int tabsCountForTest = tabsSection.tabsWithDynamicChangingCount.getTabsCount() + clicksCount;
        for (int i = 0; i < clicksCount; i++) {
            tabsSection.addNewTabButton.click();
        }
        tabsSection.tabsWithDynamicChangingCount.is().assertTabsCount(tabsCountForTest);
    }

    @Test
    public void addedWithCheckDynamicallyChangingTabIsHighlighted() {
        tabsSection.selectTabAfterAddingCheckbox.click();
        tabsSection.addNewTabButton.click();
        int tabsCount = tabsSection.tabsWithDynamicChangingCount.getTabsCount();
        tabsSection.tabsWithDynamicChangingCount.is().assertTabIsHighlighted(tabsCount);
    }

    @Test
    public void selectedByIndexTabIsHighlighted() {
        int indexForTest = 2;
        int tabNumberForTest = indexForTest + 1;
        tabsSection.selectTabIndexArea.clear();
        tabsSection.selectTabIndexArea.sendKeys(String.valueOf(indexForTest));
        tabsSection.tabsWithDynamicChangingCount.is().assertTabIsHighlighted(tabNumberForTest);
    }

    @Test
    public void selectedByIndexTabIsNormalizedToTabsCount() {
        int indexForTest = 10;
        int tabNumberForTest = tabsSection.tabsWithDynamicChangingCount.getTabsCount();
        tabsSection.selectTabIndexArea.sendKeys(String.valueOf(indexForTest));
        tabsSection.tabsWithDynamicChangingCount.is().assertTabIsHighlighted(tabNumberForTest);
    }

    @Test
    public void verifyTabsCountAfterDeleteTab() {
        List<String> listForTest = Arrays.asList("Second", "Third");
        tabsSection.selectTabIndexArea.clear();
        tabsSection.deleteButton.click();
        tabsSection.tabsWithDynamicChangingCount.is().assertTabsTitles(listForTest);
    }

    /*TAB GROUP WITH THE HEADERS ON THE BOTTOM*/
    @Test
    public void verifyTabsWithHeadersOnTheBottom() {
        String classForTest = "mat-tab-group mat-primary mat-tab-group-inverted-header";
        tabsSection.tabsWithHeadersOnTheBottom.is().displayed();
        tabsSection.tabsWithHeadersOnTheBottom.has().attr(CLASS_ATTR, classForTest);
        tabsSection.tabsWithHeadersOnTheBottom.has().attr("headerposition", "below");
    }

    @Test
    public void verifyTabsWithHeadersOnTheBottomTitles() {
        tabsSection.tabsWithHeadersOnTheBottom.is().assertTabsTitles(TITLES_DEFAULT_LIST);
    }

    @Test
    public void verifyTabWithHeadersOnTheBottomPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.tabsWithHeadersOnTheBottom.clickTab(tabNumberForTest);
        tabsSection.tabsWithHeadersOnTheBottom.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeTabWithHeaderOnTheBottomIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithHeadersOnTheBottom.clickTab(tabNumberForTest);
        tabsSection.tabsWithHeadersOnTheBottom.is().assertTabIsHighlighted(tabNumberForTest);
    }

    /* TAB GROUP WHERE THE TAB CONTENT IS LOADED LAZILY (WHEN ACTIVATED)*/
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
        SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("MMM dd, yyyy, h:mm:ss aa");
        dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String timeForTest = dateTimeInGMT.format(new Date());
        String stringForTest = String.format("Content %s - Loaded: %s", tabNumberForTest, timeForTest);
        tabsSection.tabsWithLazyLoadedContent.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeTabWithLazyLoadedContentIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithLazyLoadedContent.clickTab(tabNumberForTest);
        tabsSection.tabsWithLazyLoadedContent.is().assertTabIsHighlighted(tabNumberForTest);
    }

    /*CUSTOMIZING THE THEME OPTIONS ON THE TAB GROUP*/
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
        tabsSection.backgroundButtonToggle.clickButtonByValue(ACCENT);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-primary mat-background-accent");
        tabsSection.backgroundButtonToggle.clickButtonByValue(PRIMARY);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-primary mat-background-primary");
    }

    @Test
    public void verifyCustomThemeHighlighterColor() {
        tabsSection.colorButtonToggle.clickButtonByValue(ACCENT);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-background-primary mat-accent");
        tabsSection.colorButtonToggle.clickButtonByValue(PRIMARY);
        tabsSection.tabGroupThemeExample.has().attr(CLASS_ATTR, "mat-tab-group mat-background-primary mat-primary");
    }

    /* TAB GROUP WITH ASYNCHRONOUSLY LOADING TAB CONTENTS*/
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
        String stringForTest = String.format(DYNAMIC_CONTENT, tabNumberForTest);
        tabsSection.tabsAsyncLoadingContent.clickTab(tabNumberForTest);
        tabsSection.tabsAsyncLoadingContent.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeAsyncLoadingContentTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsAsyncLoadingContent.clickTab(tabNumberForTest);
        tabsSection.tabsAsyncLoadingContent.is().assertTabIsHighlighted(tabNumberForTest);
    }

    /*BASIC USE OF THE TAB NAV BAR*/
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
        List<String> listForTest = Collections.singletonList(String.format("Link %s", numberForTest));
        tabsSection.tabsNavBar.is().assertTabsLinksTitles(listForTest);
    }

    @Test
    public void verifyTabWithLinkBackgroundColor() {
        tabsSection.toggleBackgroundButton.click();
        tabsSection.tabsNavBar.has().attr(CLASS_ATTR, "mat-tab-nav-bar mat-tab-header mat-primary " +
                "mat-background-primary");
    }
}
