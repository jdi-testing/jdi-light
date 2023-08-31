package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.InputsTypes.TEXT;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.inputPage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.InputPage.*;

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
        foodBasicInput.show();
        foodBasicInput.isVisible();
        foodBasicInput.has().placeholder("Ex. Pizza")
                      .and().value("Sushi");
        foodBasicInput.clearAndSetText("Lasagna")
                      .has().typedText("Lasagna");
        foodBasicInput.clearAndSetText("Ice Cream")
                      .has().typedText("Ice");

        leaveACommentBasicInput.isDisplayed();
        leaveACommentBasicInput.show();
        leaveACommentBasicInput.isVisible();
        leaveACommentBasicInput.has().placeholder("Ex. It makes me feel...");
        leaveACommentBasicInput.clearAndSetText("Delicious")
                               .has().typedText("Delicious");
    }

    @Test(description = "")
    public void inputWithACustomErrorStateMatcherTest() {
        emailErrorStateMatcherInput.isDisplayed();
        emailErrorStateMatcherInput.show();
        emailErrorStateMatcherInput.isVisible();
        emailErrorStateMatcherInput.has().placeholder("Ex. pat@example.com");
        emailErrorStateMatcherInput.clearAndSetText("test");
        errorStateMatcherMessage.is().text("Please enter a valid email address");
    }

    @Test(description = "")
    public void clearableInputTest() {
        inputWithClearButton.isDisabled();
        inputWithClearButton.show();
        inputWithClearButton.isVisible();
        inputWithClearButton.has().inputType(TEXT);
        inputWithClearButton.clearAndSetText("test");
        inputWithClearButton.has().typedText("test");
        clearButton.isDisplayed();
        clearButton.click();
        inputWithClearButton.is().typedText("");
    }

    @Test(description = "")
    public void inputWithErrorMessagesTest() {
        inputErrorMail.isDisplayed();
        inputErrorMail.show();
        inputErrorMail.isVisible();
        inputErrorMail.has().placeholder("Ex. pat@example.com");
        inputErrorMail.clearAndSetText("test");
        inputErrorMail.pressButton(Keys.ENTER);
        errorMessage.isDisplayed();
        errorMessage.is().text("Please enter a valid email address");
    }

    @Test
    public void inputWithTextAutoResizingTest() {
        autoSizeTextArea.isDisplayed();
        autoSizeTextArea.show();
        autoSizeTextArea.isVisible();
        autoSizeTextArea.has().autoSize();
        autoSizeTextArea.clearAndSetText("line1")
                        .pressButton(Keys.ENTER)
                        .sendKeys("line2");
        autoSizeTextArea.is().typedText("line1\nline2");
        autoSizeTextArea.clear();
        autoSizeTextArea.is().typedText("");
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
        messageHintInput.show();
        messageHintInput.isVisible();
        messageHintInput.has().placeholder("Ex. I need help with...");
        messageHintInput.clearAndSetText("test");
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
        telephoneInput.has().placeholder("555-555-1234");
        telephoneInput.clearAndSetText("0123456789");
        telephoneInput.clear();
        telephoneInput.is().typedText("");
    }

    @Test(description = "")
    public void inputWithAriaLabelTest() {
        ariaLabelInput.isDisplayed();
        ariaLabelInput.show();
        ariaLabelInput.isVisible();
        ariaLabelInput.has().inputType(TEXT);
        ariaLabelInput.has().label("Clear");
    }

    @Test(description = "")
    public void readonlyInputTest() {
        readonlyInput.isDisplayed();
        readonlyInput.show();
        readonlyInput.isVisible();
        readonlyInput.has().inputType(TEXT)
                     .and().readonly();
    }
}
