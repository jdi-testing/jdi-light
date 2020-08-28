package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.snackbarSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.*;

public class SnackbarUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @AfterMethod
    public void after() {
        refresh(); // for dismissing snack-bar
    }

    @Test
    public void correctMessageBasicTest() {
        snackbarSection.openButton.click();
        assertEquals(snackbarSection.basicSnackbar.getMessageText(),"Disco party!");
    }

    @Test
    public void correctActionBasicTest() {
        snackbarSection.openButton.click();
        assertEquals(snackbarSection.basicSnackbar.getActionText(),"Dance");
    }

    @Test
    public void visibilityActionSnackbarBasicTest() {
        snackbarSection.openButton.click();
        assertTrue(snackbarSection.basicSnackbar.isActionDisplayed());
    }

    @Test
    public void emptyActionSnackbarBasicTest() {
        snackbarSection.actionInput.setValue("");
        snackbarSection.openButton.click();
        assertFalse(snackbarSection.basicSnackbar.isActionDisplayed());
    }
}
