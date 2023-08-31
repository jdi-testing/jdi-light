package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.InputsTypes.TEXT;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.inputPage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.InputPage.inputWithAriaLabel;
import static io.github.com.pages.InputPage.inputAutoSize;
import static io.github.com.pages.InputPage.buttonClear;
import static io.github.com.pages.InputPage.massageHintCounter;
import static io.github.com.pages.InputPage.inputEmailErrorStateMatcher;
import static io.github.com.pages.InputPage.messageError;
import static io.github.com.pages.InputPage.messageErrorStateMatcher;
import static io.github.com.pages.InputPage.inputBasicFood;
import static io.github.com.pages.InputPage.messageHint;
import static io.github.com.pages.InputPage.inputErrorMail;
import static io.github.com.pages.InputPage.prefixForInput;
import static io.github.com.pages.InputPage.suffixForInput;
import static io.github.com.pages.InputPage.inputWithClearButton;
import static io.github.com.pages.InputPage.inputsForm;
import static io.github.com.pages.InputPage.inputBasicLeaveAComment;
import static io.github.com.pages.InputPage.inputWithMessageHint;
import static io.github.com.pages.InputPage.inputWithReadonly;
import static io.github.com.pages.InputPage.inputTelephone;

public class InputTests extends TestsInit {

    @BeforeMethod
    public void before() {
        inputPage.open();
        waitCondition(() -> inputPage.isOpened());
        inputPage.checkOpened();
    }

    @Test(description = "Test checks basic inputs attributes")
    public void inputBasicTest() {
        inputBasicFood.isDisplayed();
        inputBasicFood.show();
        inputBasicFood.isVisible();
        inputBasicFood.has().placeholder("Ex. Pizza")
                      .and().value("Sushi");
        inputBasicFood.input("Lasagna");
        inputBasicFood.has().value("Lasagna");
        inputBasicFood.input("Ice Cream");
        inputBasicFood.has().value("Ice");

        inputBasicLeaveAComment.has().placeholder("Ex. It makes me feel...");
        inputBasicLeaveAComment.input("Delicious");
        inputBasicLeaveAComment.has().value("Delicious");
    }

    @Test(description = "Test checks input with a clear button attributes")
    public void inputCleanableTest() {
        inputWithClearButton.isDisabled();
        inputWithClearButton.show();
        inputWithClearButton.isVisible();
        inputWithClearButton.has().inputType(TEXT);
        inputWithClearButton.input("test");
        inputWithClearButton.has().value("test");

        buttonClear.isDisplayed();
        buttonClear.click();
        inputWithClearButton.is().value("");
    }

    @Test(description = "Test checks input with readonly attributes")
    public void inputReadonlyTest() {
        inputWithReadonly.isDisplayed();
        inputWithReadonly.show();
        inputWithReadonly.isVisible();
        inputWithReadonly.has().inputType(TEXT)
                         .and().readonly();
    }

    @Test(description = "Test checks input with aria-label attributes")
    public void inputWithAriaLabelTest() {
        inputWithAriaLabel.isDisplayed();
        inputWithAriaLabel.show();
        inputWithAriaLabel.isVisible();
        inputWithAriaLabel.has().inputType(TEXT);
        inputWithAriaLabel.has().label("Clear");
    }

    @Test(description = "Test checks inputs with a custom ErrorStateMatcher attributes")
    public void inputWithCustomErrorStateMatcherTest() {
        inputEmailErrorStateMatcher.isDisplayed();
        inputEmailErrorStateMatcher.show();
        inputEmailErrorStateMatcher.isVisible();
        inputEmailErrorStateMatcher.has().placeholder("Ex. pat@example.com");
        inputEmailErrorStateMatcher.input("test");

        messageErrorStateMatcher.isDisplayed();
        messageErrorStateMatcher.is().text("Please enter a valid email address");
    }

    @Test(description = "Test checks input with error messages attributes")
    public void inputWithErrorMessagesTest() {
        inputErrorMail.isDisplayed();
        inputErrorMail.show();
        inputErrorMail.isVisible();
        inputErrorMail.has().placeholder("Ex. pat@example.com");
        inputErrorMail.input("test");
        inputErrorMail.pressButton(Keys.ENTER);

        messageError.isDisplayed();
        messageError.is().text("Please enter a valid email address");
    }

    @Test(description = "Test checks inputs with hints attributes")
    public void inputWithHintsTest() {
        inputWithMessageHint.isDisplayed();
        inputWithMessageHint.show();
        inputWithMessageHint.isVisible();
        inputWithMessageHint.has().placeholder("Ex. I need help with...");
        inputWithMessageHint.input("test");

        messageHint.isDisplayed();
        messageHint.is().text("Don't disclose personal info");

        massageHintCounter.isDisplayed();
        massageHintCounter.is().text("4 / 256");
    }

    @Test(description = "Test checks inputs with prefixes and suffixes attributes")
    public void inputWithPrefixesAndSuffixesTest() {
        prefixForInput.isDisplayed();
        prefixForInput.has().text("+1  ");
        suffixForInput.isDisplayed();

        inputTelephone.isDisplayed();
        inputTelephone.has().placeholder("555-555-1234");
        inputTelephone.input("0123456789");
        inputTelephone.is().value("0123456789");
        inputTelephone.clear();
        inputTelephone.is().value("");
    }

    @Test(description = "Test checks input with auto-resizing textarea attributes")
    public void inputWithTextAutoResizingTest() {
        inputAutoSize.isDisplayed();
        inputAutoSize.show();
        inputAutoSize.isVisible();
        inputAutoSize.has().autoSize();
        inputAutoSize.input("line1");
        inputAutoSize.pressButton(Keys.ENTER)
                     .sendKeys("line2");
        inputAutoSize.is().value("line1\nline2");
        inputAutoSize.clear();
        inputAutoSize.is().value("");
    }

    @Test(description = "Test checks inputs in a form attributes")
    public void inputsInAFormTest() {
        inputsForm.isDisplayed();
        inputsForm.show();
        inputsForm.isVisible();
        inputsForm.postalCode.is().value("94043");

        inputsForm.fill(DEFAULT_USER);
        inputsForm.firstName.is().value(DEFAULT_USER.firstName);
        inputsForm.lastName.is().value(DEFAULT_USER.lastName);
        inputsForm.address.is().value(DEFAULT_USER.address)
                          .and().placeholder("Ex. 100 Main St");
        inputsForm.address2.is().value(DEFAULT_USER.address2);
        inputsForm.city.is().value(DEFAULT_USER.city)
                       .and().placeholder("Ex. San Francisco");
        inputsForm.state.is().value(DEFAULT_USER.state)
                        .and().placeholder("Ex. California");
        inputsForm.postalCode.is().value(DEFAULT_USER.postalCode)
                             .and().placeholder("Ex. 94105");
    }
}
