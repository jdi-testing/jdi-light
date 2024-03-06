package io.github.epam.angular.tests.elements.complex;

import com.jdiai.tools.func.JAction;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.snackBarPage;


public class SnackbarTests extends TestsInit {

    private static final String MESSAGE = "Test Message";
    private static final String ACTION = "Test Action";

    @BeforeClass
    public void before() {
        snackBarPage.open();
        waitCondition(() -> snackBarPage.isOpened());
        snackBarPage.checkOpened();
    }

    @Test
    public void checkBasicSnackbarTest() {
        snackBarPage.messageInput.setValue(MESSAGE);
        snackBarPage.actionInput.setValue(ACTION);
        snackBarPage.openButton.click();

        snackBarPage.basicSnackbar.is().displayed();
        snackBarPage.basicSnackbar.has().message(MESSAGE);
        snackBarPage.basicSnackbar.actionButton().has().text(ACTION);
    }

    @Test
    public void checkSnackbarClickActionDismissTest() {
        snackBarPage.messageInput.setValue(MESSAGE);
        snackBarPage.actionInput.setValue(ACTION);
        snackBarPage.openButton.click();

        snackBarPage.basicSnackbar.actionButton().click();
        snackBarPage.basicSnackbar.is().disappear();
    }

    @Test
    public void checkSnackbarWithNoActionTest() {
        snackBarPage.messageInput.setValue(MESSAGE);
        snackBarPage.actionInput.setValue("");
        snackBarPage.openButton.click();

        snackBarPage.basicSnackbar.has().shown();
        snackBarPage.basicSnackbar.actionButton().has().notAppear();
    }

    @Test
    public void checkSnackbarDurationTest() {
        final int DURATION = 5; // Duration in seconds

        // Set the duration for the snackbar visibility
        snackBarPage.durationInput.setValue(String.valueOf(DURATION));

        // Open the custom snackbar
        snackBarPage.customSnackbarOpenButton.click();

        // Wait for the snackbar to be displayed
        snackBarPage.customSnackbar.base().timer().waitFor(() -> snackBarPage.customSnackbar.isDisplayed(), DURATION, "Snackbar did not appear in expected time");

        // Then, wait for the snackbar to disappear.
        // Assuming snackbar visibility duration is DURATION, add a buffer to wait for disappearance.
        int waitTimeForDisappearance = DURATION + 2; // Adding a buffer time for it to disappear
        snackBarPage.customSnackbar.base().timer().waitFor(() -> snackBarPage.customSnackbar.isHidden(), waitTimeForDisappearance, "Snackbar did not disappear in expected time");
    }
}
