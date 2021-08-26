package io.github.epam.material.tests.navigation;

import com.epam.jdi.light.material.elements.navigation.Tabs;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.tabPage;
import static io.github.com.pages.navigation.TabPage.lastItemText;
import static io.github.com.pages.navigation.TabPage.preventScrollTabs;
import static io.github.com.pages.navigation.TabPage.scrollButtons;
import static io.github.com.pages.navigation.TabPage.scrollableTabs;
import static io.github.com.pages.navigation.TabPage.simpleTabs;
import static io.github.com.pages.navigation.TabPage.verticalTabs;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Tab please visit
 * https://material-ui.com/components/tabs/
 */

public class TabTests extends TestsInit {
    private List<List<Tabs>> tableLocators;
    private List<String> itemList = Arrays.asList("", "Item One", "Item Two", "Item Three", "Item Four", "Item Five", "Item Six", "Item Seven", "Item Eight", "Item Nine", "Item Ten", "Item Eleven");
    private int tableIndex;
    private Timer timer = new Timer(5000L);

    public void clickTab(int indexRow) { tableLocators.get(tableIndex).get(indexRow).click(); }

    public void checkLastItemText(String name) {
        lastItemText.get(tableIndex).has().text(containsString(name));
    }

    @BeforeTest()
    public void beforeTest() {
        tabPage.open();
        tabPage.isOpened();
        tableLocators = Arrays.asList(null, simpleTabs, scrollableTabs, preventScrollTabs, verticalTabs);
    }

    @Test
    public void simpleTabTest() {
        tableIndex = 1;
        clickTab(1);
        checkLastItemText(itemList.get(1));
        tableLocators.get(tableIndex).get(4).has().classValue(containsString("Mui-disabled"));
        clickTab(5);
        checkLastItemText(itemList.get(5));
    }

    @Test
    public void scrollableTabTest(){
        tableIndex = 2;
        clickTab(9);
        checkLastItemText(itemList.get(9));
        timer.wait(() -> scrollButtons.get(2).click());
        clickTab(11);
        checkLastItemText(itemList.get(11));
        timer.wait(() -> scrollButtons.get(1).click());
        clickTab(1);
        checkLastItemText(itemList.get(1));
    }

    @Test
    public void preventScrollTest() {
        tableIndex = 3;
        clickTab(1);
        checkLastItemText(itemList.get(1));
        clickTab(7);
        checkLastItemText(itemList.get(7));
    }

    @Test
    public void verticalTabTest() {
        tableIndex = 4;
        clickTab(1);
        checkLastItemText(itemList.get(1));
        scrollButtons.get(4).click();
        clickTab(4);
        checkLastItemText(itemList.get(4));
        scrollButtons.get(4).click();
        clickTab(7);
        checkLastItemText(itemList.get(7));
    }
}
