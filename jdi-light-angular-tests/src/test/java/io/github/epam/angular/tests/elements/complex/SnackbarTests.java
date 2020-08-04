package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.tools.func.JAction;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.snackbarSection;
import static io.github.epam.angular.tests.elements.BaseValidationsUtils.duration;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class SnackbarTests extends TestsInit {

    private static final String MESSAGE = "Test Message";
    private static final String ACTION = "Test Action";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void checkBasicSnackbarTest() {
        snackbarSection.messageInput.setValue(MESSAGE);
        snackbarSection.actionInput.setValue(ACTION);
        snackbarSection.openButton.click();

        snackbarSection.basicSnackbar.is().displayed();
        snackbarSection.basicSnackbar.has().message(MESSAGE);
        snackbarSection.basicSnackbar.has().action(ACTION);
    }

    @Test
    public void checkSnackbarClickActionDismissTest() {
        snackbarSection.messageInput.setValue(MESSAGE);
        snackbarSection.actionInput.setValue(ACTION);
        snackbarSection.openButton.click();

        snackbarSection.basicSnackbar.clickAction();
        snackbarSection.basicSnackbar.is().disappear();
    }

    @Test
    public void checkSnackbarWithNoActionTest() {
        snackbarSection.messageInput.setValue(MESSAGE);
        snackbarSection.actionInput.setValue("");
        snackbarSection.openButton.click();

        snackbarSection.basicSnackbar.has().action();
    }

    @Test
    public void checkSnackbarDurationTest() {
        final int DURATION = 5;

        JAction action = () -> {
            snackbarSection.customSnackbar.base().timer().wait(() -> snackbarSection.customSnackbar.is().displayed());
            snackbarSection.customSnackbar.base().timer().wait(() -> snackbarSection.customSnackbar.is().hidden());
        };

        snackbarSection.durationInput.setValue(String.valueOf(DURATION));
        snackbarSection.customSnackbarOpenButton.click();

        duration(DURATION, 1000, action);
    }
}