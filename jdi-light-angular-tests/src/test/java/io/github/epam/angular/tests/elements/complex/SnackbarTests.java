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
        final int DURATION = 5;

        JAction action = () -> {
            snackBarPage.customSnackbar.base().timer().wait(() -> snackBarPage.customSnackbar.isDisplayed());
            snackBarPage.customSnackbar.base().timer().wait(() -> snackBarPage.customSnackbar.isHidden());
        };

        snackBarPage.durationInput.setValue(String.valueOf(DURATION));
        snackBarPage.customSnackbarOpenButton.click();
    }
}
