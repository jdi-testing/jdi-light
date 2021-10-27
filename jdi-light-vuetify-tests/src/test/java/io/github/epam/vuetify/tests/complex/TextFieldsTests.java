package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TextField;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.TextFieldsTestsDataProvider;
import org.hamcrest.Matchers;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.textFieldsPage;
import static io.github.com.pages.TextFieldsPage.clearableTextField;
import static io.github.com.pages.TextFieldsPage.counterTextField;
import static io.github.com.pages.TextFieldsPage.customColorsTextField;
import static io.github.com.pages.TextFieldsPage.customValidationTextField;
import static io.github.com.pages.TextFieldsPage.denseTextField;
import static io.github.com.pages.TextFieldsPage.disabledTextField;
import static io.github.com.pages.TextFieldsPage.filledTextField;
import static io.github.com.pages.TextFieldsPage.fullWidthWithCounterTextField;
import static io.github.com.pages.TextFieldsPage.hideDetailsTextField;
import static io.github.com.pages.TextFieldsPage.hintTextField;
import static io.github.com.pages.TextFieldsPage.iconEventsTextField;
import static io.github.com.pages.TextFieldsPage.iconSlotsTextField;
import static io.github.com.pages.TextFieldsPage.iconsTextField;
import static io.github.com.pages.TextFieldsPage.labelTextField;
import static io.github.com.pages.TextFieldsPage.outlinedTextField;
import static io.github.com.pages.TextFieldsPage.passwordInputTextField;
import static io.github.com.pages.TextFieldsPage.prefixesAndSuffixesTextField;
import static io.github.com.pages.TextFieldsPage.progressTextField;
import static io.github.com.pages.TextFieldsPage.progressTextFieldProgressbar;
import static io.github.com.pages.TextFieldsPage.readonlyTextField;
import static io.github.com.pages.TextFieldsPage.shapedTextField;
import static io.github.com.pages.TextFieldsPage.singleLineTextField;
import static io.github.com.pages.TextFieldsPage.soloTextField;
import static io.github.com.pages.TextFieldsPage.validationTextField;
import static io.github.com.pages.TextFieldsPage.visibleHintTextField;

public class TextFieldsTests extends TestsInit {

    @BeforeClass
    public void before() {
        textFieldsPage.open();
        textFieldsPage.checkOpened();
    }

    @Test(dataProvider = "counterTextFieldTestDataProvider", dataProviderClass = TextFieldsTestsDataProvider.class)
    public void counterTextFieldTest(int index, String text, int textLength, int maxLength) {
        counterTextField.get(index).is().text(text);
        counterTextField.get(index).is().counter(textLength, maxLength);
    }

    @Test
    public void clearableTextFieldTest() {
        clearableTextField.forEach(textField -> {
            textField.getAppendInnerIcon().click();
            textField.is().empty();
        });
    }

    @Test(dataProvider = "customColorsTextFieldTestDataProvider", dataProviderClass = TextFieldsTestsDataProvider.class)
    public void customColorsTextFieldTest(int index, String color) {
        customColorsTextField.get(index).focus();
        customColorsTextField.get(index).is().color(color);
    }

    @Test
    public void denseTextFieldTest() {
        denseTextField.get(1).getSlot().is().css("background-color", "rgba(0, 0, 0, 0)");
        denseTextField.get(2).is().peculiarity("filled");
        denseTextField.get(2).getSlot().is().css("background-color", "rgba(0, 0, 0, 0.06)");
        denseTextField.get(3).is().peculiarity("filled");
        denseTextField.get(3).getSlot().is().css("background-color", "rgba(0, 0, 0, 0.06)");
        denseTextField.get(3).is().peculiarity("placeholder");
        denseTextField.get(3).focus();
        denseTextField.get(3).is().placeholder("Dense & Rounded");
        denseTextField.get(4).is().peculiarity("solo");
        denseTextField.get(5).is().peculiarity("outlined");
        denseTextField.get(6).is().peculiarity("outlined");
        denseTextField.get(6).is().peculiarity("placeholder");
        denseTextField.get(6).focus();
        denseTextField.get(6).is().placeholder("Placeholder");
        denseTextField.forEach(textField -> {
            textField.setText("text");
            textField.is().text("text");
        });
    }

    @Test
    public void disabledTextFieldTest() {
        disabledTextField.forEach(textField -> {
            textField.is().disabled();
            jdiAssert(textField.textInputField().isClickable(), Matchers.is(false));
            textField.is().notFocused();
        });
    }

    @Test
    public void readonlyTextFieldTest() {
        readonlyTextField.forEach(textField -> {
            textField.is().readonly();
            textField.focus();
            textField.is().focused();
        });
    }

    @Test
    public void filledTextFieldTest() {
        filledTextField.get(1).is().peculiarity("filled");
        filledTextField.get(2).is().peculiarity("filled");
    }

    @Test
    public void hideDetailsTextFieldTest() {
        hideDetailsTextField.get(1).is().noMessage();
        hideDetailsTextField.get(1).focus();
        hideDetailsTextField.get(2).focus();
        hideDetailsTextField.get(1).is().message("Required.");
        hideDetailsTextField.get(1).setText("a");
        hideDetailsTextField.get(1).is().message("Min 3 characters");
        hideDetailsTextField.get(1).clearAndSetText("aaa");
        hideDetailsTextField.get(1).is().noMessage();

        hideDetailsTextField.get(2).is().noMessage();
        hideDetailsTextField.get(1).setText("a");
        hideDetailsTextField.get(1).is().noMessage();
    }

    @Test
    public void hintTextFieldTest() {
        hintTextField.forEach(textField -> {
            textField.is().noMessage();
            textField.focus();
            textField.is().message();
        });

        visibleHintTextField.forEach(textField -> {
            textField.is().message("www.example.com/page");
            textField.focus();
            textField.is().message("www.example.com/page");
        });
    }

    @Test
    public void iconsTextFieldTest() throws Exception {
        String mdiMapMarker = "mdi-map-marker";
        for (int index = 0; index <= 12; index += 4) {
            iconsTextField.get(1 + index).getPrependOuterIcon().is().type(mdiMapMarker);
            iconsTextField.get(2 + index).getPrependInnerIcon().is().type(mdiMapMarker);
            iconsTextField.get(3 + index).getAppendInnerIcon().is().type(mdiMapMarker);
            iconsTextField.get(4 + index).getAppendOuterIcon().is().type(mdiMapMarker);
        }
    }

    @Test
    public void outlinedTextFieldTest() {
        outlinedTextField.get(1).is().peculiarity("outlined");
        outlinedTextField.get(2).is().peculiarity("outlined");
    }

    @Test
    public void prefixesAndSuffixesTextFieldTest() {
        prefixesAndSuffixesTextField.get(1).is().prefix("$");
        prefixesAndSuffixesTextField.get(2).is().suffix("lbs");
        prefixesAndSuffixesTextField.get(3).is().suffix("@gmail.com");
        prefixesAndSuffixesTextField.get(4).is().suffix("PST");
    }

    @Test
    public void shapedTextFieldTest() {
        shapedTextField.get(1).is().peculiarity("shaped");
        shapedTextField.get(2).is().peculiarity("shaped");
        shapedTextField.get(1).is().css("border-radius", "16px 16px 0px 0px");
        shapedTextField.get(2).is().css("border-radius", "16px 16px 0px 0px");
    }

    @Test
    public void singleLineTextFieldTest() {
        singleLineTextField.forEach(textField -> {
            textField.focus();
            textField.is().label("");
        });
    }

    @Test
    public void soloTextFieldTest() {
        soloTextField.get(1).is().peculiarity("solo");
        soloTextField.get(2).is().peculiarity("solo");
    }

    @Test
    public void validationTextFieldTest() {
        String maxLengthString = "abcdeabcdeabcdeabcde";
        validationTextField.get(1).clearAndSetText(maxLengthString);
        validationTextField.get(1).is().text(maxLengthString);
        validationTextField.get(1).is().counter(maxLengthString.length(), 20);
        validationTextField.get(1).clearAndSetText(maxLengthString + "abcd");
        validationTextField.get(1).is().text(maxLengthString);
        validationTextField.get(1).is().counter(maxLengthString.length(), 20);

        validationTextField.get(2).clearAndSetText("email");
        validationTextField.get(2).is().message("Invalid e-mail.");
        validationTextField.get(2).clearAndSetText("email@gmail.com");
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
        labelTextField.is().label("What about icon here?");
    }

    @Test
    public void progressTextFieldTest() {
        for (int i = 1; i < 10; i++) {
            progressTextField.setText("a");
            progressTextFieldProgressbar.is().attr("aria-valuenow", Integer.toString(i * 10));
        }
    }

    @Test
    public void customValidationTextFieldTest() {
        customValidationTextField.forEach(TextField::focus);
        customValidationTextField.forEach(textField -> {
            textField.core().click();
            textField.is().message();
            textField.setText("Russia");
        });
        customValidationTextField.get(6).textInputField().sendKeys(Keys.ENTER);
        customValidationTextField.get(1).is().noMessage();
        customValidationTextField.get(2).is().noMessage();
        customValidationTextField.get(3).is().noMessage();
        customValidationTextField.get(4).is().noMessage();
        customValidationTextField.get(5).is().noMessage();
        customValidationTextField.get(6).is().noMessage();
        customValidationTextField.forEach(textField -> textField.is().noMessage());
    }

    @Test
    public void fullWidthWithCounterTextFieldTest() {
        fullWidthWithCounterTextField.forEach(textField -> textField.is().peculiarity("full-width"));
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
