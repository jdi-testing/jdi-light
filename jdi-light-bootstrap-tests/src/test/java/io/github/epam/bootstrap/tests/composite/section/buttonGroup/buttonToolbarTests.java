package io.github.epam.bootstrap.tests.composite.section.buttonGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonToolbar;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class buttonToolbarTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void buttonsInButtonToolbarTest() {
        buttonToolbar.buttonsInToolbar.forEach(button -> button.is().displayed());
    }

    @Test
    public void inputFieldInButtonToolbarTest() {
        buttonToolbar.inputAreaInToolbar.is().displayed();
        buttonToolbar.inputAreaInToolbar.is().enabled();
    }
}
