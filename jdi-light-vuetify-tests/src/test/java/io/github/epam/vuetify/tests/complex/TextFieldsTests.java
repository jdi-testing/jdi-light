package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.textFieldsPage;
import static io.github.com.pages.TextFieldsPage.*;

import com.epam.jdi.light.vuetify.elements.complex.TextField;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.TextFieldsTestsDataProvider;
import java.util.stream.Stream;
import org.hamcrest.Matchers;
import org.openqa.selenium.Keys;
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
        counterTextField.get(index).is().text(text);
        counterTextField.get(index).is().counter(textLength, maxLength);
    }

    @Test
    public void clearableTextFieldTest() {
        clearableTextField.forEach(textField -> {
            textField.getAppendInnerIcon().click();
            textField.has().text(Matchers.emptyString());
        });
    }

    @Test(dataProvider = "customColorsTextFieldTestDataProvider", dataProviderClass = TextFieldsTestsDataProvider.class)
    public void customColorsTextFieldTest(int index, String color) {
        customColorsTextField.get(index).focus();
        customColorsTextField.get(index).is().color(color);
    }

    @Test
    public void denseTextFieldTest() {
        Stream.of(new Object[][]{
                {1, "rgba(0, 0, 0, 0)", 2, "filled"},
                {2, "rgba(0, 0, 0, 0.06)", 3, "filled"},
                {3, "rgba(0, 0, 0, 0.06)", 3, "placeholder"}
        }).forEach(data -> {
            denseTextField.get((int) data[0]).slot().is().css("background-color", (String) data[1]);
            denseTextField.get((int) data[2]).is().classValue(Matchers.containsString((String) data[3]));
        });

        Stream.of(new Object[][]{
                {4, "solo"},
                {5, "outlined"},
                {6, "outlined"},
                {6, "placeholder"}
        }).forEach(data -> denseTextField.get((int) data[0])
                .is().classValue(Matchers.containsString((String) data[1])));

        denseTextField.get(3).focus();
        denseTextField.get(3).has().placeholder("Dense & Rounded");
        denseTextField.get(6).focus();
        denseTextField.get(6).has().placeholder("Placeholder");

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
        filledTextField.get(1).is().filled();
        filledTextField.get(2).is().filled();
    }

    @Test
    public void hideDetailsTextFieldTest() {
        hideDetailsTextField.get(1).is().noHint();
        hideDetailsTextField.get(1).focus();
        hideDetailsTextField.get(2).focus();
        hideDetailsTextField.get(1).hint().has().text("Required.");
        hideDetailsTextField.get(1).setText("a");
        hideDetailsTextField.get(1).hint().has().text("Min 3 characters");
        hideDetailsTextField.get(1).setText("aaa");
        hideDetailsTextField.get(1).is().noHint();
        hideDetailsTextField.get(2).focus();
        hideDetailsTextField.get(2).is().noHint();
        hideDetailsTextField.get(2).setText("a");
        hideDetailsTextField.get(2).is().noHint();
    }

    @Test
    public void hintTextFieldTest() {
        hintTextField.forEach(textField -> {
            textField.is().noHint();
            textField.focus();
            textField.is().hint();
        });

        visibleHintTextField.forEach(textField -> {
            textField.hint().has().text("www.example.com/page");
            textField.focus();
            textField.hint().has().text("www.example.com/page");
        });
    }

    @Test
    public void iconsTextFieldTest() {
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
        outlinedTextField.get(1).is().outlined();
        outlinedTextField.get(2).is().outlined();
    }

    @Test
    public void prefixesAndSuffixesTextFieldTest() {
        prefixesAndSuffixesTextField.get(1).prefix().has().text("$");
        prefixesAndSuffixesTextField.get(2).suffix().has().text("lbs");
        prefixesAndSuffixesTextField.get(3).suffix().has().text("@gmail.com");
        prefixesAndSuffixesTextField.get(4).suffix().has().text("PST");
    }

    @Test
    public void shapedTextFieldTest() {
        shapedTextField.get(1).is().shaped();
        shapedTextField.get(2).is().shaped();
        shapedTextField.get(1).is().css("border-radius", "16px 16px 0px 0px");
        shapedTextField.get(2).is().css("border-radius", "16px 16px 0px 0px");
    }

    @Test
    public void singleLineTextFieldTest() {
        singleLineTextField.forEach(textField -> {
            textField.focus();
            jdiAssert(textField.label().isExist(), Matchers.is(false));
        });
    }

    @Test
    public void soloTextFieldTest() {
        soloTextField.get(1).is().solo();
        soloTextField.get(2).is().solo();
    }

    @Test
    public void validationTextFieldTest() {
        String maxLengthString = "abcdeabcdeabcdeabcde";
        validationTextField.get(1).setText(maxLengthString);
        validationTextField.get(1).is().text(maxLengthString);
        validationTextField.get(1).is().counter(maxLengthString.length(), 20);
        validationTextField.get(1).setText(maxLengthString + "abcd");
        validationTextField.get(1).is().text(maxLengthString);
        validationTextField.get(1).is().counter(maxLengthString.length(), 20);

        validationTextField.get(2).setText("email");
        validationTextField.get(2).hint().has().text("Invalid e-mail.");
        validationTextField.get(2).setText("email@gmail.com");
        validationTextField.get(2).is().noHint();
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
        customValidationTextField.forEach(TextField::focus);
        customValidationTextField.forEach(textField -> {
            textField.click();
            textField.has().hint();
            textField.has().hintMessage("This field is required");
            textField.setText("Default");
        });
        TextField countryField = customValidationTextField.get(6);
        countryField.textInputField().setText("Brasil");
        countryField.press(Keys.ARROW_DOWN);
        countryField.press(Keys.ENTER);

        customValidationTextField.forEach(textField -> textField.has().noHint());
    }

    @Test
    public void fullWidthWithCounterTextFieldTest() {
        fullWidthWithCounterTextField.forEach(textField -> textField.is().fullWidth());
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
