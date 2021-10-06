package io.github.epam.material.tests.navigation;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.tabPage;
import static io.github.com.pages.navigation.TabPage.buttonHorizontal;
import static io.github.com.pages.navigation.TabPage.buttonVertical;
import static io.github.com.pages.navigation.TabPage.preventScrollTabs;
import static io.github.com.pages.navigation.TabPage.preventScrollTabsContent;
import static io.github.com.pages.navigation.TabPage.scrollableTabs;
import static io.github.com.pages.navigation.TabPage.scrollableTabsContent;
import static io.github.com.pages.navigation.TabPage.simpleTabs;
import static io.github.com.pages.navigation.TabPage.simpleTabsContent;
import static io.github.com.pages.navigation.TabPage.verticalTabs;
import static io.github.com.pages.navigation.TabPage.verticalTabsContent;

/**
 * To see an example of Tab please visit
 * https://material-ui.com/components/tabs/
 */

public class TabTests extends TestsInit {
    private List<String> itemList = Arrays.asList("", "Item One", "Item Two", "Item Three", "Item Four", "Item Five",
            "Item Six", "Item Seven", "Item Eight", "Item Nine", "Item Ten", "Item Eleven");
    private Timer timer = new Timer(5000L);

    @BeforeClass
    public void before() {
        tabPage.open();
        tabPage.isOpened();
    }

    @Test
    public void simpleTabTest() {
        simpleTabs.get(1).show();
        simpleTabs.get(1).click();
        simpleTabsContent.get(1).is().text(itemList.get(1));
        simpleTabs.get(2).click();
        simpleTabsContent.get(2).is().text(itemList.get(2));
        simpleTabs.get(3).click();
        simpleTabsContent.get(3).is().text(itemList.get(3));
        simpleTabs.get(4).is().disabled();
        simpleTabs.get(5).click();
        simpleTabsContent.get(5).is().text(itemList.get(5));
    }

    @Test
    public void scrollableTabTest(){
        scrollableTabs.get(8).click();
        scrollableTabsContent.get(8).is().text(itemList.get(8));
        buttonHorizontal.get(1).is().shown();
        timer.wait(() -> buttonHorizontal.get(2).click());
        scrollableTabs.get(11).click();
        scrollableTabsContent.get(11).is().text(itemList.get(11));
        buttonHorizontal.get(2).is().hidden();
        scrollableTabs.get(4).click();
        scrollableTabsContent.get(4).is().text(itemList.get(4));
    }

    @Test
    public void preventScrollTest() {
        preventScrollTabs.get(1).click();
        preventScrollTabsContent.get(1).is().text(itemList.get(1));
        preventScrollTabs.get(2).click();
        preventScrollTabsContent.get(2).is().text(itemList.get(2));
        preventScrollTabs.get(3).click();
        preventScrollTabsContent.get(3).is().text(itemList.get(3));
        preventScrollTabs.get(4).click();
        preventScrollTabsContent.get(4).is().text(itemList.get(4));
        preventScrollTabs.get(5).click();
        preventScrollTabsContent.get(5).is().text(itemList.get(5));
        preventScrollTabs.get(6).click();
        preventScrollTabsContent.get(6).is().text(itemList.get(6));
        preventScrollTabs.get(7).click();
        preventScrollTabsContent.get(7).is().text(itemList.get(7));
    }

    @Test
    public void verticalTabTest() {
        verticalTabs.get(6).click();
        verticalTabsContent.get(6).is().text(itemList.get(6));
        buttonVertical.get(1).is().shown();
        buttonVertical.get(2).click();
        verticalTabs.get(7).click();
        verticalTabsContent.get(7).is().text(itemList.get(7));
        buttonVertical.get(2).is().hidden();
        verticalTabs.get(1).click();
        verticalTabsContent.get(1).is().text(itemList.get(1));
    }
}
