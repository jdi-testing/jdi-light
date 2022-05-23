package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.jdiai.tools.Timer;
import io.github.com.custom.textfields.PasswordInputTextField;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.TextFieldsTestsDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.LinqUtils.safeException;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.textFieldsPage;

import static io.github.com.pages.TextFieldsPage.filledTextField;
import static io.github.com.pages.TextFieldsPage.counterTextField;
import static io.github.com.pages.TextFieldsPage.clearableTextField;
import static io.github.com.pages.TextFieldsPage.disabledTextField;
import static io.github.com.pages.TextFieldsPage.readonlyTextField;
import static io.github.com.pages.TextFieldsPage.hideDetailsTextField;
import static io.github.com.pages.TextFieldsPage.hintTextField;
import static io.github.com.pages.TextFieldsPage.validationTextField;
import static io.github.com.pages.TextFieldsPage.visibleHintTextField;
import static io.github.com.pages.TextFieldsPage.iconEventsTextField;
import static io.github.com.pages.TextFieldsPage.iconSlotsTextField;
import static io.github.com.pages.TextFieldsPage.tooltip;
import static io.github.com.pages.TextFieldsPage.progressTextField;
import static io.github.com.pages.TextFieldsPage.customValidationTextField;
import static io.github.com.pages.TextFieldsPage.labelTextField;
import static io.github.com.pages.TextFieldsPage.passwordInputTextField;
import static io.github.com.pages.TextFieldsPage.fullWidthWithCounterTextField;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

public class TextFieldsTests extends TestsInit {

    @BeforeClass
    public void before() {
        textFieldsPage.open();
        waitCondition(() -> textFieldsPage.isOpened());
        textFieldsPage.checkOpened();
    }

    @Test(dataProvider = "counterTextFieldTestDataProvider", dataProviderClass = TextFieldsTestsDataProvider.class)
    public void counterTextFieldTest(int index, String text, int textLength, int maxLength) {
        counterTextField.get(index).setText(text);
        counterTextField.get(index).is().counter(textLength, maxLength);
    }

    @Test
    public void clearableTextFieldTest() {
        clearableTextField.forEach(clearableTextField -> {
            clearableTextField.setText("my text");
            clearableTextField.clear();
            clearableTextField.has().text(Matchers.emptyString());
        });
    }

    @Test
    public void disabledTextFieldTest() {
        String inputText = "myText";
        String focusedClass = "v-input--is-focused";
        String disabledClass = "v-input--is-disabled";

        disabledTextField.forEach(textField -> {
            textField.has().classValue(containsString(disabledClass));
            textField.has().classValue(not(containsString(focusedClass)));

            try {
                textField.textInputField().input(inputText);
            } catch (Throwable error) {
                assertThat(safeException(error), containsString("invalid element state"));
            }

            assertThrows(
                    Exception.class,
                    () -> textField.textInputField().input(inputText)
            );

        });
    }

    @Test
    public void readonlyTextFieldTest() {
        String inputText = "My Input Text";
        String readOnlyClass = "v-input--is-readonly";
        String focusedClass = "v-input--is-focused";

        readonlyTextField.forEach(textField -> {
            textField.has().classValue(containsString(readOnlyClass));
            textField.focus();
            textField.has().classValue(containsString(focusedClass));

            try {
                textField.textInputField().input(inputText);
            } catch (Throwable error) {
                assertThat(safeException(error), containsString("invalid element state"));
            }
        });
    }

    @Test
    public void filledTextFieldTest() {
        String filledClass = "v-text-field--filled";

        filledTextField.get(1).has().classValue(containsString(filledClass));
        filledTextField.get(2).has().classValue(containsString(filledClass));
    }

    public void hideDetailsTextFieldTest() {
        TextField firstHideDetailsTextField = hideDetailsTextField.get(1);
        TextField secondHideDetailsTextField = hideDetailsTextField.get(2);

        firstHideDetailsTextField.is().noMessage();
        firstHideDetailsTextField.focus();
        secondHideDetailsTextField.focus();
        firstHideDetailsTextField.message().has().text("Required.");
        firstHideDetailsTextField.setText("a");
        firstHideDetailsTextField.message().has().text("Min 3 characters");
        firstHideDetailsTextField.setText("aaa");
        firstHideDetailsTextField.is().noMessage();
        secondHideDetailsTextField.focus();
        secondHideDetailsTextField.is().noMessage();
        secondHideDetailsTextField.setText("a");
        secondHideDetailsTextField.is().noMessage();
    }

    @Test
    public void hintTextFieldTest() {
        String hintText = "www.example.com/page";
        TextField firstHintTextField = hintTextField.get(1);
        TextField secondHintTextField = hintTextField.get(2);
        TextField firstVisibleHintTextField = visibleHintTextField.get(1);
        TextField secondVisibleHintTextField = visibleHintTextField.get(2);

        firstHintTextField.is().noMessage();
        firstHintTextField.focus();
        firstHintTextField.is().message();

        secondHintTextField.is().noMessage();
        secondHintTextField.focus();
        secondHintTextField.is().message();

        firstVisibleHintTextField.message().has().text(hintText);
        firstVisibleHintTextField.focus();
        firstVisibleHintTextField.message().has().text(hintText);

        secondVisibleHintTextField.message().has().text(hintText);
        secondVisibleHintTextField.focus();
        secondVisibleHintTextField.message().has().text(hintText);
    }

    @Test
    public void validationTextFieldTest() {
        String maxLengthString = "abcdeabcdeabcdeabcde";
        
        TextField firstValidationTextField = validationTextField.get(1);
        TextField secondValidationTextField = validationTextField.get(2);

        firstValidationTextField.clear();
        firstValidationTextField.message().has().text("Required.");
        firstValidationTextField.setText(maxLengthString);
        firstValidationTextField.is().text(maxLengthString);
        firstValidationTextField.is().counter(maxLengthString.length(), 20);
        firstValidationTextField.setText(maxLengthString + "abcd");
        firstValidationTextField.is().text(maxLengthString);
        firstValidationTextField.is().counter(maxLengthString.length(), 20);

        secondValidationTextField.setText("email");
        secondValidationTextField.message().has().text("Invalid e-mail.");
        secondValidationTextField.clear();
        secondValidationTextField.message().has().text("Required.");
        secondValidationTextField.setText("email@gmail.com");
        secondValidationTextField.is().noMessage();
    }

    @Test
    public void iconEventsTextFieldTest() {
        iconEventsTextField.sendKeys("text");
        iconEventsTextField.clearIcon().click();
        iconEventsTextField.is().text("");

        iconEventsTextField.sendKeys("text");
        iconEventsTextField.appendOuterIcon().click();
        iconEventsTextField.is().text("");

        iconEventsTextField.prependOuterIcon().click();
        iconEventsTextField.prependOuterIcon().has().classValue(containsString("mdi-emoticon-cool"));

        iconEventsTextField.appendInnerIcon().click();
        iconEventsTextField.appendInnerIcon().has().classValue(containsString("mdi-map-marker-off"));
    }

    @Test
    public void iconSlotsTextFieldTest() {
        iconSlotsTextField.setText("text");
        iconSlotsTextField.clearIcon().click();
        iconSlotsTextField.is().text("");

        iconSlotsTextField.selectMenuItemByText("Click me");
        iconSlotsTextField.is().text("Wait for it...");
        Timer.sleep(3000);
        iconSlotsTextField.is().text("You've clicked me!");

        tooltip.is().notVisible();
        iconSlotsTextField.prependOuterIcon().hover();
        tooltip.has().text("I'm a tooltip");
        tooltip.is().visible();

    }

    @Test
    public void labelTextFieldTest() {
        labelTextField.label().has().text("What about icon here?");
        labelTextField.icon().isDisplayed();
    }

    @Test
    public void progressTextFieldTest() {
        for (int i = 1; i < 20; i++) {
            progressTextField.sendKeys("a");
            int currentProgress = i * 10;
            if (progressTextField.getValueMax() < currentProgress) {
                currentProgress = progressTextField.getValueMax();
            }
            assertTrue(progressTextField.hasCurrentProgress(currentProgress));

        }
    }

    @Test
    public void customValidationTextFieldTest() {
        TextField firstCustomValidationTextField = customValidationTextField.get(1);
        TextField secondCustomValidationTextField = customValidationTextField.get(2);
        TextField thirdCustomValidationTextField = customValidationTextField.get(3);

        firstCustomValidationTextField.focus();
        secondCustomValidationTextField.focus();
        firstCustomValidationTextField.message().has().text("This field is required");

        secondCustomValidationTextField.sendKeys("My Keys");
        firstCustomValidationTextField.message().has().text("Hey! I'm required");

        secondCustomValidationTextField.clear();
        secondCustomValidationTextField.message().has().text("This field is required");

        secondCustomValidationTextField.sendKeys("123456789012345678901234567890");
        secondCustomValidationTextField.message().has().text("Address must be less than 25 characters");

        thirdCustomValidationTextField.sendKeys("My Keys");
        thirdCustomValidationTextField.clear();
        thirdCustomValidationTextField.message().has().text("This field is required");
    }

    @Test
    public void fullWidthWithCounterTextFieldTest() {
        String fullWidthClass = "v-text-field--full-width";
        String singleLineClass = "v-text-field--single-line";
        TextField secondDullWidthWithCounterTextField = fullWidthWithCounterTextField.get(2);

        secondDullWidthWithCounterTextField.has().classValue(containsString(fullWidthClass));
        secondDullWidthWithCounterTextField.has().classValue(containsString(singleLineClass));
    }

    @Test
    public void passwordInputTextFieldTest() {
        PasswordInputTextField firstPasswordInputTextField = passwordInputTextField.get(1);

        firstPasswordInputTextField.is().textType("password");
        firstPasswordInputTextField.showPassword();
        firstPasswordInputTextField.is().textType("text");
        firstPasswordInputTextField.hidePassword();
        firstPasswordInputTextField.is().textType("password");
    }
}
