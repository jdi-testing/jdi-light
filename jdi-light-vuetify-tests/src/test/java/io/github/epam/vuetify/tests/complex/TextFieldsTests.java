package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.LinqUtils.safeException;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.textFieldsPage;
import static io.github.com.pages.TextFieldsPage.clearableTextField;
import static io.github.com.pages.TextFieldsPage.counterTextField;
import static io.github.com.pages.TextFieldsPage.customValidationTextField;
import static io.github.com.pages.TextFieldsPage.disabledTextField;
import static io.github.com.pages.TextFieldsPage.filledTextField;
import static io.github.com.pages.TextFieldsPage.fullWidthWithCounterTextField;
import static io.github.com.pages.TextFieldsPage.hideDetailsTextField;
import static io.github.com.pages.TextFieldsPage.hintTextField;
import static io.github.com.pages.TextFieldsPage.iconEventsTextField;
import static io.github.com.pages.TextFieldsPage.iconSlotsTextField;
import static io.github.com.pages.TextFieldsPage.labelTextField;
import static io.github.com.pages.TextFieldsPage.passwordInputTextField;
import static io.github.com.pages.TextFieldsPage.progressTextField;
import static io.github.com.pages.TextFieldsPage.progressTextFieldProgressbar;
import static io.github.com.pages.TextFieldsPage.readonlyTextField;
import static io.github.com.pages.TextFieldsPage.validationTextField;
import static io.github.com.pages.TextFieldsPage.visibleHintTextField;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.TextFieldsTestsDataProvider;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        String FOCUSED_CLASS = "v-input--is-focused";
        String DISABLED_CLASS = "v-input--is-disabled";


        disabledTextField.forEach(textField -> {
            textField.has().classValue(containsString(DISABLED_CLASS));
            textField.has().classValue(not(containsString(FOCUSED_CLASS)));

            try {
                textField.textInputField().input(inputText);
            } catch (Throwable error) {
                assertThat(safeException(error), containsString("invalid element state"));
            }
        });
    }

    @Test
    public void readonlyTextFieldTest() {
        String inputText = "My Input Text";
        String READ_ONLY_CLASS = "v-input--is-readonly";
        String FOCUSED_CLASS = "v-input--is-focused";

        readonlyTextField.forEach(textField -> {
            textField.has().classValue(containsString(READ_ONLY_CLASS));
            textField.focus();
            textField.has().classValue(containsString(FOCUSED_CLASS));

            try {
                textField.textInputField().input(inputText);
            } catch (Throwable error) {
                assertThat(safeException(error), containsString("invalid element state"));
            }
        });
    }

    @Test
    public void filledTextFieldTest() {
        String FILLED_CLASS = "v-text-field--filled";

        filledTextField.get(1).has().classValue(containsString(FILLED_CLASS));
        filledTextField.get(2).has().classValue(containsString(FILLED_CLASS));
    }

    @Test
    public void hideDetailsTextFieldTest() {
        hideDetailsTextField.get(1).is().noMessage();
        hideDetailsTextField.get(1).focus();
        hideDetailsTextField.get(2).focus();
        hideDetailsTextField.get(1).message().has().text("Required.");
        hideDetailsTextField.get(1).setText("a");
        hideDetailsTextField.get(1).message().has().text("Min 3 characters");
        hideDetailsTextField.get(1).setText("aaa");
        hideDetailsTextField.get(1).is().noMessage();
        hideDetailsTextField.get(2).focus();
        hideDetailsTextField.get(2).is().noMessage();
        hideDetailsTextField.get(2).setText("a");
        hideDetailsTextField.get(2).is().noMessage();
    }

    @Test
    public void hintTextFieldTest() {
        String hintText = "www.example.com/page";

        hintTextField.get(1).is().noMessage();
        hintTextField.get(1).focus();
        hintTextField.get(1).is().message();

        hintTextField.get(2).is().noMessage();
        hintTextField.get(2).focus();
        hintTextField.get(2).is().message();

        visibleHintTextField.get(1).message().has().text(hintText);
        visibleHintTextField.get(1).focus();
        visibleHintTextField.get(1).message().has().text(hintText);

        visibleHintTextField.get(2).message().has().text(hintText);
        visibleHintTextField.get(2).focus();
        visibleHintTextField.get(2).message().has().text(hintText);
    }

    @Test
    public void validationTextFieldTest() throws InterruptedException {
        String maxLengthString = "abcdeabcdeabcdeabcde";
        validationTextField.get(1).clear();
        validationTextField.get(1).message().has().text("Required.");
        validationTextField.get(1).setText(maxLengthString);
        validationTextField.get(1).is().text(maxLengthString);
        validationTextField.get(1).is().counter(maxLengthString.length(), 20);
        validationTextField.get(1).setText(maxLengthString + "abcd");
        validationTextField.get(1).is().text(maxLengthString);
        validationTextField.get(1).is().counter(maxLengthString.length(), 20);

        validationTextField.get(2).setText("email");
        validationTextField.get(2).message().has().text("Invalid e-mail.");
        validationTextField.get(2).clear();
        validationTextField.get(2).message().has().text("Required.");
        validationTextField.get(2).setText("email@gmail.com");
        Thread.sleep(1000);
        validationTextField.get(2).is().noMessage();
    }

    @Test
    public void iconEventsTextFieldTest() {
        iconEventsTextField.setText("text");
        iconEventsTextField.getAppendInnerIcon().click();
        iconEventsTextField.is().text("");

        iconEventsTextField.setText("text");
        iconEventsTextField.getAppendOuterIcon().click();
        iconEventsTextField.is().text("");
    }

    @Test
    public void iconSlotsTextFieldTest() {
        iconSlotsTextField.setText("text");
        iconSlotsTextField.getAppendInnerIcon().click();
        iconSlotsTextField.is().text("");
    }

    @Test
    public void labelTextFieldTest() {
        labelTextField.label().has().text("What about icon here?");
        labelTextField.icon().isDisplayed();
    }

    @Test
    public void progressTextFieldTest() {
        for (int i = 1; i < 10; i++) {
            progressTextField.sendKeys("a");
            progressTextFieldProgressbar.is().attr("aria-valuenow", Integer.toString(i * 10));
        }
    }

    @Test
    public void customValidationTextFieldTest() {
        customValidationTextField.get(1).focus();
        customValidationTextField.get(2).focus();
        customValidationTextField.get(1).message().has().text("This field is required");

        customValidationTextField.get(2).sendKeys("My Keys");
        customValidationTextField.get(1).message().has().text("Hey! I'm required");

        customValidationTextField.get(2).clear();
        customValidationTextField.get(2).message().has().text("This field is required");

        customValidationTextField.get(2).sendKeys("123456789012345678901234567890");
        customValidationTextField.get(2).message().has().text("Address must be less than 25 characters");

        customValidationTextField.get(3).sendKeys("My Keys");
        customValidationTextField.get(3).clear();
        customValidationTextField.get(3).message().has().text("This field is required");
    }

    @Test
    public void fullWidthWithCounterTextFieldTest() {
        String FULL_WIDTH_CLASS = "v-text-field--full-width";
        fullWidthWithCounterTextField.get(1).has().classValue(containsString(FULL_WIDTH_CLASS));
    }

    @Test
    public void passwordInputTextFieldTest() {
        passwordInputTextField.get(1).is().textType("password");
        passwordInputTextField.get(1).getAppendInnerIcon().click();
        passwordInputTextField.get(1).is().textType("text");
        passwordInputTextField.get(1).getAppendInnerIcon().click();
        passwordInputTextField.get(1).is().textType("password");
    }
}
