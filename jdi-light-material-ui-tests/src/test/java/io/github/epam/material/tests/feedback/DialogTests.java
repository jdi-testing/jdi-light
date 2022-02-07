package io.github.epam.material.tests.feedback;

import io.github.epam.TestsInit;
import io.github.epam.test.data.DialogDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dialogPage;
import static io.github.com.pages.feedback.DialogPage.alertDialogButton;
import static io.github.com.pages.feedback.DialogPage.confirmationDialogListItem;
import static io.github.com.pages.feedback.DialogPage.formDialogButton;
import static io.github.com.pages.feedback.DialogPage.scrollBodyDialogButton;
import static io.github.com.pages.feedback.DialogPage.scrollPaperDialogButton;
import static io.github.com.pages.feedback.DialogPage.simpleDialogButton;
import static org.hamcrest.Matchers.containsString;
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
        simpleDialogButton.dialog().is().displayed();
        simpleDialogButton.dialog().title().has().text(titleText);
        simpleDialogButton.dialog().list().has().size(3);
        simpleDialogButton.dialog().list().items().get(index).has().text(text);
        simpleDialogButton.dialog().list().items().get(index).click();
        simpleDialogButton.dialog().is().hidden();
        simpleDialogButton.actionText().has()
                .text(equalToIgnoringCase("Selected: " + text.replaceAll(" ", "")));
    }


    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "alertDialogDataProvider")
    public void alertDialogTest(String titleText, String dialogText, String closedText, String confirmedText) {
        alertDialogButton.click();
        alertDialogButton.dialog().is().displayed();
        alertDialogButton.dialog().title().has().text(titleText);
        alertDialogButton.dialog().textContent().has().text(dialogText);
        alertDialogButton.dialog().close();
        alertDialogButton.dialog().is().hidden();
        alertDialogButton.actionText().has().text(closedText);
        alertDialogButton.click();
        alertDialogButton.dialog().is().displayed();
        alertDialogButton.dialog().confirm();
        alertDialogButton.actionText().has().text(confirmedText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "formDialogDataProvider")
    public void formDialogsTest(String titleText, String dialogText,
                                String email, String confirmedText, String closedText) {
        formDialogButton.click();
        formDialogButton.dialog().is().displayed();
        formDialogButton.dialog().title().has().text(titleText);
        formDialogButton.dialog().textContent().has().text(dialogText);
        formDialogButton.dialog().input().sendKeys(email);
        formDialogButton.dialog().confirm();
        formDialogButton.dialog().is().hidden();
        formDialogButton.actionText().has().text(confirmedText);
        formDialogButton.click();
        formDialogButton.dialog().is().displayed();
        formDialogButton.dialog().input().has().text(email);
        formDialogButton.dialog().close();
        formDialogButton.dialog().is().hidden();
        formDialogButton.actionText().has().text(closedText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "confirmationDialogDataProvider")
    public void confirmationDialogTest(String titleText, String firstRadioText,
                                       String secondRadioText, String thirdRadioText) {
        confirmationDialogListItem.click();
        confirmationDialogListItem.dialog().is().displayed();
        confirmationDialogListItem.dialog().title().has().text(titleText);
        confirmationDialogListItem.dialog().radioButtons().has().size(14);
        confirmationDialogListItem.dialog().radioButtons().select(firstRadioText);
        confirmationDialogListItem.dialog().confirm();
        confirmationDialogListItem.has().secondaryText(firstRadioText);
        confirmationDialogListItem.click();
        confirmationDialogListItem.dialog().radioButtons().select(secondRadioText);
        confirmationDialogListItem.dialog().confirm();
        confirmationDialogListItem.has().secondaryText(secondRadioText);
        confirmationDialogListItem.click();
        confirmationDialogListItem.dialog().radioButtons().select(thirdRadioText);
        confirmationDialogListItem.dialog().close();
        confirmationDialogListItem.has().secondaryText(secondRadioText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "scrollableDialogDataProvider")
    public void scrollPaperDialogTests(String titleText, String dialogText,
                                       String subscribedText, String cancelledText) {
        scrollPaperDialogButton.click();
        scrollPaperDialogButton.dialog().is().displayed();
        scrollPaperDialogButton.dialog().has().scrollableContent();
        scrollPaperDialogButton.dialog().title().has().text(titleText);
        scrollPaperDialogButton.dialog().textContent().has().text(containsString(dialogText));
        scrollPaperDialogButton.dialog().confirm();
        scrollPaperDialogButton.actionText().has().text(subscribedText);
        scrollPaperDialogButton.click();
        scrollPaperDialogButton.dialog().is().displayed();
        scrollPaperDialogButton.dialog().close();
        scrollPaperDialogButton.actionText().has().text(cancelledText);
    }

    @Test(dataProviderClass = DialogDataProvider.class, dataProvider = "scrollableDialogDataProvider")
    public void scrollBodyDialogTests(String titleText, String dialogText,
                                      String subscribedText, String cancelledText) {
        scrollBodyDialogButton.click();
        scrollBodyDialogButton.dialog().is().displayed();
        scrollBodyDialogButton.dialog().has().scrollableBody();
        scrollBodyDialogButton.dialog().title().has().text(titleText);
        scrollBodyDialogButton.dialog().actions().is().notVisible();
        scrollBodyDialogButton.dialog().scrollDialogBodyTo(4200);
        scrollBodyDialogButton.dialog().title().is().notVisible();
        scrollBodyDialogButton.dialog().actions().is().visible();
        scrollBodyDialogButton.dialog().textContent().has().text(containsString(dialogText));
        scrollBodyDialogButton.dialog().confirm();
        scrollBodyDialogButton.actionText().has().text(subscribedText);
        scrollBodyDialogButton.click();
        scrollBodyDialogButton.dialog().is().displayed();
        scrollBodyDialogButton.dialog().close();
        scrollBodyDialogButton.actionText().has().text(cancelledText);
    }

}
