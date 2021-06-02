package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.clickAwayListenerPage;
import static io.github.com.pages.utils.ClickAwayListenerPage.*;

/**
 * To see an example of Click Away Listener web element please visit https://material-ui.com/ru/components/click-away-listener/
 */

public class ClickAwayListenerTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        clickAwayListenerPage.open();
        clickAwayListenerPage.shouldBeOpened();
    }

    @Test
    public void exampleClickAwayListenerTest() {
        textFieldTest(1);
    }

    @Test
    public void portalExampleClickAwayListenerTest() {
        textFieldTest(2);
    }

    private void textFieldTest(int buttonId) {
        clickButton(buttonId);
        text.is().displayed();
        clickButton(buttonId);
        text.is().hidden();
        clickButton(buttonId);
        text.is().displayed();
        clickAroundTextPopup(text.getSize().width + 1, -1);
        text.is().hidden();
        clickButton(buttonId);
        clickAroundButton(exampleButton.getSize().width + 1, 0, buttonId);
        text.is().hidden();
    }

    public void clickAroundTextPopup(int x, int y) {
        text.core().click(x, y);
    }

    public void clickAroundButton(int x, int y, int buttonId) {
        if (buttonId == 1)
            exampleButton.core().click(x, y);
        else if (buttonId == 2)
            portalButton.core().click(x, y);
    }

    public void clickButton(int buttonId) {
        if (buttonId == 1)
            exampleButton.click();
        else if (buttonId == 2)
            portalButton.click();
    }
}
