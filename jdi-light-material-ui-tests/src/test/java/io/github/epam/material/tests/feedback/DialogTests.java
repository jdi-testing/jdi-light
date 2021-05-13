package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.dialogPage;
import static io.github.com.pages.feedback.DialogPage.*;
import static org.hamcrest.Matchers.containsString;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Dialog web element please visit https://material-ui.com/components/dialogs/
 */

public class DialogTests extends TestsInit {

    private static Timer timer = new Timer(1000L);
    private static String dialogTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ultricesurna tortor, " +
            "ac pharetra tortor venenatis id. Praesent consecteturtempor fringilla." +
            " Cras laoreet sodales pellentesque. Ut nibh leo,auctor id massa vitae," +
            " consequat congue turpis.";
    private static String dialogScrollableTextContent = "Cras mattis consectetur purus sit amet fermentum. " +
            "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. " +
            "Praesent commodo cursus magna, vel scelerisque nisl consectetur et.";

    @BeforeMethod
    public void before() {
        dialogPage.open();
    }


    @Test
    public void simpleDialogTest() {

        simpleDialogButton.click();
        dialogTitle.is().text("Set backup account");
        simpleDialogListButton.click();
        simpleDialogField.is().text("Selected: username@gmail.com");
    }

    @Test
    public void alertDialogTest() {

        alertDialogButton.click();
        dialogTitle.is().text("Alert dialog question?");
        dialogContent.is().text(dialogTextContent);
        dialogOkButton.click();
        timer.wait(() -> dialogContent.is().notVisible());
        alertDialogField.is().text("Selected: ok");
        alertDialogButton.click();
        dialogCloseButton.click();
        timer.wait(() -> dialogContent.is().notVisible());
        alertDialogField.is().text("Selected: close");
    }

    @Test
    public void formDialogsTest() {

        formDialogButton.click();
        dialogTitle.is().text("Form Dialog");
        dialogContent.is().text(dialogTextContent);
        dialogEmailInputForm.input("email@example.com");
        dialogOkButton.click();
        formDialogField.is().text("Entered email: email@example.com");
        formDialogButton.click();
        dialogCloseButton.click();
        formDialogField.is().text("Entered email:");
    }

    @Test
    public void confirmationDialogTest() {

        confirmationDialogButton.click();
        phoneRingtoneDialogTitle.is().text("Phone Ringtone");
        dialogCallistoRingtone.click();
        confirmationDialogOkButton.click();
        confirmationDialogField.is().text("Callisto");
        confirmationDialogButton.click();
        dialogLunaRingtone.click();
        confirmationDialogCancelButton.click();
        confirmationDialogField.is().text("Callisto");
    }

    @Test
    public void scrollableDialogTest() {

        scrollPaperDialogButton.click();
        dialogTitle.is().text("Subscribe");
        dialogScrollableContent.core()
                .jsExecute("scrollTo(0, document.body.scrollHeight)");
        dialogContent.is().text(containsString(dialogScrollableTextContent));
        subscribeButton.click();
        scrollableDialogField.is().text("Last clicked button: Subscribe");
        scrollPaperDialogButton.click();
        scrollableDialogCancelButton.click();
        scrollableDialogField.is().text("Last clicked button: Cancel");

        scrollBodyDialogButton.click();
        dialogTitle.is().text("Subscribe");
        subscribeButton.core()
                .jsExecute("scrollIntoView()");
        dialogContent.is().text(containsString(dialogScrollableTextContent));
        subscribeButton.click();
        scrollableDialogField.is().text("Last clicked button: Subscribe");
        scrollPaperDialogButton.click();
        scrollableDialogCancelButton.click();
        scrollableDialogField.is().text("Last clicked button: Cancel");
    }
}
