package io.github.epam.material.tests.navigation;

import static io.github.com.StaticSite.tabPage;
import static io.github.com.pages.navigation.TabPage.preventScrollTabs;
import static io.github.com.pages.navigation.TabPage.scrollableTabs;
import static io.github.com.pages.navigation.TabPage.simpleTabs;
import static io.github.com.pages.navigation.TabPage.verticalTabs;
import io.github.epam.TestsInit;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TabTests extends TestsInit {

    @BeforeClass
    public void before() {
        tabPage.open();
        tabPage.checkOpened();
    }

    @Test
    public void simpleTabTest() {
        simpleTabs.has().values(equalTo(asList("ITEM ONE", "ITEM TWO", "ITEM THREE", "ITEM FOUR", "ITEM FIVE")));
        simpleTabs.has().selected(1).value("ITEM ONE");
        simpleTabs.select(2);
        simpleTabs.has().selected(2).value("ITEM TWO");
        simpleTabs.has().disabled(4);
        simpleTabs.has().size(5);
    }

    @Test
    public void scrollableTabTest() {
        scrollableTabs.has().values(equalTo(asList("ITEM ONE", "ITEM TWO", "ITEM THREE", "ITEM FOUR", "ITEM FIVE",
                "ITEM SIX", "ITEM SEVEN", "ITEM EIGHT", "ITEM NINE", "ITEM TEN", "ITEM ELEVEN")));
        scrollableTabs.select(1);
        scrollableTabs.has().selected(1).value("ITEM ONE");
        scrollableTabs.rightScroll().click();
        scrollableTabs.leftScroll().click();
        scrollableTabs.select(7);
        scrollableTabs.has().selected(7).value("ITEM SEVEN");
    }

    @Test
    public void preventScrollTest() {
        preventScrollTabs.select(1);
        preventScrollTabs.has().selected(1);
        preventScrollTabs.select(7);
        preventScrollTabs.has().selected(7);
        preventScrollTabs.has().size(7);
    }

    @Test
    public void verticalTabTest() {
        scrollableTabs.has().values(equalTo(asList("ITEM ONE", "ITEM TWO", "ITEM THREE", "ITEM FOUR", "ITEM FIVE",
                "ITEM SIX", "ITEM SEVEN", "ITEM EIGHT", "ITEM NINE", "ITEM TEN", "ITEM ELEVEN")));
        verticalTabs.select(1);
        verticalTabs.has().selected(1).value("ITEM ONE");
        verticalTabs.select(7);
        verticalTabs.has().selected(7).value("ITEM SEVEN");
        verticalTabs.has().size(7);
    }
}
