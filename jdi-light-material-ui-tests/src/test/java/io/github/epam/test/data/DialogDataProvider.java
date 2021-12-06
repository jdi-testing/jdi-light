package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static io.github.com.pages.feedback.DialogPage.confirmationDialogCancelButton;
import static io.github.com.pages.feedback.DialogPage.confirmationDialogOkButton;
import static io.github.com.pages.feedback.DialogPage.dialogCallistoRingtone;
import static io.github.com.pages.feedback.DialogPage.dialogCloseButton;
import static io.github.com.pages.feedback.DialogPage.dialogLunaRingtone;
import static io.github.com.pages.feedback.DialogPage.dialogOkButton;
import static io.github.com.pages.feedback.DialogPage.scrollableDialogCancelButton;
import static io.github.com.pages.feedback.DialogPage.subscribeButton;

public class DialogDataProvider {
    private final String dialogTextContent =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ultricesurna tortor, " +
                    "ac pharetra tortor venenatis id. Praesent consecteturtempor fringilla." +
                    " Cras laoreet sodales pellentesque. Ut nibh leo,auctor id massa vitae," +
                    " consequat congue turpis.";

    @DataProvider
    public Object[][] simpleDialogDataProvider() {
        return new Object[][]{
                {"Set backup account", "Selected: username@gmail.com"},
        };
    }

    @DataProvider
    public Object[][] alertDialogDataProvider() {
        return new Object[][]{
                {"Alert dialog question?", dialogTextContent, dialogOkButton, "Selected: ok"},
                {"Alert dialog question?", dialogTextContent, dialogCloseButton, "Selected: close"},
        };
    }

    @DataProvider
    public Object[][] formDialogDataProvider() {
        return new Object[][]{
                {"Form Dialog", dialogTextContent, "email@example.com", "Entered email: email@example.com"},
                {"Form Dialog", dialogTextContent, "", "Entered email:"},
        };
    }

    @DataProvider
    public Object[][] confirmationDialogDataProvider() {
        return new Object[][]{
                {"Phone Ringtone", dialogCallistoRingtone, confirmationDialogOkButton, "Callisto"},
                {"Phone Ringtone", dialogLunaRingtone, confirmationDialogCancelButton, "Dione"},
        };
    }

    @DataProvider
    public Object[][] scrollableDialogDataProvider() {
        String dialogScrollableTextContent = "Cras mattis consectetur purus sit amet fermentum. " +
                "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac " +
                "consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl" +
                " consectetur et.";

        return new Object[][]{
                {"Subscribe", dialogScrollableTextContent, subscribeButton, "Last clicked button: Subscribe"},
                {"Subscribe", dialogScrollableTextContent,
                        scrollableDialogCancelButton, "Last clicked button: Cancel"},
        };
    }
}
