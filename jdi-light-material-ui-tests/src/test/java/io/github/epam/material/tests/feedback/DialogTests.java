package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import io.github.epam.test.data.DialogDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dialogPage;
import static io.github.com.pages.feedback.DialogPage.alertDialog;
import static io.github.com.pages.feedback.DialogPage.alertDialogButton;
import static io.github.com.pages.feedback.DialogPage.alertDialogSelectedText;
import static io.github.com.pages.feedback.DialogPage.confirmationDialog;
import static io.github.com.pages.feedback.DialogPage.confirmationDialogListItem;
import static io.github.com.pages.feedback.DialogPage.formDialog;
import static io.github.com.pages.feedback.DialogPage.formDialogButton;
import static io.github.com.pages.feedback.DialogPage.formDialogSelectedText;
import static io.github.com.pages.feedback.DialogPage.scrollBodyButton;
import static io.github.com.pages.feedback.DialogPage.scrollBodyDialog;
import static io.github.com.pages.feedback.DialogPage.scrollPaperButton;
import static io.github.com.pages.feedback.DialogPage.scrollPaperDialog;
import static io.github.com.pages.feedback.DialogPage.simpleDialog;
import static io.github.com.pages.feedback.DialogPage.simpleDialogButton;
import static io.github.com.pages.feedback.DialogPage.simpleDialogSelectedText;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class DialogTests extends TestsInit {

    @BeforeMethod
    public void before() {
        dialogPage.open();
        dialogPage.isOpened();
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "simpleDialogDataProvider")
    public void simpleDialogTest(String titleText, int index, String text) {
        simpleDialogButton.click();
        simpleDialog.is().displayed();
        simpleDialog.title().has().text(titleText);
        simpleDialog.listItems().has().size(3);
        simpleDialog.listItems().get(index).has().text(text);
        simpleDialog.listItems().get(index).click();
        simpleDialog.is().hidden();
        simpleDialogSelectedText.has().text(equalToIgnoringCase("Selected: " + text.replaceAll(" ", "")));
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "alertDialogDataProvider")
    public void alertDialogTest(String titleText, String dialogText, String closedText, String confirmedText) {
        alertDialogButton.click();
        alertDialog.is().displayed();
        alertDialog.title().has().text(titleText);
        alertDialog.textContent().has().text(dialogText);
        alertDialog.close();
        alertDialog.is().hidden();
        alertDialogSelectedText.has().text(closedText);
        alertDialogButton.click();
        alertDialog.is().displayed();
        alertDialog.confirm();
        alertDialogSelectedText.has().text(confirmedText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "formDialogDataProvider")
    public void formDialogsTest(String titleText, String dialogText,
                                String email, String confirmedText, String closedText) {
        formDialogButton.click();
        formDialog.is().displayed();
        formDialog.title().has().text(titleText);
        formDialog.textContent().has().text(dialogText);
        formDialog.input().sendKeys(email);
        formDialog.confirm();
        formDialog.is().hidden();
        formDialogSelectedText.has().text(confirmedText);
        formDialogButton.click();
        formDialog.is().displayed();
        formDialog.input().has().text(email);
        formDialog.close();
        formDialog.is().hidden();
        formDialogSelectedText.has().text(closedText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "confirmationDialogDataProvider")
    public void confirmationDialogTest(String titleText, String firstRadioText,
                                       String secondRadioText, String thirdRadioText) {
        confirmationDialogListItem.click();
        confirmationDialog.is().displayed();
        confirmationDialog.title().has().text(titleText);
        confirmationDialog.radioButtons().has().size(14);
        confirmationDialog.radioButtons().select(firstRadioText);
        confirmationDialog.confirm();
        confirmationDialogListItem.has().secondaryText(firstRadioText);
        confirmationDialogListItem.click();
        confirmationDialog.radioButtons().select(secondRadioText);
        confirmationDialog.confirm();
        confirmationDialogListItem.has().secondaryText(secondRadioText);
        confirmationDialogListItem.click();
        confirmationDialog.radioButtons().select(thirdRadioText);
        confirmationDialog.close();
        confirmationDialogListItem.has().secondaryText(secondRadioText);
    }

    @Test
    public void scrollPaperDialogTest() {
        scrollPaperButton.click();
        scrollPaperDialog.is().displayed();
    }

    @Test
    public void scrollBodyDialogTest() {
        scrollBodyButton.click();
        scrollBodyDialog.is().displayed();
    }

//    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "scrollableDialogDataProvider")
//    public void scrollableDialogTest(String dialogTitleText, String dialogContentText,
//                                     Button selectedButton, String dialogResultFieldText) {
//        scrollPaperDialogButton.click();
//        dialogTitle.is().text(dialogTitleText);
//        dialogContent.is().text(containsString(dialogContentText));
//        selectedButton.click();
//        scrollableDialogField.is().text(dialogResultFieldText);
//    }

}
