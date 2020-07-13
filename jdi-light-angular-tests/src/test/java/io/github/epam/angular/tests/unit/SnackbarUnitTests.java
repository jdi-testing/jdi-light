package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.snackbarSection;
import static io.github.epam.angular.tests.elements.BaseValidationsUtils.duration;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

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
    public void displayedBasicTest() {
        snackbarSection.basicSnackbar.is().hidden();
        snackbarSection.openButton.click();
        snackbarSection.basicSnackbar.is().displayed();
    }

    @Test
    public void correctMessageBasicTest() {
        snackbarSection.openButton.click();
        snackbarSection.basicSnackbar.children().get(1).has().text(snackbarSection.messageInput.getText());
    }

    @Test
    public void correctActionBasicTest() {
        snackbarSection.openButton.click();
        snackbarSection.basicSnackbar.children().get(2).has().text(snackbarSection.actionInput.getText());
    }

    @Test
    public void closingSnackbarBasicTest() {
        snackbarSection.openButton.click();
        snackbarSection.basicSnackbar.children().get(2).click();
        snackbarSection.basicSnackbar.is().hidden();
    }

    @Test
    public void displayedCustomTest() {
        snackbarSection.customSnackbar.is().hidden();
        snackbarSection.durationInput.setValue("10");
        snackbarSection.customSnackbarOpenButton.click();
        snackbarSection.customSnackbar.is().displayed();
    }

    @Test
    public void correctDurationCustomTest() {
        int showDuration = 5;
        snackbarSection.durationInput.setValue(String.valueOf(showDuration));
        snackbarSection.customSnackbarOpenButton.click();
        duration(showDuration, () -> {
            snackbarSection.customSnackbar.base().timer().wait(() -> snackbarSection.customSnackbar.is().displayed());
            snackbarSection.customSnackbar.base().timer().wait(() -> snackbarSection.customSnackbar.is().hidden());
        });
    }

    @Test
    public void correctTextCustomTest() {
        snackbarSection.durationInput.setValue("10");
        snackbarSection.customSnackbarOpenButton.click();
        snackbarSection.customSnackbar.firstChild().is().text("Pizza party!!! \uD83C\uDF55");
    }
}
