package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.inputsPage;
import static io.github.com.enums.Colors.BLUE;
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
        hideDetailsMainInput.has().label("Main input");
        fewErrorsCountInput.show();
        fewErrorsCountInput.has().noLabel();
    }

    @Test(description = "Test checks type text feature")
    public void typeTextInputTest() {
        String textToType = "Some text";
        hideDetailsAnotherInput.show();
        hideDetailsAnotherInput.has().textInput();
        hideDetailsAnotherInput.text(textToType);
        hideDetailsAnotherInput.has().text(textToType);

        fewErrorsCountInput.show();
        fewErrorsCountInput.has().notTextInput();
    }

    @Test(description = "Test checks that input has text in slot")
    public void hintInputTest() {
        hintInput.show();
        hintInput.has().text("Input");
    }

    @Test(description = "Test checks that input switch changes input's messages : hint, persistent-hint")
    public void switchAndMessagesInputTest() {
        hintInput.show();
        hintInput.has().messagesCount(1)
                .and().messageText("I am hint");
        showMessagesInput.has().switchInput()
                .and().uncheckedSwitch();
        showMessagesInput.checkSwitch();
        showMessagesInput.has().checkedSwitch();
        hintInput.has().messagesCount(1)
                .and().messageText("Message");
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
        rulesInput.has().textInput();
        rulesInput.text(incorrectTextToType);
        rulesInput.has().text(incorrectTextToType);
        rulesInput.has().errorMessage("Invalid e-mail.")
                .and().has().messagesCount(1);
        rulesInput.text(correctTextToType);
        rulesInput.has().text(correctTextToType);
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

    @Test(description = "Test checks if input is readonly or not : readonly (y/n)")
    public void readOnlyInputTest() {
        readonlyInput.show();
        readonlyInput.is().readonly();
        fewErrorsCountInput.show();
        fewErrorsCountInput.is().notReadonly();
    }

    @Test(description = "Test checks input's color : color, background-color")
    public void colorInputTest() {
        readonlyInput.show();
        readonlyInput.has().color(WHITE.value())
                .and().backgroundColor(BLUE.value());
    }

    @Test(description = "Test checks input's height : height")
    public void heightInputTest() {
        loadingInput.show();
        loadingInput.has().heightGreaterThan(60)
                .and().heightLessThan(70)
                .and().height(69);
    }

    @Test(description = "Test checks if input's details are hidden or not :  hide-details (y/n)")
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
