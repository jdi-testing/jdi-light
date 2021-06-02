package io.github.epam.material.tests.navigation;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.tabPage;
import static io.github.com.pages.navigation.TabPage.*;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Tab please visit
 * https://material-ui.com/components/tabs/
 */

public class TabTests extends TestsInit {
    private List<List<Button>> tableLocators;
    private List<String> itemList = Arrays.asList("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven");
    private int tableIndex;
    private Timer timer = new Timer(5000L);

    public void clickButton(int indexRow) { tableLocators.get(tableIndex).get(indexRow).click(); }

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
        clickButton(1);
        checkLastItemText(itemList.get(1));
        tableLocators.get(tableIndex).get(4).has().classValue(containsString("Mui-disabled"));
        clickButton(5);
        checkLastItemText(itemList.get(5));
    }

    @Test
    public void scrollableTabTest(){
        tableIndex = 2;
        clickButton(9);
        checkLastItemText(itemList.get(9));
        timer.wait(() -> scrollButtons.get(2).click());
        clickButton(11);
        checkLastItemText(itemList.get(11));
        timer.wait(() -> scrollButtons.get(1).click());
        clickButton(1);
        checkLastItemText(itemList.get(1));
    }

    @Test
    public void preventScrollTest() {
        tableIndex = 3;
        clickButton(1);
        checkLastItemText(itemList.get(1));
        clickButton(7);
        checkLastItemText(itemList.get(7));
    }

    @Test
    public void verticalTabTest() {
        tableIndex = 4;
        clickButton(1);
        checkLastItemText(itemList.get(1));
        scrollButtons.get(4).click();
        clickButton(4);
        checkLastItemText(itemList.get(4));
        scrollButtons.get(4).click();
        clickButton(7);
        checkLastItemText(itemList.get(7));
    }
}
