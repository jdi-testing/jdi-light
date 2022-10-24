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
import static io.github.com.pages.InputsPage.*;
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
        fewErrorsCountInput.has().textInSlot("0");
        hideDetailsMainInput.typeText("12");
        hideDetailsMainInput.has().message("Min 3 characters");
        fewErrorsCountInput.has().textInSlot("1");
        fewErrorsCountInput.has().message();
        fewErrorsCountInput.has().message("hide details error");
        hideDetailsMainInput.clearTextField();
        hideDetailsMainInput.has().message("Required.");
        hideDetailsMainInput.clearAndTypeText("123");
        fewErrorsCountInput.has().textInSlot("0");
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
        fewErrorsCountInput.has().errorMessages();
        fewErrorsCountInput.has().errorMessagesText(Arrays.asList("error1", "error2"));
        fewErrorsCountInput.has().errorMessagesCount(2);
    }

    @Test
    public void successInputTest() {
        successInput.show();
        successInput.has().successMessages();
        successInput.has().successMessagesText(Collections.singletonList("Success"));
        successInput.has().successMessagesCount(1);
    }
}
