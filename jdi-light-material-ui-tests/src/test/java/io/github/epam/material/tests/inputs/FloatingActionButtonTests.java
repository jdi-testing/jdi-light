package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.floatingActionButtonPage;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonAdd;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonEdit;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonLike;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonNavigate;
import static io.github.com.pages.inputs.FloatingActionButtonPage.floatingAnimatedButton;
import static io.github.com.pages.inputs.FloatingActionButtonPage.labelAnimatedLastClick;
import static io.github.com.pages.inputs.FloatingActionButtonPage.labelLastClick;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Floating Action Buttons web element please visit
 * https://material-ui.com/components/floating-action-button/
 * Floating Action Button
 */

public class FloatingActionButtonTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        floatingActionButtonPage.open();
        floatingActionButtonPage.isOpened();
    }

    @Test
    public void basicButtonsTest() {
        buttonAdd.is().displayed().and().is().enabled();
        buttonAdd.click();
        labelLastClick.has().text("Last click: Add");

        buttonEdit.is().displayed().and().is().enabled();
        buttonEdit.click();
        labelLastClick.has().text("Last click: Edit");

        buttonNavigate.is().displayed().and().is().enabled();
        buttonNavigate.click();
        labelLastClick.is().text("Last click: Navigate");

        buttonLike.is().displayed().and().is().disabled();
    }

    @Test
    public void animatedButtonsTest() {
        floatingAnimatedButton.tabs().is().displayed();
        labelAnimatedLastClick.has().text("Last click:");

        floatingAnimatedButton.tabs().select(1);
        floatingAnimatedButton.animatedLabel().has().text("Item One");
        floatingAnimatedButton.animatedButton().waitFor().enabled();
        floatingAnimatedButton.animatedButton().is().displayed();
        floatingAnimatedButton.animatedButton().click();
        labelAnimatedLastClick.has().text("Last click: Add");

        floatingAnimatedButton.tabs().select(2);
        floatingAnimatedButton.animatedLabel().has().text("Item Two");
        floatingAnimatedButton.animatedButton().waitFor().enabled();
        floatingAnimatedButton.animatedButton().is().displayed();
        floatingAnimatedButton.animatedButton().click();
        labelAnimatedLastClick.has().text("Last click: Edit");

        floatingAnimatedButton.tabs().select(3);
        floatingAnimatedButton.animatedLabel().has().text("Item Three");
        floatingAnimatedButton.animatedButton().waitFor().enabled();
        floatingAnimatedButton.animatedButton().is().displayed();
        floatingAnimatedButton.animatedButton().click();
        labelAnimatedLastClick.has().text("Last click: Expand");
    }
}
