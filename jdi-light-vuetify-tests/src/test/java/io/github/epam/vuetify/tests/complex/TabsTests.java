package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.tabsPage;
import static io.github.com.pages.TabsPage.addButton;
import static io.github.com.pages.TabsPage.alignWithTitleTabs;
import static io.github.com.pages.TabsPage.centerActiveTabs;
import static io.github.com.pages.TabsPage.contentTabs;
import static io.github.com.pages.TabsPage.contentTabsContainer;
import static io.github.com.pages.TabsPage.customIconsTabs;
import static io.github.com.pages.TabsPage.desktopTabs;
import static io.github.com.pages.TabsPage.desktopTabsContainer;
import static io.github.com.pages.TabsPage.dynamicHeightSearch;
import static io.github.com.pages.TabsPage.dynamicHeightTabs;
import static io.github.com.pages.TabsPage.dynamicTabs;
import static io.github.com.pages.TabsPage.fixedTabs;
import static io.github.com.pages.TabsPage.growTabs;
import static io.github.com.pages.TabsPage.iconAndTextTabs;
import static io.github.com.pages.TabsPage.overflowToMenuTabs;
import static io.github.com.pages.TabsPage.paginationTabs;
import static io.github.com.pages.TabsPage.removeButton;
import static io.github.com.pages.TabsPage.rightTabs;
import static io.github.com.pages.TabsPage.tabItemsTabs;
import static io.github.com.pages.TabsPage.verticalTabs;
import static io.github.com.pages.TabsPage.verticalTabsText;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.TabsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TabsTests extends TestsInit {

    private static final String[] OVERFLOW_TAB_DATA = {"WEB", "SHOPPING", "VIDEOS", "IMAGES"};
    private static final String[] OPTIONS = {"OPTION 1", "OPTION 2", "OPTION 3"};
    private static final String[] USER_PROFILE_TEXT = {"Sed aliquam ultrices mauris", "Morbi nec metus", "Fusce a quam"};

    @BeforeClass
    public static void before() {
        tabsPage.open();
        waitCondition(() -> tabsPage.isOpened());
        tabsPage.checkOpened();
    }

    @Test(dataProviderClass = TabsTestsDataProvider.class,
            dataProvider = "alignWithTitleTabsTestsData")
    public static void alignWithTitleTabsTest(int index, String text) {
        alignWithTitleTabs.select(index);
        alignWithTitleTabs.get(index).has().text(text);
    }

    @Test(dataProviderClass = TabsTestsDataProvider.class,
            dataProvider = "centerActiveTabsTestsData")
    public static void centerActiveTabsTest(int index, String text) {
        centerActiveTabs.select(index);
        centerActiveTabs.get(index).has().text(text);
    }

    @Test
    public static void customIconsTabsTest() {

        clickWhileClickable(customIconsTabs.next());
        clickWhileClickable(customIconsTabs.prev());
        customIconsTabs.icons().get(1).is().visible();
        customIconsTabs.icons().get(2).is().visible();
    }

    @Test(dataProviderClass = TabsTestsDataProvider.class,
            dataProvider = "fixedTabsTestsData")
    public static void fixedTabsTest(int index, String text) {
        fixedTabs.is().fixed();
        fixedTabs.select(index);
        fixedTabs.get(index).has().text(text);
    }

    @Test(dataProviderClass = TabsTestsDataProvider.class,
            dataProvider = "growTabsTestsData")
    public static void growTabsTest(int index, String text) {
        growTabs.is().grow();
        growTabs.select(index);
        growTabs.get(index).has().text(text);
    }

    @Test
    public static void iconsTextTabsTest() {
        iconAndTextTabs.select(1);
        iconAndTextTabs.get(1).has().text("RECENTS");
        iconAndTextTabs.icons().get(1).is().visible();

        iconAndTextTabs.select(2);
        iconAndTextTabs.get(2).has().text("FAVORITES");
        iconAndTextTabs.icons().is().visible();

        iconAndTextTabs.select(3);
        iconAndTextTabs.get(3).has().text("NEARBY");
        iconAndTextTabs.icons().is().visible();
    }

    @Test
    public static void paginationTabsTest() {
        clickWhileClickable(paginationTabs.next());
        clickWhileClickable(paginationTabs.prev());

        for (int i = 1; i <= 5; i++) {
            paginationTabs.select(i);
            paginationTabs.get(i).has().text("ITEM " + i);
        }
    }

    @Test
    public static void rightTabsTest() {
        rightTabs.is().right();
        rightTabs.select(1);
        rightTabs.get(1).has().text("LANDSCAPE");
        rightTabs.select(2);
        rightTabs.get(2).has().text("CITY");
        rightTabs.select(3);
        rightTabs.get(3).has().text("ABSTRACT");
    }

    @Test
    public static void verticalTabsTest() {
        verticalTabs.isVertical();
        for (int opt = 1; opt <= OPTIONS.length; opt++) {
                verticalTabs.select(opt);
                verticalTabs.icons().get(opt).is().visible();
                verticalTabsText.has().text(containsString(USER_PROFILE_TEXT[opt - 1]));
                verticalTabs.get(opt).has().text(OPTIONS[opt - 1]);
        }
    }

    @Test
    public static void contentTabsTest() {
        contentTabs.has().values(equalTo(asList("ITEM 1", "ITEM 2", "ITEM 3")));
        contentTabsContainer.has().text(containsString("Lorem ipsum dolor sit amet"));
    }

    @Test
    public static void desktopTabsTest() {
        for (int i = 1; i <= 3; i++) {
            desktopTabs.select(i);
            desktopTabs.is().selected(i);
            desktopTabsContainer.has().text(containsString("Lorem ipsum dolor sit amet"));
            desktopTabs.icons().get(i).is().visible();
        }
    }

    @Test
    public static void dynamicHeightTabsTest() {
        dynamicHeightSearch.core().click();
        dynamicHeightSearch.setText("text");
        dynamicHeightTabs.has().values(equalTo(asList("ITEM 1", "ITEM 2", "ITEM 3")));
    }

    @Test
    public static void dynamicTabsTest() {
        dynamicTabs.select(1);
        dynamicTabs.has().selected(1).and().value("ITEM 1");
        dynamicTabs.select(7);
        dynamicTabs.has().selected(7).and().value("ITEM 7");

        addButton.is().enabled().and().has().text("ADD TAB");
        addButton.click();
        dynamicTabs.is().elementExist(16);

        removeButton.is().enabled().and().has().text("REMOVE TAB");
        removeButton.click();
        dynamicTabs.is().elementNotExist(16);
    }

    @Test
    public static void overflowToMenuTabsTest() {
        for (int i = 1; i <= OVERFLOW_TAB_DATA.length; i++) {
            overflowToMenuTabs.select(i);
            overflowToMenuTabs.get(i).has().text(OVERFLOW_TAB_DATA[i - 1]);
        }

        for (int i = 1; i <= 5; i++) {
            overflowToMenuTabs.menuButton().click();
            overflowToMenuTabs.menu().select(i);
        }
    }

    @Test
    public static void tabItemsTabsTest() {
        tabItemsTabs.select(1);
        tabItemsTabs.get(1).has().text("ONE");
        tabItemsTabs.select(2);
        tabItemsTabs.get(2).has().text("TWO");
        tabItemsTabs.select(3);
        tabItemsTabs.get(3).has().text("THREE");
    }

    private static void clickWhileClickable(UIElement element) {
        if (element.isExist() || !element.attr("class").contains("disabled")) {
            do {
                element.click();
            } while (element.isClickable());
        }
    }
}
