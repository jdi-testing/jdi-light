package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.alertDialogPage;
import static io.github.com.StaticSite.confirmDialogPage;
import static io.github.com.StaticSite.dialogFrame;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class DialogTests extends TestsInit {

    @Test
    public void alertDialogTest() {
        alertDialogPage.open();
        dialogFrame.button.click();
        dialogFrame.dialog.is().dialogDisplayed();
        dialogFrame.dialog.is().titleDisplayed("Alert dialog question?");
        dialogFrame.dialog.clickOkButton();
        dialogFrame.button.click();
        dialogFrame.dialog.is().dialogDisplayed();
        dialogFrame.dialog.is().titleDisplayed("Alert dialog question?");
        dialogFrame.dialog.clickCloseButton();
    }

    @Test
    public void confirmDialogTest() {
        confirmDialogPage.open();
        dialogFrame.confirmButton.click();
        dialogFrame.dialog.is().dialogDisplayed();
        dialogFrame.dialog.is().titleDisplayed("Dialog with confirmation");
        dialogFrame.dialog.clickCancelButton();
    }

}
