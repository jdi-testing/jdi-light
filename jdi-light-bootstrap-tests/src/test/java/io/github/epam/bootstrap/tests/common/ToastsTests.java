package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ToastsTests extends TestsInit {

    private String toastHeaderText = "Bootstrap";
    private String toastBodyText = "Hello, world! This is a toast message.";
    private String stackToastBodyText = "See? Just like this.";
    private String secondStackToastBodyText = "Heads up, toasts will stack automatically";

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
        simpleToast.body.is().text(toastBodyText);
    }

    @Test
    public void toastWithTopAlignValidationTest() {
        toastWithTopAlignButton.click();
        toastWithTopAlign.is().displayed();
        toastWithTopAlign.headerText.is().text(toastHeaderText);
        toastWithTopAlign.body.is().text(toastBodyText);
        toastWithTopAlign.closeButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        toastWithTopAlign.is().hidden();
    }

    @Test
    public void stackOfToastsValidationTest() {
        stackOfToastsButton.click();
        firstStackToast.is().displayed();
        secondStackToast.is().displayed();
        firstStackToast.headerText.is().text(toastHeaderText);
        firstStackToast.body.is().text(stackToastBodyText);
        secondStackToast.headerText.is().text(toastHeaderText);
        secondStackToast.body.is().text(secondStackToastBodyText);
    }

    @Test
    public void stackOfTopAlignToastsValidationTest() {
        stackOfToastsWithTopAlignButton.click();
        firstTopAlignStackToast.headerText.is().text(toastHeaderText);
        firstTopAlignStackToast.body.is().text(stackToastBodyText);
        secondTopAlignStackToast.headerText.is().text(toastHeaderText);
        secondTopAlignStackToast.body.is().text(secondStackToastBodyText);
        firstTopAlignStackToast.is().displayed();
        secondTopAlignStackToast.is().displayed();
    }
}
