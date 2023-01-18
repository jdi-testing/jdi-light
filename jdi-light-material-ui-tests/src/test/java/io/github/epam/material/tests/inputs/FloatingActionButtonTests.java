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
import io.github.epam.test.data.FloatingActionButtonDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test(dataProvider = "animatedButtonsTestData", dataProviderClass = FloatingActionButtonDataProvider.class)
    public void animatedButtonsTest(int index, String labelText, String lastClickLabel) {
        floatingAnimatedButton.tabs().is().displayed();
        labelAnimatedLastClick.has().text("Last click:");

        floatingAnimatedButton.tabs().select(index);
        floatingAnimatedButton.animatedLabel().has().text(labelText);
        floatingAnimatedButton.animatedButton().waitFor().enabled();
        floatingAnimatedButton.animatedButton().is().displayed();
        floatingAnimatedButton.animatedButton().click();
        labelAnimatedLastClick.has().text(lastClickLabel);
    }
}
