package io.github.epam.material.tests.utils;

import static io.github.com.pages.utils.ClickAwayListenerPage.text;
import static io.github.com.pages.utils.ClickAwayListenerPage.exampleButton;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.clickAwayListenerPage;

/**
 * To see an example of Click Away Listener web element please visit https://material-ui.com/ru/components/click-away-listener/
 */
public class ClickAwayListenerTests extends TestsInit {

    @BeforeTest
    public void beforeTest() {
        openSection("Click Away Listener");
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
        clickAwayListenerPage.clickButton(buttonId);
        text.is().displayed();
        //hiding text field by clicking on 'open menu dropdown' button
        clickAwayListenerPage.clickButton(buttonId);
        //checking point outside textfield
        text.is().hidden();
        clickAwayListenerPage.clickButton(buttonId);
        text.is().displayed();
        clickAwayListenerPage.clickAroundTextPopup(text.getSize().width + 1, -1);
        text.is().hidden();
        //check for a fixed bug
        clickAwayListenerPage.clickButton(buttonId);
        clickAwayListenerPage.clickAroundButton(exampleButton.getSize().width + 1,0, buttonId);
        text.is().hidden();
    }
}
