package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static io.github.com.pages.AngularPage.tabsSection;

public class TabsTests extends TestsInit {

  /*  @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }*/

    /* BASIC TABS */
    @Test
    public void verifyTabs() {
        String classForTest = "mat-tab-group mat-primary";
        tabsSection.basicTabsSection.is().displayed();
        tabsSection.basicTabsSection.has().attr("class", classForTest);
    }

    @Test
    public void verifyTabsTitles() {
        List<String> listForTest = Arrays.asList("First", "Second", "Third");
        tabsSection.basicTabsSection.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyTabPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format("Content %s", tabNumberForTest);
        tabsSection.basicTabsSection.clickTab(tabNumberForTest);
        tabsSection.basicTabsSection.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.basicTabsSection.clickTab(tabNumberForTest);
        tabsSection.basicTabsSection.is().assertTabIsHighlighted(tabNumberForTest);
    }
//------------------------------------------------------------------------------------------------------------------

    /* USING TABS WITH A CUSTOM LABEL TEMPLATE*/
    @Test
    public void verifyCustomLabelTemplateTabsTitles() {
        List<String> listForTest = Arrays.asList("thumb_up\nFirst", "thumb_up\nSecond", "thumb_up\nThird");
        tabsSection.tabsWithCustomLabel.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyCustomLabelTemplateTabPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format("Content %s", tabNumberForTest);
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

    //------------------------------------------------------------------------------------------------------------------
    /*TAB GROUP WITH DYNAMICALLY CHANGING TABS*/
    @Test
    public void verifyDynamicallyChangingTabsTitles() {
        List<String> listForTest = Arrays.asList("First", "Second", "Third");
        tabsSection.tabsWithDynamicChangingCount.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyActiveDynamicallyChangingTabIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithDynamicChangingCount.clickTab(tabNumberForTest);
        tabsSection.tabsWithDynamicChangingCount.is().assertTabIsHighlighted(tabNumberForTest);
    }

    @Test
    public void verifyActiveDynamicallyChangingTabPanelContentByText() {
        String tabForTest = "New";
        tabsSection.addNewTabButton.click();
        tabsSection.tabsWithDynamicChangingCount.clickTab(tabForTest);
        String stringForTest = String.format("Contents for %s tab Delete Tab", tabForTest);
        tabsSection.tabsWithDynamicChangingCount.is().assertTabPanelContent(stringForTest);
    }

    /*add new tab button*/

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
        int clicksCount = 2;
        tabsSection.selectTabAfterAddingCheckbox.click();
        for (int i = 0; i < clicksCount; i++) {
            tabsSection.addNewTabButton.click();
        }
        int tabsCount = tabsSection.tabsWithDynamicChangingCount.getTabsCount();
        tabsSection.tabsWithDynamicChangingCount.is().assertTabIsHighlighted(tabsCount);
    }

    /*select tab by index input*/
    @Test
    public void selectedByIndexTabIsHighlighted() {
        int indexForTest = 2;
        int tabNumberForTest = indexForTest + 1;
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

    /*delete*/
    @Test
    public void verifyTabsCountAfterDeleteTab() {
        int tabNumberForTest = 2;
        List<String> listForTest = Arrays.asList("First", "Third");
        tabsSection.tabsWithDynamicChangingCount.clickTab(tabNumberForTest);
        tabsSection.deleteButton.click();
        tabsSection.tabsWithDynamicChangingCount.is().assertTabsTitles(listForTest);
        tabsSection.tabsWithDynamicChangingCount.is().assertTabIsHighlighted(tabNumberForTest);
    }

    //------------------------------------------------------------------------------------------------------------------
    /*TAB GROUP WITH THE HEADERS ON THE BOTTOM*/
    @Test
    public void verifyTabsWithHeadersOnTheBottom() {
        String classForTest = "mat-tab-group mat-primary mat-tab-group-inverted-header";
        tabsSection.tabsWithHeadersOnTheBottom.is().displayed();
        tabsSection.tabsWithHeadersOnTheBottom.has().attr("class", classForTest);
    }

    @Test
    public void verifyTabsWithHeadersOnTheBottomTitles() {
        List<String> listForTest = Arrays.asList("First", "Second", "Third");
        tabsSection.tabsWithHeadersOnTheBottom.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyTabWithHeadersOnTheBottomPanelContentByNumber() {
        int tabNumberForTest = 3;
        String stringForTest = String.format("Content %s", tabNumberForTest);
        tabsSection.tabsWithHeadersOnTheBottom.clickTab(tabNumberForTest);
        tabsSection.tabsWithHeadersOnTheBottom.is().assertTabPanelContent(stringForTest);
    }

    @Test
    public void activeTabWithHeaderOnTheBottomIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithHeadersOnTheBottom.clickTab(tabNumberForTest);
        tabsSection.tabsWithHeadersOnTheBottom.is().assertTabIsHighlighted(tabNumberForTest);
    }

    //------------------------------------------------------------------------------------------------------------------
    /* TAB GROUP WHERE THE TAB CONTENT IS LOADED LAZILY (WHEN ACTIVATED)*/
    @Test
    public void verifyTabsWithLazyLoadedContent() {
        String classForTest = "mat-tab-group mat-primary";
        tabsSection.tabsWithLazyLoadedContent.is().displayed();
        tabsSection.tabsWithLazyLoadedContent.has().attr("class", classForTest);
    }

    @Test
    public void verifyTabsWithLazyLoadedContentTitles() {
        List<String> listForTest = Arrays.asList("First", "Second", "Third");
        tabsSection.tabsWithLazyLoadedContent.is().assertTabsTitles(listForTest);
    }

    @Test
    public void verifyTabWithLazyLoadedContent() {
        int tabNumberForTest = 3;
      //  SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
     //   dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT+3"));
     //   System.out.println(dateTimeInGMT.format(new Date()));
      //  List<String> listForTest = Arrays.asList(dateTimeInGMT.format(new Date()).replaceAll("-", " ").split(" "));
      //  System.out.println(listForTest);
     //   String stringForTest = String.format(" Content %s - Loaded: %s %s, %s, %s %s", tabNumberForTest,
       //         listForTest.get(1), listForTest.get(2), listForTest.get(0), listForTest.get(3), listForTest.get(4));
       // System.out.println(stringForTest);

        for (String s:  tabsSection.tabsWithLazyLoadedContent.getTabPanelContentValues()) {
        String sDate = s.trim().replaceAll("Content \\d - Loaded: ", "");
            Date dateTimeInGMT = null;
            try {
                dateTimeInGMT = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss aa").parse(sDate);
            } catch (ParseException e) {
                System.out.println("Empty tab");
            }
            Date date = new Date();
            System.out.println(dateTimeInGMT + " GTM");
            System.out.println(date + " Date");
        }

        tabsSection.tabsWithLazyLoadedContent.clickTab(tabNumberForTest);
       // tabsSection.tabsWithLazyLoadedContent.is().assertTabPanelContent(dateTimeInGMT);
    }

    @Test
    public void activeTabWithLazyLoadedContentIsHighlighted() {
        int tabNumberForTest = 2;
        tabsSection.tabsWithLazyLoadedContent.clickTab(tabNumberForTest);
        tabsSection.tabsWithLazyLoadedContent.is().assertTabIsHighlighted(tabNumberForTest);
    }

    //------------------------------------------------------------------------------------------------------------------
    /*CUSTOMIZING THE THEME OPTIONS ON THE TAB GROUP*/
//------------------------------------------------------------------------------------------------------------------
    /* TAB GROUP WITH ASYNCHRONOUSLY LOADING TAB CONTENTS*/
    /*the same as basic tabs*/
//------------------------------------------------------------------------------------------------------------------
    /*BASIC USE OF THE TAB NAV BAR*/
    @Test
    public void verifyTabsWithLinks() {
        String classForTest = "mat-tab-nav-bar mat-tab-header mat-primary";
        tabsSection.tabsNavBar.is().displayed();
        tabsSection.tabsNavBar.has().attr("class", classForTest);
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
        tabsSection.tabsNavBar.has().attr("ng-reflect-background-color", "primary");
    }


}
