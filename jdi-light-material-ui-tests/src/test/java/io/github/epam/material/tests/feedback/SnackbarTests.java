package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.feedbackSnackbarSimplePage;
import static io.github.com.StaticSite.snackbarFrame;

public class SnackbarTests extends TestsInit {

    @Test
    public void simpleSnackbarTest() {
        feedbackSnackbarSimplePage.open();

        snackbarFrame.snackbar.is().notExist();
        snackbarFrame.openSnackbarButton.click();
        snackbarFrame.snackbar.is().visible();
        snackbarFrame.snackbar.has().content("Note archived");
        snackbarFrame.snackbar.clickAction();
        snackbarFrame.snackbar.is().notExist();
    }

}
