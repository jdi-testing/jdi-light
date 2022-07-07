package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.InputSection.*;
import static io.github.com.pages.sections.InputsForm.*;
import static io.github.epam.data.TestData.DEFAULT_USER;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;

public class InputTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicInputTest() {
        foodBasicInput.is().displayed();
        foodBasicInput.clear();
        foodBasicInput.setText("Lasagna");
        foodBasicInput.is().text("Lasagna");
        foodBasicInput.clear();
        foodBasicInput.sendKeys("Ice Cream");
        foodBasicInput.is().text(containsString("Ice"));

        leaveACommentBasicInput.is().displayed();
        leaveACommentBasicInput.sendKeys("Delicious");
        leaveACommentBasicInput.is().text("Delicious");
    }

    @Test
    public void inputWithACustomErrorStateMatcherTest() {
        emailErrorStateMatcherInput.is().displayed();
        emailErrorStateMatcherInput.sendKeys("test");
        errorStateMatcherMessageInput.is().text("Please enter a valid email address");
    }

    @Test
    public void autoResizingTextAreaTest() {
        autoSizeTextArea.is().displayed();
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
        clearableInput.is().displayed();
        clearableInput.clear();
        clearableInput.sendKeys("test");
        clearableInputButton.is().displayed();
        clearableInputButton.click();
        clearableInput.is().text("");
    }

    @Test
    public void inputWithErrorMessagesTest() {
        emailInput.is().displayed();
        emailInput.sendKeys("test");
        emailInput.sendKeys(Keys.ENTER);
        errorMessageInput.is().displayed();
        errorMessageInput.is().text("Please enter a valid email address");
    }

    @Test
    public void inputsInAFormTest() {
        inputsForm.fill(DEFAULT_USER);
        firstName.is().text(DEFAULT_USER.firstName);
        lastName.is().text(DEFAULT_USER.lastName);
        address.is().text(DEFAULT_USER.address);
        address2.is().text(DEFAULT_USER.address2);
        city.is().text(DEFAULT_USER.city);
        state.is().text(DEFAULT_USER.state);
        postalCode.is().text(DEFAULT_USER.postalCode);
    }

    @Test
    public void inputWithHintsTest() {
        messageHintInput.is().displayed();
        messageHintInput.sendKeys("test");
        messageHint.is().displayed();
        messageHint.is().text("Don't disclose personal info");
        messageCounterHint.is().displayed();
        messageCounterHint.is().text("4 / 256");
    }

    @Test
    public void inputWithPrefixesAndSuffixesTest() {
        prefixInput.is().displayed();
        suffixInput.is().displayed();
        telephoneInput.is().displayed();
        telephoneInput.sendKeys("0123456789");
        telephoneInput.clear();
        telephoneInput.is().text("");
    }
}
