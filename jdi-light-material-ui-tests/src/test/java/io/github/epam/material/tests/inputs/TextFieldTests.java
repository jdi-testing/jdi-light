package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.utils.enums.CurrencyItems;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.github.com.StaticSite.textFieldPage;
import static io.github.com.pages.inputs.TextFieldPage.formPropsTextFields;
import static io.github.com.pages.inputs.TextFieldPage.inputAdornmentsTextFields;
import static io.github.com.pages.inputs.TextFieldPage.multilineTextFields;
import static io.github.com.pages.inputs.TextFieldPage.selectTextFields;
import static io.github.com.pages.inputs.TextFieldPage.validationTextFields;
import static io.github.epam.utils.StringUtils.generateRandomString;


public class TextFieldTests extends TestsInit {

    private static final String DEFAULT_VALUE = "Default Value";
    private static final String HELLO_WORLD = "Hello World";
    private final String randomString = generateRandomString();
    private final Float randomNumber = new Random().nextFloat();

    @BeforeMethod
    public void openTextFieldsPage() {
        textFieldPage.open();
        textFieldPage.isOpened();
    }

    @Test
    public void formPropsRequiredTextFieldTests() {
        formPropsTextFields.get(1).has().text(HELLO_WORLD);
        formPropsTextFields.get(1).click();
        formPropsTextFields.get(1).is().focused();
        formPropsTextFields.get(1).has().type("text");
        formPropsTextFields.get(1).clear();
        formPropsTextFields.get(1).is().empty();
        formPropsTextFields.get(1).sendKeys(randomString);
        formPropsTextFields.get(1).has().text(randomString);
        formPropsTextFields.get(1).label().has().text("Required *");
    }

    @Test
    public void formPropsDisabledTextFieldTests() {
        formPropsTextFields.get(2).is().disabled();
        formPropsTextFields.get(2).has().text(HELLO_WORLD);
        formPropsTextFields.get(2).has().type("text");
        formPropsTextFields.get(2).label().has().text("Disabled");
    }

    @Test
    public void formPropsPasswordTextFieldTests() {
        formPropsTextFields.get(3).has().type("password");
        formPropsTextFields.get(3).click();
        formPropsTextFields.get(3).is().focused();
        formPropsTextFields.get(3).sendKeys(randomString);
        formPropsTextFields.get(3).has().text(randomString);
    }

    @Test
    public void formPropsReadOnlyTextFieldTests() {
        formPropsTextFields.get(4).is().readonly();
        formPropsTextFields.get(4).has().text(HELLO_WORLD);
        formPropsTextFields.get(4).click();
        formPropsTextFields.get(4).is().focused();
        formPropsTextFields.get(4).label().has().text("Read Only");
        formPropsTextFields.get(4).has().type("text");

    }

    @Test
    public void formPropsNumberTextFieldTests() {
        formPropsTextFields.get(5).has().type("number");
        formPropsTextFields.get(5).click();
        formPropsTextFields.get(5).is().focused();
        formPropsTextFields.get(5).setValue(randomNumber);
        formPropsTextFields.get(5).has().value(randomNumber);
        formPropsTextFields.get(5).label().has().text("Number");
    }

    @Test
    public void formPropsSearchTextFieldTests() {
        formPropsTextFields.get(6).has().type("search");
        formPropsTextFields.get(6).has().placeholder();
        formPropsTextFields.get(6).has().placeholderText("Search field");
        formPropsTextFields.get(6).click();
        formPropsTextFields.get(6).is().focused();
        formPropsTextFields.get(6).sendKeys(randomString);
        formPropsTextFields.get(6).has().text(randomString);
        formPropsTextFields.get(6).clear();
        formPropsTextFields.get(6).is().empty();
    }

    @Test
    public void formPropsHelperTextFieldTests() {
        formPropsTextFields.get(7).has().type("text");
        formPropsTextFields.get(7).has().text(DEFAULT_VALUE);
        formPropsTextFields.get(7).click();
        formPropsTextFields.get(7).is().focused();
        formPropsTextFields.get(7).clear();
        formPropsTextFields.get(7).is().empty();
        formPropsTextFields.get(7).sendKeys(randomString);
        formPropsTextFields.get(7).has().text(randomString);
        formPropsTextFields.get(7).has().helperText("Some important text");
    }

    @Test
    public void validateTextFieldTests() {
        validationTextFields.get(1).has().text(HELLO_WORLD);
        validationTextFields.get(1).is().validationError();
        validationTextFields.get(1).click();
        validationTextFields.get(1).is().focused();
        validationTextFields.get(1).clear();
        validationTextFields.get(1).is().empty();
        validationTextFields.get(2).click();
        validationTextFields.get(1).has().placeholder();
        validationTextFields.get(1).has().placeholderText("Error");
        validationTextFields.get(1).sendKeys(randomString);
        validationTextFields.get(1).has().text(randomString);
        validationTextFields.get(1).label().has().text("Error");
    }

    @Test
    public void validateWitHelperTextFieldTests() {
        validationTextFields.get(2).has().text(HELLO_WORLD);
        validationTextFields.get(2).is().validationError();
        validationTextFields.get(2).click();
        validationTextFields.get(2).is().focused();
        validationTextFields.get(2).clear();
        validationTextFields.get(2).is().empty();
        validationTextFields.get(1).click();
        validationTextFields.get(2).has().placeholder();
        validationTextFields.get(2).has().placeholderText("Error");
        validationTextFields.get(2).sendKeys(randomString);
        validationTextFields.get(2).has().text(randomString);
        validationTextFields.get(2).label().has().text("Error");
        validationTextFields.get(2).has().helperText("Incorrect entry.");
    }

    @Test
    public void outlinedFlexibleMultilineTextFieldTests() {
        multilineTextFields.get(1).has().text("EUR");
        multilineTextFields.get(1).click();
        multilineTextFields.get(1).is().focused();
        multilineTextFields.get(1).clear();
        multilineTextFields.get(1).is().empty();
        multilineTextFields.get(1).sendKeys(randomString);
        multilineTextFields.get(1).has().text(randomString);
        multilineTextFields.get(1).label().has().text("Multiline");
    }

    @Test
    public void outlinedTextareaMultilineTextFieldTests() {
        multilineTextFields.get(2).has().placeholder();
        multilineTextFields.get(2).has().placeholderText("Multiline Placeholder");
        multilineTextFields.get(2).click();
        multilineTextFields.get(2).has().placeholderText("Placeholder");
        multilineTextFields.get(2).is().focused();
        multilineTextFields.get(2).is().empty();
        multilineTextFields.get(2).sendKeys(randomString);
        multilineTextFields.get(2).has().text(randomString);
   }

    @Test
    public void outlinedStaticMultilineTextFieldTests() {
        multilineTextFields.get(3).has().text(DEFAULT_VALUE);
        multilineTextFields.get(3).click();
        multilineTextFields.get(3).is().focused();
        multilineTextFields.get(3).clear();
        multilineTextFields.get(3).is().empty();
        multilineTextFields.get(3).sendKeys(randomString);
        multilineTextFields.get(3).has().text(randomString);
        multilineTextFields.get(3).label().has().text("Multiline");
    }

    @Test
    public void standardAdornmentTextFieldTests() {
        inputAdornmentsTextFields.get(1).adornment().has().position("start");
        inputAdornmentsTextFields.get(1).adornment().has().text("Kg");
        inputAdornmentsTextFields.get(1).click();
        inputAdornmentsTextFields.get(1).is().focused();
        inputAdornmentsTextFields.get(1).is().empty();
        inputAdornmentsTextFields.get(1).sendKeys(randomString);
        inputAdornmentsTextFields.get(1).has().text(randomString);
        inputAdornmentsTextFields.get(1).label().has().text("With normal TextField");
    }

    @Test
    public void standardWithHelperAdornmentTextFieldTests() {
        inputAdornmentsTextFields.get(2).adornment().has().position("end");
        inputAdornmentsTextFields.get(2).adornment().has().text("Kg");
        inputAdornmentsTextFields.get(2).is().empty();
        inputAdornmentsTextFields.get(2).sendKeys(randomString);
        inputAdornmentsTextFields.get(2).has().text(randomString);
        inputAdornmentsTextFields.get(2).has().helperText("Weight");
    }

    @Test
    public void standardPasswordAdornmentTextFieldTests() {
        inputAdornmentsTextFields.get(3).adornment().has().position("end");
        inputAdornmentsTextFields.get(3).has().placeholder();
        inputAdornmentsTextFields.get(3).has().type("password");
        inputAdornmentsTextFields.get(3).click();
        inputAdornmentsTextFields.get(3).is().focused();
        inputAdornmentsTextFields.get(3).adornment().click();
        inputAdornmentsTextFields.get(3).is().empty();
        inputAdornmentsTextFields.get(3).sendKeys(randomString);
        inputAdornmentsTextFields.get(3).has().text(randomString);
        inputAdornmentsTextFields.get(3).adornment().click();
    }

    @Test
    public void standardAmountAdornmentTextFieldTests() {
        inputAdornmentsTextFields.get(4).adornment().has().position("start");
        inputAdornmentsTextFields.get(4).label().has().text("Amount");
        inputAdornmentsTextFields.get(4).has().type("text");
        inputAdornmentsTextFields.get(4).adornment().has().text(CurrencyItems.USD.value);
        inputAdornmentsTextFields.get(4).click();
        inputAdornmentsTextFields.get(4).is().focused();
        inputAdornmentsTextFields.get(4).is().empty();
        inputAdornmentsTextFields.get(4).sendKeys(randomString);
        inputAdornmentsTextFields.get(4).has().text(randomString);
    }

    @Test
    public void selectTextFieldTest() {
        selectTextFields.get(1).label().has().text("Select");
        selectTextFields.get(1).has().helperText("Please select your currency");
        for (CurrencyItems currency : CurrencyItems.values()) {
            selectTextFields.get(1).click();
            selectTextFields.get(1).select().select(currency.ordinal() + 1);
            selectTextFields.get(1).select().has().selected(currency);
        }
    }

    @Test
    public void selectNativeTextFieldTest() {
        selectTextFields.get(2).label().has().text("Native select");
        selectTextFields.get(2).has().helperText("Please select your currency");
        for (CurrencyItems currency : CurrencyItems.values()) {
            selectTextFields.get(2).click();
            selectTextFields.get(2).dropdown().select(currency.ordinal() + 1);
            selectTextFields.get(2).dropdown().has().selected(currency);
        }
    }
}
