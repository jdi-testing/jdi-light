package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.sections.InputSection.*;
import static org.hamcrest.Matchers.containsString;

// TODO Move to the new page
@Ignore
public class InputTests extends TestsInit {

    @BeforeMethod
    public void before() {
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicInputTest() {
        foodBasicInput.isDisplayed();
        foodBasicInput.clear();
        foodBasicInput.setText("Lasagna");
        foodBasicInput.is().text("Lasagna");
        foodBasicInput.clear();
        foodBasicInput.sendKeys("Ice Cream");
        foodBasicInput.is().text(containsString("Ice"));

        leaveACommentBasicInput.isDisplayed();
        leaveACommentBasicInput.sendKeys("Delicious");
        leaveACommentBasicInput.is().text("Delicious");
    }

    @Test
    public void inputWithACustomErrorStateMatcherTest() {
        emailErrorStateMatcherInput.isDisplayed();
        emailErrorStateMatcherInput.sendKeys("test");
        errorStateMatcherMessageInput.is().text("Please enter a valid email address");
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

    @Test
    public void clearableInputTest() {
        clearableInput.isDisplayed();
        clearableInput.clear();
        clearableInput.sendKeys("test");
        clearableInputButton.isDisplayed();
        clearableInputButton.click();
        clearableInput.is().text("");
    }

    @Test
    public void inputWithErrorMessagesTest() {
        emailInput.isDisplayed();
        emailInput.sendKeys("test");
        emailInput.sendKeys(Keys.ENTER);
        errorMessageInput.isDisplayed();
        errorMessageInput.is().text("Please enter a valid email address");
    }

    @Test
    public void inputsInAFormTest() {
        inputsForm.fill(DEFAULT_USER);
        inputsForm.firstName.is().text(DEFAULT_USER.firstName);
        inputsForm.lastName.is().text(DEFAULT_USER.lastName);
        inputsForm.address.is().text(DEFAULT_USER.address);
        inputsForm.address2.is().text(DEFAULT_USER.address2);
        inputsForm.city.is().text(DEFAULT_USER.city);
        inputsForm.state.is().text(DEFAULT_USER.state);
        inputsForm.postalCode.is().text(DEFAULT_USER.postalCode);
    }

    @Test
    public void inputWithHintsTest() {
        messageHintInput.isDisplayed();
        messageHintInput.sendKeys("test");
        messageHint.isDisplayed();
        messageHint.is().text("Don't disclose personal info");
        messageCounterHint.isDisplayed();
        messageCounterHint.is().text("4 / 256");
    }

    @Test
    public void inputWithPrefixesAndSuffixesTest() {
        prefixInput.isDisplayed();
        suffixInput.isDisplayed();
        telephoneInput.isDisplayed();
        telephoneInput.sendKeys("0123456789");
        telephoneInput.clear();
        telephoneInput.is().text("");
    }
}
