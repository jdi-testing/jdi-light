package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.consecutiveSnackbarFrame;
import static io.github.com.StaticSite.feedbackSnackbarConsecutivePage;
import static io.github.com.StaticSite.feedbackSnackbarSimplePage;
import static io.github.com.StaticSite.simpleSnackbarFrame;

public class SnackbarTests extends TestsInit {

    @Test
    public void simpleSnackbarTest() {
        feedbackSnackbarSimplePage.open();

        simpleSnackbarFrame.snackbar.is().notExist();
        simpleSnackbarFrame.openSnackbarButton.click();
        simpleSnackbarFrame.snackbar.is().visible();
        simpleSnackbarFrame.snackbar.has().content("Note archived");
        simpleSnackbarFrame.snackbar.clickAction();
        simpleSnackbarFrame.snackbar.is().notExist();
    }

    @Test
    public void consecutiveSnackbarTest() {
        feedbackSnackbarConsecutivePage.open();

        consecutiveSnackbarFrame.snackbar.is().notExist();
        consecutiveSnackbarFrame.openFirstSnackbarButton.click();
        consecutiveSnackbarFrame.snackbar.is().visible();
        consecutiveSnackbarFrame.snackbar.has().content("Message A");
        consecutiveSnackbarFrame.openSecondSnackbarButton.click();
        consecutiveSnackbarFrame.snackbar.is().visible();
        consecutiveSnackbarFrame.snackbar.has().content("Message B");
        consecutiveSnackbarFrame.snackbar.clickAction();
        consecutiveSnackbarFrame.snackbar.is().notExist();
    }

}
