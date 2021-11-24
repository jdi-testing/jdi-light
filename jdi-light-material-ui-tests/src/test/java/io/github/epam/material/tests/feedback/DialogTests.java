package io.github.epam.material.tests.feedback;

import static io.github.com.StaticSite.dialogPage;
import static org.hamcrest.Matchers.containsString;
import static io.github.com.pages.feedback.DialogPage.alertDialogButton;
import static io.github.com.pages.feedback.DialogPage.alertDialogField;
import static io.github.com.pages.feedback.DialogPage.confirmationDialogButton;
import static io.github.com.pages.feedback.DialogPage.confirmationDialogField;
import static io.github.com.pages.feedback.DialogPage.dialogContent;
import static io.github.com.pages.feedback.DialogPage.dialogEmailInputForm;
import static io.github.com.pages.feedback.DialogPage.dialogOkButton;
import static io.github.com.pages.feedback.DialogPage.dialogTitle;
import static io.github.com.pages.feedback.DialogPage.formDialogButton;
import static io.github.com.pages.feedback.DialogPage.formDialogField;
import static io.github.com.pages.feedback.DialogPage.phoneRingtoneDialogTitle;
import static io.github.com.pages.feedback.DialogPage.scrollPaperDialogButton;
import static io.github.com.pages.feedback.DialogPage.scrollableDialogField;
import static io.github.com.pages.feedback.DialogPage.simpleDialogButton;
import static io.github.com.pages.feedback.DialogPage.simpleDialogField;
import static io.github.com.pages.feedback.DialogPage.simpleDialogListButton;

import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.epam.TestsInit;
import io.github.epam.test.data.DialogDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Dialog web element please visit
 * https://material-ui.com/components/dialogs/
 */

public class DialogTests extends TestsInit {

    @BeforeMethod
    public void before() {
        dialogPage.open();
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "simpleDialogDataProvider")
    public void simpleDialogTest(String dialogTitleText, String dialogResultFieldText) {
        simpleDialogButton.click();
        dialogTitle.is().text(dialogTitleText);
        simpleDialogListButton.click();
        simpleDialogField.is().text(dialogResultFieldText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "alertDialogDataProvider")
    public void alertDialogTest(String dialogTitleText, String dialogContentText,
                                Button selectedButton, String dialogResultFieldText) {
        alertDialogButton.click();
        dialogTitle.is().text(dialogTitleText);
        dialogContent.is().text(dialogContentText);
        selectedButton.click();
        alertDialogField.is().text(dialogResultFieldText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "formDialogDataProvider")
    public void formDialogsTest(String dialogTitleText, String dialogContentText,
                                String email, String dialogResultFieldText) {
        formDialogButton.click();
        dialogTitle.is().text(dialogTitleText);
        dialogContent.is().text(dialogContentText);
        dialogEmailInputForm.input(email);
        dialogOkButton.click();
        formDialogField.is().text(dialogResultFieldText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "confirmationDialogDataProvider")
    public void confirmationDialogTest(String dialogTitleText, Button selectedButton,
                                       Button selectedCloseButton, String dialogResultFieldText) {
        confirmationDialogButton.click();
        phoneRingtoneDialogTitle.is().text(dialogTitleText);
        selectedButton.click();
        selectedCloseButton.click();
        confirmationDialogField.is().text(dialogResultFieldText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "scrollableDialogDataProvider")
    public void scrollableDialogTest(String dialogTitleText, String dialogContentText,
                                     Button selectedButton, String dialogResultFieldText) {
        scrollPaperDialogButton.click();
        dialogTitle.is().text(dialogTitleText);
        dialogContent.is().text(containsString(dialogContentText));
        selectedButton.click();
        scrollableDialogField.is().text(dialogResultFieldText);
    }
}
