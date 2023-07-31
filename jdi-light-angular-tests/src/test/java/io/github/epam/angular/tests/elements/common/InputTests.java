package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.inputPage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.InputPage.*;
import static org.hamcrest.Matchers.containsString;

public class InputTests extends TestsInit {

    @BeforeMethod
    public void before() {
        inputPage.open();
        waitCondition(() -> inputPage.isOpened());
        inputPage.checkOpened();
    }

    @Test(description = "")
    public void basicInputTest() {
        foodBasicInput.isDisplayed();
        foodBasicInput.clearAndTypeText("Lasagna")
                      .has().typedText("Lasagna");
        foodBasicInput.clearAndTypeText("Ice Cream")
                      .has().typedText("Ice");

        leaveACommentBasicInput.isDisplayed();
        leaveACommentBasicInput.typeText("Delicious")
                               .has().typedText("Delicious");
    }

    @Test(description = "")
    public void inputWithACustomErrorStateMatcherTest() {
        emailErrorStateMatcherInput.isDisplayed();
        emailErrorStateMatcherInput.typeText("test");
        errorStateMatcherMessage.is().text("Please enter a valid email address");
    }

    @Test
    public void autoResizingTextAreaTest() {
        autoSizeTextArea.isDisplayed();
        // TODO FIX TEST
        // autoSizeTextArea.has().cssClass("cdktextareaautosize");
        autoSizeTextArea.setLines("line1", "line2");
        autoSizeTextArea.addNewLine("line3");
        autoSizeTextArea.is().text("line1\nline2\nline3");
        autoSizeTextArea.clear();
        autoSizeTextArea.is().text("");
        autoSizeTextArea.setText("TextArea");
        autoSizeTextArea.is().text(containsString("Text"));
    }

    @Test(description = "")
    public void clearableInputTest() {
        clearableInput.show();
        clearableInput.clearAndTypeText("test");
        clearableInputButton.isDisplayed();
        clearableInputButton.click();
        clearableInput.is().typedText("");
    }

    @Test(description = "")
    public void inputWithErrorMessagesTest() {
        emailInput.isDisplayed();
        emailInput.typeText("test")
                  .typeText(Keys.ENTER);
        errorMessage.isDisplayed();
        errorMessage.is().text("Please enter a valid email address");
    }

    @Test
    public void inputsInAFormTest() {
        inputsForm.fill(DEFAULT_USER);
        inputsForm.firstName.is().typedText(DEFAULT_USER.firstName);
        inputsForm.lastName.is().typedText(DEFAULT_USER.lastName);
        inputsForm.address.is().typedText(DEFAULT_USER.address);
        inputsForm.address2.is().typedText(DEFAULT_USER.address2);
        inputsForm.city.is().typedText(DEFAULT_USER.city);
        inputsForm.state.is().typedText(DEFAULT_USER.state);
        inputsForm.postalCode.is().typedText(DEFAULT_USER.postalCode);
    }

    @Test(description = "")
    public void inputWithHintsTest() {
        messageHintInput.isDisplayed();
        messageHintInput.typeText("test");
        hintMassage.isDisplayed();
        hintMassage.is().text("Don't disclose personal info");
        counterHintMassage.isDisplayed();
        counterHintMassage.is().text("4 / 256");
    }

    @Test(description = "")
    public void inputWithPrefixesAndSuffixesTest() {
        inputPrefix.isDisplayed();
        inputSuffix.isDisplayed();
        telephoneInput.isDisplayed();
        telephoneInput.typeText("0123456789")
                      .clear()
                      .is().typedText("");
    }
}
