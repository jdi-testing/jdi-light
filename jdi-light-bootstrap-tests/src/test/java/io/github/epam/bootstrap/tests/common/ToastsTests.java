package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ToastsTests extends TestsInit {

    private String toastHeaderText = "Bootstrap";
    private String simpleToastBodyText = "Hello, world! This is a toast message.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void simpleToastValidationTest() {
        simpleToastButton.click();
        simpleToast.is().displayed();
        simpleToast.headerText.is().text(toastHeaderText);
        simpleToast.body.is().text(simpleToastBodyText);
    }

    @Test
    public void isToastWithTopAlignDisplayedTest() {
        toastWithTopAlignButton.click();
        toastWithTopAlign.is().displayed();
    }
}
