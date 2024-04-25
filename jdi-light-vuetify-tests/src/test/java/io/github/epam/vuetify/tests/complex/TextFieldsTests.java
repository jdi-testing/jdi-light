package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.TextField;
import io.github.com.pages.TextFieldsPage;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.textFieldsPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.BLUE_LIGHTEN_5;
import static io.github.com.pages.TextFieldsPage.autofocusedTextField;
import static io.github.com.pages.TextFieldsPage.backgroundColorTextField;
import static io.github.com.pages.TextFieldsPage.clearableTextField;
import static io.github.com.pages.TextFieldsPage.counterTextField;
import static io.github.com.pages.TextFieldsPage.customHeightTextField;
import static io.github.com.pages.TextFieldsPage.darkTextField;
import static io.github.com.pages.TextFieldsPage.denseTextField;
import static io.github.com.pages.TextFieldsPage.disabledTextField;
import static io.github.com.pages.TextFieldsPage.errorSuccessCountTextField;
import static io.github.com.pages.TextFieldsPage.errorSuccessTextField;
import static io.github.com.pages.TextFieldsPage.filledTextField;
import static io.github.com.pages.TextFieldsPage.flatTextField;
import static io.github.com.pages.TextFieldsPage.fullWidthWithCounterTextField;
import static io.github.com.pages.TextFieldsPage.hideDetailsTextField;
import static io.github.com.pages.TextFieldsPage.hintTextField;
import static io.github.com.pages.TextFieldsPage.iconSlotsTextField;
import static io.github.com.pages.TextFieldsPage.iconsTextField;
import static io.github.com.pages.TextFieldsPage.labelTextField;
import static io.github.com.pages.TextFieldsPage.loadingTextField;
import static io.github.com.pages.TextFieldsPage.passwordInputTextField;
import static io.github.com.pages.TextFieldsPage.prefixesAndSuffixesTextField;
import static io.github.com.pages.TextFieldsPage.progressTextField;
import static io.github.com.pages.TextFieldsPage.readonlyTextField;
import static io.github.com.pages.TextFieldsPage.reverseTextField;
import static io.github.com.pages.TextFieldsPage.shapedTextField;
import static io.github.com.pages.TextFieldsPage.singleLineTextField;
import static io.github.com.pages.TextFieldsPage.soloTextField;
import static io.github.com.pages.TextFieldsPage.tooltip;
import static io.github.com.pages.TextFieldsPage.validationTextField;
import static io.github.com.pages.TextFieldsPage.visibleHintTextField;

public class TextFieldsTests extends TestsInit {

    @BeforeClass
    public void before() {
        textFieldsPage.open();
        waitCondition(() -> textFieldsPage.isOpened());
        textFieldsPage.checkOpened();
    }

    @Test(description = "Test checks that counter has correct value")
    public void counterTextFieldTest() {
        String defText = "Preliminary report";
        TextField regularCounterField = counterTextField.get(1);
        regularCounterField.has().label("Regular");
        regularCounterField.setText(defText);
        regularCounterField.has().counter("18 / 25");
        regularCounterField.click();
        regularCounterField.has().messageText("This field uses counter prop");
        TextField customCountPropField = counterTextField.get(3);
        customCountPropField.has().label("Custom counter from prop");
        customCountPropField.has().text(defText);
        customCountPropField.has().counter("2 / 5");
        customCountPropField.click();
        customCountPropField.messages().get(1).has().text("This field counts words instead of characters");
        TextField customCountSlotField = counterTextField.get(4);
        customCountSlotField.label().is().text("Custom counter from slot");
        customCountSlotField.has().text(defText);
        customCountSlotField.has().counter("2 / 5");
        customCountSlotField.click();
        customCountSlotField.has().messageText("This field counts words instead of characters");

        TextField limitExcField = counterTextField.get(2);
        limitExcField.is().label("Limit exceeded");
        limitExcField.has().counter("50 / 25");
        limitExcField.click();
        limitExcField.has().messageText("This field uses maxlength attribute");
        customCountSlotField.click();
        limitExcField.has().errorMessage("Max 25 characters");

        regularCounterField.clear();
        regularCounterField.has().text("");
        customCountPropField.has().text("");
        customCountSlotField.has().text("");
        regularCounterField.has().counter("0 / 25");
        customCountSlotField.has().counter("1 / 5");

    }

    @Test (description = "Test checks clearable feature : clear-icon, clearable")
    public void clearableTextFieldTest() {
        TextField clearableTextField1 = clearableTextField.get(1);
        clearableTextField1.isClearable();
        clearableTextField1.has().text("Hey!");
        clearableTextField1.clear();
        clearableTextField1.is().empty();
    }

    @Test (description = "Test checks text field's theme : theme (dark/light)")
    public void themeTextFieldTest() {
        TextField darkTextField1 = darkTextField.get(1);
        TextField lightTextField1 = flatTextField.get(1);
        darkTextField1.show();
        darkTextField1.has().darkTheme();
        lightTextField1.show();
        lightTextField1.has().lightTheme();
    }

    @Test (description = "Test checks flat feature : flat (y/n)")
    public void flatTextFieldTest() {
        TextField flatTextField1 = flatTextField.get(1);
        TextField notFlatTextField1 = backgroundColorTextField.get(1);
        flatTextField1.show();
        flatTextField1.is().flat();
        notFlatTextField1.show();
        notFlatTextField1.is().notFlat();
    }

    @Test (description = "Test checks dense feature : dense (y/n)")
    public void denseTextFieldTest() {
        denseTextField.get(1).show();
        denseTextField.get(1).is().dense();
        filledTextField.get(1).is().notDense();
    }

    @Test (description = "Test checks readonly feature")
    public void readonlyTextFieldTest() {
        readonlyTextField.get(1).show();
        readonlyTextField.get(1).is().readonly();
        disabledTextField.get(1).show();
        disabledTextField.get(1).is().notReadonly();
    }

    @Test (description = "Test checks disabled feature")
    public void disabledTextFieldTest() {
        disabledTextField.get(1).show();
        disabledTextField.get(1).is().disabled();
        readonlyTextField.get(1).show();
        readonlyTextField.get(1).is().enabled();
    }

    @Test (description = "Test checks focused feature")
    public void focusedTextFieldTest() {
        TextField readonlyTextField1 = readonlyTextField.get(1);
        readonlyTextField1.show();
        readonlyTextField1.is().notFocused();
        readonlyTextField1.focus();
        readonlyTextField1.is().focused();
    }

    @Test (description = "Test checks  filled feature")
    public void filledTextFieldTest() {
        filledTextField.get(1).show();
        filledTextField.get(1).is().filled();
        hideDetailsTextField.get(1).show();
        hideDetailsTextField.get(1).is().notFilled();
    }

    @Test (description = "Test checks hide details feature : hide-details (y/n)")
    public void hideDetailsTextFieldTest() {
        TextField detailsHiddenTextField = hideDetailsTextField.get(1);
        TextField detailsNotHiddenTextField = hintTextField.get(1);
        detailsHiddenTextField.show();
        detailsHiddenTextField.has().detailsHidden();
        detailsNotHiddenTextField.show();
        detailsNotHiddenTextField.has().notDetailsHidden();
    }

    @Test (description = "Test checks icon types")
    public void iconsTextFieldTest() {
        String mdiMapMarker = "mdi-map-marker";
        TextField prependOuterIconTextField = iconsTextField.get(1);
        TextField prependInnerIconTextField = iconsTextField.get(2);
        TextField appendInnerIconTextField = iconsTextField.get(3);
        TextField appendOuterIconTextField = iconsTextField.get(4);
        prependOuterIconTextField.show();
        prependOuterIconTextField.has().prependOuterIcon();
        prependOuterIconTextField.getPrependOuterIcon().has().type(mdiMapMarker);
        prependInnerIconTextField.has().prependInnerIcon();
        prependInnerIconTextField.getPrependInnerIcon().has().type(mdiMapMarker);
        appendInnerIconTextField.has().appendInnerIcon();
        appendInnerIconTextField.getAppendInnerIcon().has().type(mdiMapMarker);
        appendOuterIconTextField.has().appendOuterIcon();
        appendOuterIconTextField.getAppendOuterIcon().has().type(mdiMapMarker);
    }

    @Test (description = "Test checks outlined feature")
    public void outlinedTextFieldTest() {
        TextField outlinedTextField = TextFieldsPage.outlinedTextField.get(1);
        TextField notOutlinedTextField = iconsTextField.get(1);
        outlinedTextField.show();
        outlinedTextField.is().outlined();
        notOutlinedTextField.show();
        notOutlinedTextField.is().notOutlined();
    }

    @Test (description = "Test checks that suffix and prefix have proper texts")
    public void prefixesAndSuffixesTextFieldTest() {
        prefixesAndSuffixesTextField.get(1).show();
        prefixesAndSuffixesTextField.get(1).prefix().has().text("$");
        prefixesAndSuffixesTextField.get(2).suffix().has().text("lbs");
    }

    @Test (description = "Test checks shaped feature")
    public void shapedTextFieldTest() {
        TextField shapedTextField1 = shapedTextField.get(1);
        TextField notShapedTextField = singleLineTextField.get(1);
        shapedTextField1.show();
        shapedTextField1.is().shaped();
        notShapedTextField.show();
        notShapedTextField.is().notShaped();
    }

    @Test (description = "Test checks single line feature : single-line (y/n)")
    public void singleLineTextFieldTest() {
        singleLineTextField.get(1).show();
        singleLineTextField.get(1).is().singleLine();
        validationTextField.get(1).show();
        validationTextField.get(1).is().notSingleLine();
    }

    @Test (description = "Test checks solo feature : solo (y/n)")
    public void soloTextFieldTest() {
        soloTextField.get(1).show();
        soloTextField.get(1).is().solo();
        validationTextField.get(1).show();
        validationTextField.get(1).is().notSolo();
    }

    @Test (description = "Test checks solo inverted feature : solo-inverted (y/n)")
    public void soloInvertedTextFieldTest() {
        soloTextField.get(1).show();
        soloTextField.get(2).is().soloInverted();
        soloTextField.get(1).is().notSoloInverted();
    }

    @Test(description = "Test checks messages : persistent-hint (y/n)")
    public void hintTextFieldTest() {
        hintTextField.forEach(textField -> {
            textField.has().messagesCount(0);
            textField.focus();
            waitCondition(() -> textField.messages().size() > 0);
            textField.has().messagesCount(1);
        });

        visibleHintTextField.forEach(textField -> {
            textField.has().messageText("www.example.com/page");
            textField.focus();
            textField.has().messageText("www.example.com/page");
        });
    }

    @Test (description = "Test checks validation fields : rules (func), validate-on-blur (y/n)")
    public void validationTextFieldTest() {
        String maxLengthString = "abcdeabcdeabcdeabcde";
        String format = String.format("%d / 20", maxLengthString.length());
        validationTextField.get(1).setText(maxLengthString);
        validationTextField.get(1).is().text(maxLengthString);
        validationTextField.get(1).is().counter(format);
        validationTextField.get(1).setText(maxLengthString + "abcd");
        validationTextField.get(1).is().text(maxLengthString);
        validationTextField.get(1).is().counter(format);

        validationTextField.get(2).setText("email");
        validationTextField.get(2).has().errorMessage("Invalid e-mail.");
        validationTextField.get(2).setText("email@gmail.com");
        validationTextField.get(2).has().noErrorMessages();
    }

    @Test (description = "Test checks success messages feature : success (y/n), success-messages (string)")
    public void successMessagesTest() {
        TextField successTextField = errorSuccessTextField.get(3);
        TextField errorTextField = errorSuccessTextField.get(2);
        String successMessage = "Success";
        successTextField.show();
        successTextField.has().successMessages();
        successTextField.has().successMessagesCount(1);
        successTextField.has().successMessage(successMessage);
        successTextField.has().successMessages(Collections.singletonList(successMessage));
        errorTextField.has().noSuccessMessages();
    }

    @Test (description = "Test checks error messages feature : error-count (number)")
    public void errorMessagesTest() {
        TextField errorTextField = errorSuccessTextField.get(2);
        TextField successTextField = errorSuccessTextField.get(3);
        String errorMessage = "Error";
        errorTextField.show();
        errorTextField.has().errorMessages();
        errorTextField.has().errorMessagesCount(1);
        errorTextField.has().errorMessage(errorMessage);
        errorTextField.has().errorMessages(Collections.singletonList(errorMessage));
        successTextField.has().noErrorMessages();
    }

    @Test (description = "Test checks that when we click on icon action is performed")
    public void iconSlotsTextFieldTest() {
        iconSlotsTextField.setText("text");
        iconSlotsTextField.getAppendInnerIcon().click();
        iconSlotsTextField.is().text("");
        iconSlotsTextField.selectMenuItemByText("Click me");
        waitCondition(() -> !iconSlotsTextField.getText().equals("Wait for it..."));
        iconSlotsTextField.has().text("You've clicked me!");
        iconSlotsTextField.prependOuterIcon().hover();
        tooltip.has().text("I'm a tooltip");
        tooltip.is().visible();
    }

    // @todo #5048 Fix the test to not use the locator and check the content of an element
    @Test (description = "Test checks text field label and it's text")
    public void labelFieldTest() {
        labelTextField.has().label();
        labelTextField.label().has().text("What about icon here?");
        labelTextField.label().find("./i").isDisplayed();
    }

    @Test (description = "Test checks autofocus feature : autofocus (y/n)")
    public void autofocusTextFieldTest() {
        autofocusedTextField.show();
        autofocusedTextField.is().autofocus();
        errorSuccessCountTextField.get(1).show();
        errorSuccessCountTextField.get(1).is().notAutofocus();
    }

    @Test (description = "Test checks text field colors : color, background-color")
    public void colorTextFieldTest() {
        TextField backgroundColorTextField1 = backgroundColorTextField.get(1);
        backgroundColorTextField1.show();
        backgroundColorTextField1.has().color(BLACK_TRANSPARENT_087.value());
        backgroundColorTextField1.has().backgroundColor(BLUE_LIGHTEN_5.value());
    }

    @Test (description = "Test checks text field's height : height (number)")
    public void heightTextFieldTest() {
        TextField customHeightTextField1 = customHeightTextField.get(1);
        customHeightTextField1.show();
        customHeightTextField1.has().heightLessThan(200);
        customHeightTextField1.has().heightGreaterThan(150);
        customHeightTextField1.has().height(184);
    }

    // @todo #5048 Add assertion for of the progress to the component
    @Test (description = "Test checks progress bar condition")
    public void progressTextFieldTest() {
        for (int i = 1; i < 10; i++) {
            progressTextField.sendKeys("a");
            jdiAssert(progressTextField.hasCurrentProgress(i * 10), Matchers.is(true),
                    "Progress value is not correct");
        }
    }

    @Test (description = "Test checks full-width feature : full-width (y/n)")
    public void fullWidthTextFieldTest() {
        fullWidthWithCounterTextField.get(1).show();
        fullWidthWithCounterTextField.get(1).is().fullWidth();
        labelTextField.show();
        labelTextField.is().notFullWidth();
    }

    @Test (description = "Test checks loading feature : loading (y/n), loader-height (number)")
    public void loadingTextField() {
        TextField loadingTextField1 = loadingTextField.get(1);
        TextField loadedTextField = darkTextField.get(1);
        loadingTextField1.show();
        loadingTextField1.is().loading();
        loadingTextField1.loader().has().height(2);
        loadedTextField.show();
        loadedTextField.is().loaded();
    }

    @Test (description = "Test checks if element has placeholder with proper text : persistent-placeholder (y/n)")
    public void placeholderTextField() {
        TextField placeholderTextField1 = denseTextField.get(3);
        TextField noPlaceholderTextField = denseTextField.get(1);
        placeholderTextField1.show();
        placeholderTextField1.has().placeholder();
        placeholderTextField1.has().placeholder("Filled");
        noPlaceholderTextField.has().notPlaceholder();
    }

    @Test (description = "Test checks reverse feature : reverse (y/n)")
    public void reversedTextField() {
        TextField notReversedTextField = loadingTextField.get(1);
        reverseTextField.show();
        reverseTextField.is().reversed();
        notReversedTextField.show();
        notReversedTextField.is().notReversed();
    }

    @Test (description = "Test checks rounded feature : rounded (y/n)")
    public void roundedTextField() {
        TextField roundedTextField = denseTextField.get(3);
        TextField notRoundedTextField = denseTextField.get(4);
        roundedTextField.show();
        roundedTextField.is().rounded();
        notRoundedTextField.show();
        notRoundedTextField.is().notRounded();
    }

    @Test (description = "Test checks text types")
    public void passwordInputTextFieldTest() {
        passwordInputTextField.get(1).is().textType("password");
        passwordInputTextField.get(1).getAppendInnerIcon().click();
        passwordInputTextField.get(1).is().textType("text");
        passwordInputTextField.get(1).getAppendInnerIcon().click();
        passwordInputTextField.get(1).is().textType("password");
    }
}
