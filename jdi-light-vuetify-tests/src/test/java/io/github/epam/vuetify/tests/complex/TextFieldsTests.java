package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
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
import static io.github.com.pages.TextFieldsPage.readonlyTextField;
import static io.github.com.pages.TextFieldsPage.shapedTextField;
import static io.github.com.pages.TextFieldsPage.singleLineTextField;
import static io.github.com.pages.TextFieldsPage.soloTextField;
import static io.github.com.pages.TextFieldsPage.validationTextField;
import static io.github.com.pages.TextFieldsPage.visibleHintTextField;
import static io.github.com.pages.TextFieldsPage.tooltip;
import static org.hamcrest.Matchers.containsString;

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

    @Test()
    public void counterTextFieldTest() {
        String defText = "Preliminary report";
        TextField regularCounterField = counterTextField.get(1);
        regularCounterField.has().hasLabel("Regular");
        regularCounterField.setText(defText);
        regularCounterField.has().counter(18, 25);
        regularCounterField.click();
        regularCounterField.has().hintMessage("This field uses counter prop");

        TextField customCountPropField = counterTextField.get(3);
        customCountPropField.has().hasLabel("Custom counter from prop");
        customCountPropField.has().text(defText);
        customCountPropField.has().counter(2, 5);
        customCountPropField.click();
        customCountPropField.has().hintMessage("This field counts words instead of characters");


        TextField customCountSlotField = counterTextField.get(4);
        customCountSlotField.label().is().text("Custom counter from slot");
        customCountSlotField.has().text(defText);
        customCountSlotField.has().counter(2, 5);
        customCountSlotField.click();
        customCountSlotField.has().hintMessage("This field counts words instead of characters");

        TextField limitExcField = counterTextField.get(2);
        limitExcField.is().hasLabel("Limit exceeded");
        limitExcField.has().counter(50, 25);
        limitExcField.click();
        limitExcField.has().hintMessage("This field uses maxlength attribute");
        customCountSlotField.click();
        limitExcField.has().hasErrorText("Max 25 characters");

        regularCounterField.clear();
        regularCounterField.is().text("");
        customCountPropField.is().text("");
        customCountSlotField.is().text("");
        regularCounterField.has().counter(0, 25);
        customCountSlotField.has().counter(1, 5);

    }

    @Test
    public void clearableTextFieldTest() {
        clearableTextField.forEach(textField -> {
            textField.has().text("Hey!");
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
            denseTextField.get((int) data[2]).is().classValue(containsString((String) data[3]));
        });

        Stream.of(new Object[][]{
                {4, "solo"},
                {5, "outlined"},
                {6, "outlined"},
                {6, "placeholder"}
        }).forEach(data -> denseTextField.get((int) data[0])
                .is().classValue(containsString((String) data[1])));

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
        hideDetailsTextField.get(1).is().hasErrorText("Required.");
        hideDetailsTextField.get(1).setText("a");
        hideDetailsTextField.get(1).hint().has().text("Min 3 characters");
        hideDetailsTextField.get(1).is().hasErrorText("Min 3 characters");
        hideDetailsTextField.get(1).setText("aaa");
        hideDetailsTextField.get(1).is().noHint();
        hideDetailsTextField.get(1).is().hasNoError();
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
        iconSlotsTextField.getAppendInnerIcon().click();
        iconSlotsTextField.is().text("");

        iconSlotsTextField.selectMenuItemByText("Click me");
        iconSlotsTextField.is().text("You've clicked me!");

        iconSlotsTextField.prependOuterIcon().hover();
        tooltip.has().text("I'm a tooltip");
        tooltip.is().visible();
    }

    @Test
    public void labelTextFieldTest() {
        labelTextField.has().hasLabel();
        labelTextField.label().has().text("What about icon here?");
        labelTextField.label().find("./i").isDisplayed();
    }

    @Test
    public void progressTextFieldTest() {
        for (int i = 1; i < 10; i++) {
            progressTextField.sendKeys("a");
            jdiAssert(progressTextField.hasCurrentProgress(i * 10), Matchers.is(true),
                    "Progress value is not correct");
        }
    }

    @Test(enabled = false)
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
