package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.dialogFrame;
import static io.github.com.StaticSite.feedbackDialogPage;
import static io.github.com.StaticSite.feedbackWithListDialogPage;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class DialogTests extends TestsInit {

    @Test
    public void dialogTest() {
        feedbackDialogPage.open();
        dialogFrame.scrollDialog.openDialog();
        dialogFrame.scrollDialog.clickCloseButton();
    }

    @Test
    public void dialogListTest() {
        feedbackWithListDialogPage.open();
        dialogFrame.scrollDialog.openDialog();
        dialogFrame.scrollDialog.selectOption("value #3");
    }

}
