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

    // @todo #5341 Closing dialog should not change anything on the page,
    //  only explicit click on buttons should be used
    @Test(enabled = false, dataProviderClass = DialogDataProvider.class, dataProvider = "simpleDialogDataProvider")
    public void simpleDialogTest(String titleText, int index, String text) {
        simpleDialogButton.click();
        simpleDialogButton.dialog().is().displayed().and().has().title();
        simpleDialogButton.dialog().title().has().text(titleText);
        simpleDialogButton.dialog().list().has().size(3);
        simpleDialogButton.dialog().list().items().get(index).has().text(text);
        simpleDialogButton.dialog().list().items().get(index).click();
        simpleDialogButton.dialog().is().hidden();
        simpleDialogButton.actionText().has()
                .text(equalToIgnoringCase("Selected: " + text.replaceAll(" ", "")));
    }


    @Test
    public void alertDialogTest() {
        alertDialogButton.click();
        alertDialogButton.dialog().is().displayed();
        alertDialogButton.dialog().title().has().text("Alert dialog question?");
        alertDialogButton.dialog().textContent().has().text(containsString("Lorem ipsum dolor sit amet"));
        alertDialogButton.dialog().close();
        alertDialogButton.dialog().is().hidden();
        alertDialogButton.actionText().has().text("Selected: close");
        alertDialogButton.click();
        alertDialogButton.dialog().is().displayed();
        alertDialogButton.dialog().confirm();
        alertDialogButton.actionText().has().text("Selected: ok");
    }

    // @todo #5341 Closing dialog should not change anything on the page, explicit click on buttons should be used
    @Test(enabled = false)
    public void formDialogsTest() {
        final String email = "email@example.com";
        formDialogButton.click();
        formDialogButton.dialog().is().displayed();
        formDialogButton.dialog().title().has().text("Form Dialog");
        formDialogButton.dialog().textContent().has().text(containsString("Lorem ipsum dolor sit amet"));
        formDialogButton.dialog().textField().sendKeys(email);
        formDialogButton.dialog().confirm();
        formDialogButton.dialog().is().hidden();
        formDialogButton.actionText().has().text("Entered email: " + email);
        formDialogButton.click();
        formDialogButton.dialog().is().displayed();
        formDialogButton.dialog().textField().has().text(email);
        formDialogButton.dialog().close();
        formDialogButton.dialog().is().hidden();
        formDialogButton.actionText().has().text("Entered email:");
    }

    @Test
    public void confirmationDialogTest() {
        confirmationDialogListItem.click();
        confirmationDialogListItem.dialog().is().displayed();
        confirmationDialogListItem.dialog().title().has().text("Phone Ringtone");
        confirmationDialogListItem.dialog().radioButtons().has().size(14);
        confirmationDialogListItem.dialog().radioButtons().select("Callisto");
        confirmationDialogListItem.dialog().confirm();
        confirmationDialogListItem.has().secondaryText("Callisto");
        confirmationDialogListItem.click();
        confirmationDialogListItem.dialog().radioButtons().select("None");
        confirmationDialogListItem.dialog().confirm();
        confirmationDialogListItem.has().secondaryText("None");
        confirmationDialogListItem.click();
        confirmationDialogListItem.dialog().radioButtons().select("Triton");
        confirmationDialogListItem.dialog().cancel();
        confirmationDialogListItem.has().secondaryText("None");
    }

    @Test
    public void scrollPaperDialogTests() {
        scrollPaperDialogButton.click();
        scrollPaperDialogButton.dialog().is().displayed();
        scrollPaperDialogButton.dialog().has().scrollableContent();
        scrollPaperDialogButton.dialog().title().has().text("Subscribe");
        scrollPaperDialogButton.dialog().textContent().has().text(containsString("Cras mattis consectetur purus"));
        scrollPaperDialogButton.dialog().clickButton("subscribe");
        scrollPaperDialogButton.actionText().has().text("Last clicked button: Subscribe");
        scrollPaperDialogButton.click();
        scrollPaperDialogButton.dialog().is().displayed();
        scrollPaperDialogButton.dialog().cancel();
        scrollPaperDialogButton.actionText().has().text("Last clicked button: Cancel");
    }

    @Test
    public void scrollBodyDialogTests() {
        scrollBodyDialogButton.click();
        scrollBodyDialogButton.dialog().is().displayed();
        scrollBodyDialogButton.dialog().has().scrollableBody();
        scrollBodyDialogButton.dialog().title().has().text("Subscribe");
        scrollBodyDialogButton.dialog().actionButtons().is().notVisible();
        scrollBodyDialogButton.dialog().scrollDialogBodyTo(4200);
        scrollBodyDialogButton.dialog().title().is().notVisible();
        scrollBodyDialogButton.dialog().actionButtons().is().visible();
        scrollBodyDialogButton.dialog().textContent().has().text(containsString("Cras mattis consectetur purus"));
        scrollBodyDialogButton.dialog().clickButton("subscribe");
        scrollBodyDialogButton.actionText().has().text("Last clicked button: Subscribe");
        scrollBodyDialogButton.click();
        scrollBodyDialogButton.dialog().is().displayed();
        scrollBodyDialogButton.dialog().cancel();
        scrollBodyDialogButton.actionText().has().text("Last clicked button: Cancel");
    }

}
