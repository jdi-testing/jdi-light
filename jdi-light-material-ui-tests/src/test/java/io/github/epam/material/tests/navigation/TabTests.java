package io.github.epam.material.tests.navigation;

import com.epam.jdi.light.elements.common.WindowsManager;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.tabPage;
import static io.github.com.pages.navigation.TabPage.*;
import static org.hamcrest.Matchers.containsString;

/**
 * To see an example of Tab please visit https://material-ui.com/components/tabs/
 */
public class TabTests extends TestsInit {
    private List<List<Button>> tableLocators;
    private List<String> itemList = Arrays.asList("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven");
    private int tableIndex;
    private Timer timer = new Timer(5000L);

    public void scrollForward() {
        timer.wait(() ->scrollButtons.get(2).click());
    }

    public void scrollBackward() {
        timer.wait(() -> scrollButtons.get(1).click());
    }

    public void scrollUpward() {
        scrollButtons.get(3).click();
    }

    public void scrollDownward() {
        scrollButtons.get(4).click();
    }

    public void clickButton(int indexRow) {
        tableLocators.get(tableIndex).get(indexRow).click();
    }

    public void checkDisabled(int indexRow) {
        tableLocators.get(tableIndex).get(indexRow).has().classValue(containsString("Mui-disabled"));
    }

    public boolean isNotVisible(int indexRow) {
        return tableLocators.get(tableIndex).get(indexRow).isNotVisible();
    }

    public Button getButton(int indexRow) {
        return tableLocators.get(tableIndex).get(indexRow);
    }

    public void assertNotVisible(int indexRow) {
        tableLocators.get(tableIndex).get(indexRow).is().notVisible();
    }

    public void assertVisible(int indexRow) {
        timer.wait(() -> tableLocators.get(tableIndex).get(indexRow).is().visible());
    }

    public void checkLastItem(String name) {
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
        for (int i = 1; i <= 5; i++) {
            if (i != 4) {
                clickButton(i);
                checkLastItem(itemList.get(i));
            }
            else
                checkDisabled(i);
        }
    }

    @Test
    public void scrollableTabTest(){
        tableIndex = 2;
        for (int i = 11; i >= 1; i--) {
            if (isNotVisible(i))
                if (i > 6)
                    scrollForward();
                else
                    scrollBackward();
            clickButton(i);
            checkLastItem(itemList.get(i));
        }
        for (int i = 1; i <= 11; i++) {
            if (isNotVisible(i))
                if (i > 6)
                    scrollForward();
                else
                    scrollBackward();
            clickButton(i);
            checkLastItem(itemList.get(i));
        }
    }

    @Test
    public void preventScrollTest() {
        tableIndex = 3;
        WindowsManager.resizeWindow(1000, 800);
        for (int i = 1; i <= 5; i++) {
            clickButton(i);
            checkLastItem(itemList.get(i));
        }
        assertNotVisible(6);
        Button button = getButton(5);
        button.click();
        button.core().press(Keys.RIGHT);
        assertVisible(6);
    }

    @Test
    public void verticalTabTest() {
        tableIndex = 4;
        for (int i = 7; i >= 1; i--) {
            if (isNotVisible(i))
                if (i == 4 || i == 1)
                    scrollUpward();
            clickButton(i);
            checkLastItem(itemList.get(i));
        }
        for (int i = 1; i <= 7; i++) {
            if (isNotVisible(i))
                if (i == 4 || i == 7)
                    scrollDownward();
            clickButton(i);
            checkLastItem(itemList.get(i));
        }
    }
}
