package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.tabsPage;
import static io.github.com.pages.TabsPage.alignWithTitleTabs;
import static io.github.com.pages.TabsPage.centerActiveTabs;
import static io.github.com.pages.TabsPage.contentTabs;
import static io.github.com.pages.TabsPage.customIconsTabs;
import static io.github.com.pages.TabsPage.customIconsTabsButtonBack;
import static io.github.com.pages.TabsPage.customIconsTabsButtonNext;
import static io.github.com.pages.TabsPage.desktopTabs;
import static io.github.com.pages.TabsPage.desktopTabsIcon;
import static io.github.com.pages.TabsPage.dynamicHeightTabs;
import static io.github.com.pages.TabsPage.dynamicTabs;
import static io.github.com.pages.TabsPage.dynamicTabsAddButton;
import static io.github.com.pages.TabsPage.dynamicTabsRemoveButton;
import static io.github.com.pages.TabsPage.fixedTabs;
import static io.github.com.pages.TabsPage.growTabs;
import static io.github.com.pages.TabsPage.iconAndTextTabs;
import static io.github.com.pages.TabsPage.iconAndTextTabsIcon;
import static io.github.com.pages.TabsPage.overflowToMenuTabs;
import static io.github.com.pages.TabsPage.overflowToMenuTabsMenuButton;
import static io.github.com.pages.TabsPage.overflowToMenuTabsMenuElements;
import static io.github.com.pages.TabsPage.paginationTabs;
import static io.github.com.pages.TabsPage.paginationTabsButtonBack;
import static io.github.com.pages.TabsPage.paginationTabsButtonNext;
import static io.github.com.pages.TabsPage.rightTabs;
import static io.github.com.pages.TabsPage.tabItemsTabs;
import static io.github.com.pages.TabsPage.verticalTabs;
import static io.github.com.pages.TabsPage.verticalTabsIcon;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TabsTests extends TestsInit {

    @BeforeSuite
    public static void before() {
        tabsPage.open();
    }

    @Test
    public static void alignWithTitleTabsTest() {
        alignWithTitleTabs.select(1);
        alignWithTitleTabs.get(1).is().text("WEB");
        alignWithTitleTabs.select(2);
        alignWithTitleTabs.get(2).is().text("SHOPPING");
        alignWithTitleTabs.select(3);
        alignWithTitleTabs.get(3).is().text("VIDEOS");
        alignWithTitleTabs.select(4);
        alignWithTitleTabs.get(4).is().text("IMAGES");
        alignWithTitleTabs.select(5);
        alignWithTitleTabs.get(5).is().text("NEWS");
    }

    @Test
    public static void centerActiveTabsTest() {
        centerActiveTabs.select(1);
        centerActiveTabs.get(1).is().text("ONE");
        centerActiveTabs.select(2);
        centerActiveTabs.get(2).is().text("TWO");
        centerActiveTabs.select(7);
        centerActiveTabs.get(7).is().text("SEVEN");
    }

    @Test
    public static void customIconsTabsTest() {
        jdiAssert(customIconsTabsButtonBack.get(1).isClickable(),
                Matchers.is(false));

        customIconsTabsButtonNext.select(1);
        customIconsTabsButtonNext.select(1);
        customIconsTabsButtonNext.select(1);

        jdiAssert(customIconsTabsButtonNext.get(1).isClickable(),
                Matchers.is(false));

        customIconsTabsButtonBack.select(1);
        customIconsTabsButtonBack.select(1);
        customIconsTabsButtonBack.select(1);

        customIconsTabs.select(1);
        customIconsTabs.get(1).is().text("ITEM 1");
        customIconsTabs.select(2);
        customIconsTabs.get(2).is().text("ITEM 2");
        customIconsTabs.select(3);
        customIconsTabs.get(3).is().text("ITEM 3");
    }

    @Test
    public static void fixedTabs() {
        fixedTabs.select(1);
        fixedTabs.get(1).is().text("OPTION");
        fixedTabs.select(2);
        fixedTabs.get(2).is().text("ANOTHER SELECTION");
        fixedTabs.select(3);
        fixedTabs.get(3).is().text("ITEMS");
        fixedTabs.select(4);
        fixedTabs.get(4).is().text("ANOTHER SCREEN");
    }

    @Test
    public static void growTabs() {
        growTabs.select(1);
        growTabs.get(1).is().text("APPETIZERS");
        growTabs.select(2);
        growTabs.get(2).is().text("ENTREES");
        growTabs.select(3);
        growTabs.get(3).is().text("DESERTS");
        growTabs.select(4);
        growTabs.get(4).is().text("COCKTAILS");
    }

    @Test
    public static void iconsTextTabsTest() {
        iconAndTextTabs.select(1);
        iconAndTextTabs.get(1).is().text("RECENTS");
        iconAndTextTabsIcon.get(1).is().visible();

        iconAndTextTabs.select(2);
        iconAndTextTabs.get(2).is().text("FAVORITES");
        iconAndTextTabsIcon.get(2).is().visible();

        iconAndTextTabs.select(3);
        iconAndTextTabs.get(3).is().text("NEARBY");
        iconAndTextTabsIcon.get(3).is().visible();
    }

    @Test
    public static void paginationTabsTest() {
        jdiAssert(paginationTabsButtonBack.get(1).isClickable(),
                Matchers.is(false));

        paginationTabsButtonNext.select(1);
        paginationTabsButtonNext.select(1);
        paginationTabsButtonNext.select(1);

        jdiAssert(paginationTabsButtonNext.get(1).isClickable(),
                Matchers.is(false));

        paginationTabsButtonBack.select(1);
        paginationTabsButtonBack.select(1);
        paginationTabsButtonBack.select(1);

        paginationTabs.select(1);
        paginationTabs.get(1).is().text("ITEM 1");
        paginationTabs.select(2);
        paginationTabs.get(2).is().text("ITEM 2");
        paginationTabs.select(3);
        paginationTabs.get(3).is().text("ITEM 3");
    }

    @Test
    public static void rightTabsTest() {
        rightTabs.select(1);
        rightTabs.get(1).is().text("LANDSCAPE");
        rightTabs.select(2);
        rightTabs.get(2).is().text("CITY");
        rightTabs.select(3);
        rightTabs.get(3).is().text("ABSTRACT");
    }

    @Test
    public static void verticalTabsTest() {
        verticalTabs.select(1);
        verticalTabsIcon.get(1).is().visible();
        verticalTabs.get(1).is().text("OPTION 1");
        verticalTabs.select(2);
        verticalTabsIcon.get(2).is().visible();
        verticalTabs.get(2).is().text("OPTION 2");
        verticalTabs.select(3);
        verticalTabsIcon.get(3).is().visible();
        verticalTabs.get(3).is().text("OPTION 3");
    }

    @Test
    public static void contentTabsTest() {
        contentTabs.select(1);
        contentTabs.select(2);
        contentTabs.select(3);
    }

    @Test
    public static void desktopTabsTest() {
        desktopTabs.select(1);
        desktopTabsIcon.get(1).is().visible();
        desktopTabs.select(2);
        desktopTabsIcon.get(2).is().visible();
        desktopTabs.select(3);
        desktopTabsIcon.get(3).is().visible();
    }

    @Test
    public static void dynamicHeightTabsTest() {
        dynamicHeightTabs.select(1);
        dynamicHeightTabs.select(2);
        dynamicHeightTabs.select(3);
    }

    @Test
    public static void dynamicTabsTest() {
        int itemNumber = 0;
        do {
            dynamicTabs.select(++itemNumber);
            dynamicTabs.get(itemNumber).is().text("ITEM " + itemNumber);
        } while (dynamicTabs.get(itemNumber + 1).isExist());

        dynamicTabsRemoveButton.is().enabled();
        dynamicTabsRemoveButton.is().text("REMOVE TAB");
        dynamicTabsRemoveButton.click();
        jdiAssert(dynamicTabs.get(itemNumber).isNotExist(), Matchers.is(true));

        dynamicTabsAddButton.is().enabled();
        dynamicTabsAddButton.is().text("ADD TAB");
        dynamicTabsAddButton.click();
        jdiAssert(dynamicTabs.get(itemNumber).isExist(), Matchers.is(true));

        dynamicTabs.select(itemNumber);
    }

    @Test
    public static void overflowToMenuTabsTest() {
        overflowToMenuTabs.select(1);
        overflowToMenuTabs.get(1).is().text("WEB");
        overflowToMenuTabs.select(2);
        overflowToMenuTabs.get(2).is().text("SHOPPING");
        overflowToMenuTabs.select(3);
        overflowToMenuTabs.get(3).is().text("VIDEOS");
        overflowToMenuTabs.select(4);
        overflowToMenuTabs.get(4).is().text("IMAGES");

        do {
            overflowToMenuTabsMenuButton.click();
            overflowToMenuTabsMenuElements.select(1);
        } while (!overflowToMenuTabsMenuElements.get(1).getText().contains("Web"));
    }

    @Test
    public static void tabItemsTabsTest() {
        tabItemsTabs.select(1);
        tabItemsTabs.get(1).is().text("ONE");
        tabItemsTabs.select(2);
        tabItemsTabs.get(2).is().text("TWO");
        tabItemsTabs.select(3);
        tabItemsTabs.get(3).is().text("THREE");
    }

}
