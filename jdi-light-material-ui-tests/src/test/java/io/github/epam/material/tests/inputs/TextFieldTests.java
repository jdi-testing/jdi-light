package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.textFieldPage;
import static io.github.com.pages.inputs.TextFieldPage.disabledTextField;
import static io.github.com.pages.inputs.TextFieldPage.helperTextTextField;
import static io.github.com.pages.inputs.TextFieldPage.inputAdornmentsTextFields;
import static io.github.com.pages.inputs.TextFieldPage.multilineTextFields;
import static io.github.com.pages.inputs.TextFieldPage.numberTextField;
import static io.github.com.pages.inputs.TextFieldPage.passwordTextField;
import static io.github.com.pages.inputs.TextFieldPage.readOnlyTextField;
import static io.github.com.pages.inputs.TextFieldPage.requiredTextField;
import static io.github.com.pages.inputs.TextFieldPage.searchTextField;
import static io.github.com.pages.inputs.TextFieldPage.selectTextFields;
import static io.github.com.pages.inputs.TextFieldPage.validationTextFields;
import static io.github.epam.utils.StringUtils.generateRandomString;
import static com.epam.jdi.light.material.elements.utils.enums.Position.START;
import static com.epam.jdi.light.material.elements.utils.enums.Position.END;

import com.epam.jdi.light.material.elements.inputs.TextField;
import io.github.com.custom.elements.textfields.MultilineTextField;
import io.github.com.custom.elements.textfields.SelectTextField;
import io.github.epam.TestsInit;
import io.github.epam.enums.Currency;
import java.util.Random;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextFieldTests extends TestsInit {

    private static final String DEFAULT_VALUE = "Default Value";
    private static final String HELLO_WORLD = "Hello World";
    private final String randomString = generateRandomString();
    private final String randomNumber = String.valueOf(new Random().nextFloat());

    @BeforeClass
    public void openTextFieldsPage() {
        textFieldPage.open();
        textFieldPage.isOpened();
    }

    @Test
    public void formPropsRequiredTextFieldTests() {
        requiredTextField.show();

        requiredTextField.has().text(HELLO_WORLD);

        requiredTextField.click();
        requiredTextField.is().focused().and().has().type("text");

        requiredTextField.clear();
        requiredTextField.is().empty();

        requiredTextField.sendKeys(randomString);
        requiredTextField.has().text(randomString);
        requiredTextField.label().has().text("Required *");
    }

    @Test
    public void formPropsDisabledTextFieldTests() {
        disabledTextField.show();

        disabledTextField.is().disabled()
            .and().has().text(HELLO_WORLD).and().type("text");
        disabledTextField.label().has().text("Disabled");
    }

    @Test
    public void formPropsPasswordTextFieldTests() {
        passwordTextField.show();

        passwordTextField.has().type("password");

        passwordTextField.click();
        passwordTextField.is().focused();

        passwordTextField.sendKeys(randomString);
        passwordTextField.has().text(randomString);
    }

    @Test
    public void formPropsReadOnlyTextFieldTests() {
        readOnlyTextField.show();

        readOnlyTextField.is().readonly().and().has().text(HELLO_WORLD);

        readOnlyTextField.click();
        readOnlyTextField.is().focused().and().has().type("text");
        readOnlyTextField.label().has().text("Read Only");
    }

    @Test
    public void formPropsNumberTextFieldTests() {
        numberTextField.show();

        numberTextField.has().type("number");

        numberTextField.click();
        numberTextField.is().focused();

        numberTextField.setText(randomNumber);
        numberTextField.has().value(randomNumber);
        numberTextField.label().has().text("Number");
    }

    @Test
    public void formPropsSearchTextFieldTests() {
        searchTextField.show();

        searchTextField.has().type("search")
            .and().placeholderText("Search field");

        searchTextField.click();
        searchTextField.is().focused();

        searchTextField.sendKeys(randomString);
        searchTextField.has().text(randomString);

        searchTextField.clear();
        searchTextField.is().empty();
    }

    @Test
    public void formPropsHelperTextFieldTests() {
        helperTextTextField.show();

        helperTextTextField.has().type("text").and().text(DEFAULT_VALUE);

        helperTextTextField.click();
        helperTextTextField.is().focused();

        helperTextTextField.clear();
        helperTextTextField.is().empty();

        helperTextTextField.sendKeys(randomString);
        helperTextTextField.has().text(randomString).and().helperText("Some important text");
    }

    @Test
    public void validateTextFieldTests() {
        TextField validationTextField = validationTextFields.get(1);
        validationTextField.show();

        validationTextField.has().text(HELLO_WORLD);
        validationTextField.label().has().cssClass("Mui-error");

        validationTextField.click();
        validationTextField.is().focused();

        validationTextField.clear();
        validationTextField.is().empty();

        validationTextFields.get(2).click();
        validationTextField.has().placeholderText("Error");

        validationTextField.sendKeys(randomString);
        validationTextField.has().text(randomString);
        validationTextField.label().has().text("Error");
    }

    @Test
    public void validateWitHelperTextFieldTests() {
        TextField validationTextFieldWithHelper = validationTextFields.get(2);
        validationTextFieldWithHelper.show();

        validationTextFieldWithHelper.has().text(HELLO_WORLD).and().has().validationError();

        validationTextFieldWithHelper.click();
        validationTextFieldWithHelper.is().focused();

        validationTextFieldWithHelper.clear();
        validationTextFieldWithHelper.is().empty();

        validationTextFields.get(1).click();
        validationTextFieldWithHelper.has().placeholderText("Error");

        validationTextFieldWithHelper.sendKeys(randomString);
        validationTextFieldWithHelper.has().text(randomString).and().helperText("Incorrect entry.");
        validationTextFieldWithHelper.label().has().text("Error");
    }

    @Test
    public void outlinedFlexibleMultilineTextFieldTests() {
        MultilineTextField flexibleMultilineTextField = multilineTextFields.get(1);
        flexibleMultilineTextField.show();

        flexibleMultilineTextField.has().text("EUR");
        flexibleMultilineTextField.textArea.has().rowsCount(1);

        flexibleMultilineTextField.click();
        flexibleMultilineTextField.is().focused();

        flexibleMultilineTextField.clear();
        flexibleMultilineTextField.is().empty();

        flexibleMultilineTextField.sendKeys(randomString);
        flexibleMultilineTextField.has().text(randomString);
        flexibleMultilineTextField.label().has().text("Multiline");
    }

    @Test
    public void outlinedTextareaMultilineTextFieldTests() {
        MultilineTextField textareaTextField = multilineTextFields.get(2);
        textareaTextField.show();

        textareaTextField.has().placeholderText("Multiline Placeholder");

        textareaTextField.click();
        textareaTextField.has().placeholderText("Placeholder")
            .and().is().focused().and().empty();

        textareaTextField.sendKeys(randomString);
        textareaTextField.has().text(randomString);
    }

    @Test
    public void outlinedStaticMultilineTextFieldTests() {
        MultilineTextField staticMultilineTextField = multilineTextFields.get(3);
        staticMultilineTextField.show();

        staticMultilineTextField.has().text(DEFAULT_VALUE);
        staticMultilineTextField.textArea.has().rowsCount(4);

        staticMultilineTextField.click();
        staticMultilineTextField.is().focused();

        staticMultilineTextField.clear();
        staticMultilineTextField.is().empty();

        staticMultilineTextField.sendKeys(randomString);
        staticMultilineTextField.has().text(randomString);
        staticMultilineTextField.label().has().text("Multiline");
    }

    @Test
    public void standardAdornmentTextFieldTests() {
        TextField standardAdornmentTextField = inputAdornmentsTextFields.get(1);
        standardAdornmentTextField.show();

        standardAdornmentTextField.adornment().has().position(START.toString()).and().text("Kg");

        standardAdornmentTextField.click();
        standardAdornmentTextField.is().focused().and().empty();

        standardAdornmentTextField.sendKeys(randomString);
        standardAdornmentTextField.has().text(randomString);
        standardAdornmentTextField.label().has().text("With normal TextField");
    }

    @Test
    public void standardWithHelperAdornmentTextFieldTests() {
        TextField adornmentTextFieldWithHelper = inputAdornmentsTextFields.get(2);
        adornmentTextFieldWithHelper.show();

        adornmentTextFieldWithHelper.adornment().has().position(END.toString()).and().text("Kg");
        adornmentTextFieldWithHelper.is().empty();

        adornmentTextFieldWithHelper.sendKeys(randomString);
        adornmentTextFieldWithHelper.has().text(randomString).and().helperText("Weight");
    }

    @Test
    public void standardPasswordAdornmentTextFieldTests() {
        TextField passwordAdornmentTextField = inputAdornmentsTextFields.get(3);
        passwordAdornmentTextField.show();

        passwordAdornmentTextField.adornment().has().position(END.toString());
        passwordAdornmentTextField.has().type("password").and().placeholderText("Password");

        passwordAdornmentTextField.click();
        passwordAdornmentTextField.is().focused();

        passwordAdornmentTextField.adornment().click();
        passwordAdornmentTextField.has().type("text").and().is().empty();

        passwordAdornmentTextField.sendKeys(randomString);
        passwordAdornmentTextField.has().text(randomString);

        passwordAdornmentTextField.adornment().click();
        passwordAdornmentTextField.has().type("password");
    }

    @Test
    public void standardAmountAdornmentTextFieldTests() {
        TextField amountAdornmentTextField = inputAdornmentsTextFields.get(4);
        amountAdornmentTextField.show();

        amountAdornmentTextField.adornment().has().position(START.toString()).and().text(Currency.USD.toString());
        amountAdornmentTextField.label().has().text("Amount");
        amountAdornmentTextField.has().type("text");

        amountAdornmentTextField.click();
        amountAdornmentTextField.is().focused().and().empty();

        amountAdornmentTextField.sendKeys(randomString);
        amountAdornmentTextField.has().text(randomString);
    }

    // @todo #5343 Check SelectTextField on Select functionality, default locators does not work
    @Test(enabled = false)
    public void selectTextFieldTest() {
        SelectTextField selectTextField = selectTextFields.get(1);
        selectTextField.show();

        selectTextField.label().has().text("Select");
        selectTextField.has().helperText("Please select your currency");
        for (Currency currency : Currency.values()) {
            selectTextField.click();
            selectTextField.select().select(currency.ordinal() + 1);
            selectTextField.select().has().selected(currency);
        }
    }

    @Test
    public void selectNativeTextFieldTest() {
        SelectTextField selectNativeTextField = selectTextFields.get(2);
        selectNativeTextField.show();

        selectNativeTextField.label().has().text("Native select");
        selectNativeTextField.has().helperText("Please select your currency");
        for (Currency currency : Currency.values()) {
            selectNativeTextField.click();
            selectNativeTextField.nativeSelect().select(currency.ordinal() + 1);
            selectNativeTextField.nativeSelect().has().selected(currency);
        }
    }
}
