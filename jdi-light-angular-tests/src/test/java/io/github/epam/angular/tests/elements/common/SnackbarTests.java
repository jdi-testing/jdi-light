package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.snackbarSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class SnackbarTests extends TestsInit {

    private static final String MESSAGE = "my message";
    private static final String ACTION = "my action";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicSnackbarTest() {
        snackbarSection.messageInput.setValue(MESSAGE);
        snackbarSection.actionInput.setValue(ACTION);
        snackbarSection.openButton.click();
        snackbarSection.basicSnackbar.is().displayed();
        snackbarSection.basicSnackbar.children().get(1).is().text(MESSAGE);
        snackbarSection.basicSnackbar.children().get(2).is().text(ACTION);
        snackbarSection.basicSnackbar.children().get(2).click();
        snackbarSection.basicSnackbar.is().hidden();
    }


    
}