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
import static io.github.com.pages.InputsPage.appendAndPrependInput;
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

    @Test
    public void mainHideDetailsInputAndErrorCountInputTest() {
        hideDetailsMainInput.has().hasLabel();
        hideDetailsMainInput.has().textField();
        fewErrorsCountInput.has().hasNoLabel();
        fewErrorsCountInput.has().textInSlot("Input");
        hideDetailsMainInput.typeText("12");
        hideDetailsMainInput.has().message("Min 3 characters");
        hideDetailsMainInput.clearTextField();
        hideDetailsMainInput.has().message("Required.");
        hideDetailsMainInput.clearAndTypeText("123");
    }

    @Test
    public void anotherInputTest() {
        String textToType = "Some text";
        hideDetailsAnotherInput.has().hasLabel();
        hideDetailsAnotherInput.hasTextField();
        hideDetailsAnotherInput.typeText(textToType);
        hideDetailsAnotherInput.has().typedText();
        hideDetailsAnotherInput.has().typedText(textToType);
    }

    @Test
    public void hintInputTest() {
        hintInput.has().hasNoLabel();
        hintInput.has().textInSlot();
        hintInput.has().textInSlot("Input");
        hintInput.has().message();
        hintInput.has().message("I am hint");
        showMessagesInput.has().switchInput();
        showMessagesInput.has().uncheckedSwitch();
        showMessagesInput.checkSwitch();
        showMessagesInput.has().checkedSwitch();
        hintInput.has().message();
        hintInput.has().message("Message");
        showMessagesInput.uncheckSwitch();
        showMessagesInput.has().uncheckedSwitch();
    }

    @Test
    public void loadingInputTest() {
        loadingInput.has().hasNoLabel();
        loadingInput.is().loading();
        toggleLoadingButton.click();
        loadingInput.is().loaded();
    }

    @Ignore
    @Test
    public void rulesInputTest() {
        String incorrectTextToType = "Some text";
        String correctTextToType = "test@gmail.com";
        rulesInput.has().hasNoLabel();
        rulesInput.has().textField();
        rulesInput.typeText(incorrectTextToType);
        rulesInput.has().typedText();
        rulesInput.has().typedText(incorrectTextToType);
        rulesInput.has().message("Invalid e-mail.");
        rulesInput.clearAndTypeText(correctTextToType);
        rulesInput.has().typedText();
        rulesInput.has().typedText(correctTextToType);
    }

    @Test
    public void slotClicksInput() {
        String prependMessage = "click:prepend";
        String appendMessage = "click:append";
        slotClicksInput.has().hasNoLabel();
        slotClicksInput.has().prependOuter();
        slotClicksInput.clickOnPrependOuter();
        assertThat(getDriver().switchTo().alert().getText(), Matchers.containsString(prependMessage));
        getDriver().switchTo().alert().accept();
        slotClicksInput.has().appendOuter();
        slotClicksInput.clickOnAppendOuter();
        assertThat(getDriver().switchTo().alert().getText(), Matchers.containsString(appendMessage));
        getDriver().switchTo().alert().accept();
    }

    @Test
    public void appendAndPrependInput() {
        String attribute = "v-input--is-focused";
        appendAndPrependInput.has().hasNoLabel();
        appendAndPrependInput.has().appendInner();
        appendAndPrependInput.clickOnAppendInner();
        appendAndPrependInput.has().className(attribute);
        appendAndPrependInput.has().prependOuter();
        appendAndPrependInput.clickOnPrependOuter();
        appendAndPrependInput.has().notClassName(attribute);
    }

    @Test
    public void readOnlyInputTest() {
        readonlyInput.show();
        readonlyInput.is().readonly();
    }

    @Test
    public void errorInputTest() {
        fewErrorsCountInput.show();
        fewErrorsCountInput.has().errorMessages()
                .and().messagesText(Arrays.asList("error1", "error2"))
                .and().has().messagesCount(2);
        fewErrorsCountInput.has().noSuccessMessages();
    }

    @Test
    public void successInputTest() {
        successInput.show();
        successInput.has().successMessages()
                .and().messagesText(Collections.singletonList("Success"))
                .and().messagesCount(1);
        successInput.has().noErrorMessages();
    }
}
