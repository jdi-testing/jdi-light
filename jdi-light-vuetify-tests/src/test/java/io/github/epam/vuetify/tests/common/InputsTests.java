package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.inputsPage;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.TRANSPARENT;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.pages.InputsPage.appendAndPrependInput;
import static io.github.com.pages.InputsPage.disabledInput;
import static io.github.com.pages.InputsPage.fewErrorsCountInput;
import static io.github.com.pages.InputsPage.hideDetailsAnotherInput;
import static io.github.com.pages.InputsPage.hideDetailsMainInput;
import static io.github.com.pages.InputsPage.hintInput;
import static io.github.com.pages.InputsPage.loadingInput;
import static io.github.com.pages.InputsPage.readonlyInput;
import static io.github.com.pages.InputsPage.rulesInput;
import static io.github.com.pages.InputsPage.showMessagesInput;
import static io.github.com.pages.InputsPage.slotClicksInput;
import static io.github.com.pages.InputsPage.successInput;
import static io.github.com.pages.InputsPage.toggleLoadingButton;
import static org.hamcrest.MatcherAssert.assertThat;

public class InputsTests extends TestsInit {

    @BeforeClass
    public void before() {
        inputsPage.open();
        waitCondition(() -> inputsPage.isOpened());
        inputsPage.checkOpened();
    }

    @Test(description = "Test checks if element is enabled or disabled")
    public void disabledInputTest() {
        disabledInput.show();
        disabledInput.is().disabled();
        fewErrorsCountInput.show();
        fewErrorsCountInput.is().enabled();
    }

    @Test(description = "Test checks if input has label or not")
    public void labelInputTest() {
        hideDetailsMainInput.show();
        hideDetailsMainInput.has().label();
        fewErrorsCountInput.show();
        fewErrorsCountInput.has().noLabel();
    }

    @Test(description = "Test checks if input has text field or not")
    public void hasTextFieldInputTest() {
        hideDetailsMainInput.show();
        hideDetailsMainInput.has().textField();
        fewErrorsCountInput.show();
        fewErrorsCountInput.has().notTextField();
    }

    @Test(description = "Test checks type text feature")
    public void typeTextInputTest() {
        String textToType = "Some text";
        hideDetailsAnotherInput.show();
        hideDetailsAnotherInput.hasTextField();
        hideDetailsAnotherInput.typeText(textToType);
        hideDetailsAnotherInput.has().typedText();
        hideDetailsAnotherInput.has().typedText(textToType);
    }

    @Test(description = "Test checks that input has text in slot")
    public void hintInputTest() {
        hintInput.show();
        hintInput.has().textInSlot();
        hintInput.has().textInSlot("Input");
    }

    @Test(description = "Test checks that input switch changes input's messages : hint, persistent hint")
    public void switchAndMessagesInputTest() {
        hintInput.show();
        hintInput.has().messagesCount(1);
        hintInput.has().messageText("I am hint");
        showMessagesInput.has().switchInput();
        showMessagesInput.has().uncheckedSwitch();
        showMessagesInput.checkSwitch();
        showMessagesInput.has().checkedSwitch();
        hintInput.has().messagesCount(1);
        hintInput.has().messageText("Message");
        showMessagesInput.uncheckSwitch();
        showMessagesInput.has().uncheckedSwitch();
    }

    @Test(description = "Test checks if input is loading or not")
    public void loadingInputTest() {
        loadingInput.show();
        loadingInput.is().loading();
        toggleLoadingButton.click();
        loadingInput.is().loaded();
    }

    @Test(description = "Test checks input rules : rules")
    public void rulesInputTest() {
        String incorrectTextToType = "Some text";
        String correctTextToType = "test@gmail.com";
        rulesInput.has().textField();
        rulesInput.typeText(incorrectTextToType);
        rulesInput.has().typedText();
        rulesInput.has().typedText(incorrectTextToType);
        rulesInput.has().errorMessage("Invalid e-mail.");
        rulesInput.clearAndTypeText(correctTextToType);
        rulesInput.has().typedText();
        rulesInput.has().typedText(correctTextToType);
        rulesInput.has().noErrorMessages();
    }

    @Test(description = "Append-prepend icons input test")
    public void appendPrependIconsInputTest() {
        String prependMessage = "click:prepend";
        String appendMessage = "click:append";
        slotClicksInput.show();
        slotClicksInput.has().prependOuterIcon();
        slotClicksInput.clickOnPrependOuterIcon();
        assertThat(getDriver().switchTo().alert().getText(), Matchers.containsString(prependMessage));
        getDriver().switchTo().alert().accept();
        slotClicksInput.has().appendOuterIcon();
        slotClicksInput.clickOnAppendOuterIcon();
        assertThat(getDriver().switchTo().alert().getText(), Matchers.containsString(appendMessage));
        getDriver().switchTo().alert().accept();
    }

    @Test(description = "Test checks if input is focused or not")
    public void appendAndPrependInput() {
        appendAndPrependInput.show();
        appendAndPrependInput.has().appendInnerIcon();
        appendAndPrependInput.clickOnAppendInnerIcon();
        appendAndPrependInput.is().focused();
        appendAndPrependInput.has().prependOuterIcon();
        appendAndPrependInput.clickOnPrependOuterIcon();
        appendAndPrependInput.is().notFocused();
    }

    @Test(description = "Test checks if input is readonly or not : readonly")
    public void readOnlyInputTest() {
        readonlyInput.show();
        readonlyInput.is().readonly();
        fewErrorsCountInput.show();
        fewErrorsCountInput.is().notReadonly();
    }

    @Test(description = "Test checks if input has error messages or not : error count, multiple errors")
    public void errorInputTest() {
        fewErrorsCountInput.show();
        fewErrorsCountInput.has().errorMessages()
                .and().messagesText(Arrays.asList("error1", "error2"))
                .and().has().messagesCount(2);
        successInput.show();
        successInput.has().noErrorMessages();
    }

    @Test(description = "Test checks if input has success messages or not : success, success-messages")
    public void successInputTest() {
        successInput.show();
        successInput.has().successMessages()
                .and().messagesText(Collections.singletonList("Success"))
                .and().messagesCount(1);
        fewErrorsCountInput.show();
        fewErrorsCountInput.has().noSuccessMessages();
    }

    @Test(description = "Test checks input's color : color, background-color")
    public void colorInputTest() {
        readonlyInput.show();
        readonlyInput.has().color(WHITE.value());
        readonlyInput.has().backgroundColor(BLUE.value());
    }

    @Test(description = "Test checks input's measurements : height")
    public void heightInputTest() {
        loadingInput.show();
        loadingInput.has().heightGreaterThan(30);
        loadingInput.has().heightLessThan(40);
        loadingInput.has().height(35);
    }

    @Test(description = "Test checks if input's details are hidden or not")
    public void detailsHiddenInputTest() {
        hideDetailsMainInput.show();
        hideDetailsMainInput.has().detailsHidden();
        loadingInput.show();
        loadingInput.has().notDetailsHidden();
    }

    @Test(description = "Test checks input's theme : theme (dark/light)")
    public void themeInputTest() {
        hideDetailsMainInput.show();
        hideDetailsMainInput.has().lightTheme();
        readonlyInput.show();
        readonlyInput.has().darkTheme();
    }

    @Test(description = "Test checks if input is dense or not : dense (y/n)")
    public void denseInputTest() {
        successInput.show();
        successInput.is().dense();
        readonlyInput.show();
        readonlyInput.is().notDense();
    }
}
