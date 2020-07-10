package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.snackbarSection;
import static io.github.epam.angular.tests.elements.BaseValidationsUtils.duration;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class SnackbarUnitTests extends TestsInit{

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void displayedBasicTest() {
        //assertFalse(snackbarSection.basicSnackbar.isDisplayed());
        //snackbarSection.openButton.click();
        //assertTrue(snackbarSection.basicSnackbar.isDisplayed());
    }

    @Test
    public void displayedCustomTest() {
        assertFalse(snackbarSection.customSnackbar.isDisplayed());
        snackbarSection.durationInput.setValue("10");
        snackbarSection.customSnackbarOpenButton.click();
        assertTrue(snackbarSection.customSnackbar.isDisplayed());
        refresh(); // for dismissing snack-bar
    }

    @Test
    public void notDisplayedAfterSetDurationTest() {
        snackbarSection.durationInput.setValue("2");
        snackbarSection.customSnackbarOpenButton.click();
        duration(2, () -> {
            snackbarSection.customSnackbar.base().timer().wait(() -> snackbarSection.customSnackbar.isDisplayed());
            snackbarSection.customSnackbar.base().timer().wait(() -> snackbarSection.customSnackbar.isHidden());});
        refresh(); // for dismissing snack-bar
    }

    @Test
    public void correctTextCustomTest() {
        snackbarSection.durationInput.setValue("10");
        snackbarSection.customSnackbarOpenButton.click();
        assertEquals(snackbarSection.customSnackbar.firstChild().text(), "Pizza party!!! \uD83C\uDF55");
        refresh(); // for dismissing snack-bar
    }
}
