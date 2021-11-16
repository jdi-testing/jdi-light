package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.material.elements.utils.enums.CurrencyItems;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.textFieldPage;
import static io.github.com.pages.inputs.TextFieldPage.formPropsTextFields;
import static io.github.com.pages.inputs.TextFieldPage.validationTextFields;
import static io.github.epam.utils.StringUtils.generateRandomString;


public class TextFieldTests extends TestsInit {

    public static final String DEFAULT_VALUE = "Default Value";

    @BeforeMethod
    public void openTextFieldsPage() {
        textFieldPage.open();
        textFieldPage.isOpened();
    }

    @Test
    public void formPropsTextFieldTest() {
        System.out.println("Form");
        for (TextField textField: formPropsTextFields) {
            System.out.println(textField.getTextArea().attr("type"));
        }
        System.out.println("Valid");
        for (TextField textField: validationTextFields) {
            System.out.println(textField.getTextArea().attr("type"));
        }
//        System.out.println("mult");
//        for (TextField textField: multilineTextFields) {
//            System.out.println(textField.getTextArea().attr("type"));
//        }
//        System.out.println("Sele");
//        for (TextField textField: selectTextFields) {
//            System.out.println(textField.getTextArea().attr("type"));
//        }
//        System.out.println("Ador");
//        for (TextField textField: inputAdornmentsTextFields) {
//            System.out.println(textField.getTextArea().attr("type"));
//        }


        formPropsTextFields.get(1).sendText("asdfsdf");
        formPropsTextFields.get(1).has().text("asdfsdf");
        formPropsTextFields.get(1).label().has().text("Required *");
        formPropsTextFields.get(2).is().disabled();
        formPropsTextFields.get(2).has().text("Hello World");
        formPropsTextFields.get(7).has().helperTextField();
        formPropsTextFields.get(7).has().helperText("Some important text");

//        Random random = new Random();
//        int intNumber = random.nextInt();
//        double doubleNumber = random.nextDouble();
//        float floatNumber = random.nextFloat();
//
//        String randomString = generateRandomString();
//
//        textFieldPage.textFieldRequired.is().enabled();
//        textFieldPage.textFieldRequired.setValue(randomString);
//        textFieldPage.textFieldRequired.has().text(randomString);
//        textFieldPage.textFieldRequired.clear();
//        textFieldPage.textFieldRequired.has().text("");
//
//        textFieldPage.textFieldDisabled.is().disabled();
//
//        textFieldPage.textFieldPassword.is().enabled();
//        textFieldPage.textFieldPassword.setValue(randomString);
//        textFieldPage.textFieldPassword.clear();
//        textFieldPage.textFieldPassword.has().text("");
//
//        textFieldPage.textFieldReadOnly.is().enabled();
//        textFieldPage.textFieldReadOnly.has().text("Hello World");
//        textFieldPage.textFieldReadOnly.has().attr("readonly");
//
//        textFieldPage.textFieldNumber.is().enabled();
//        textFieldPage.textFieldNumber.setValue(String.valueOf(intNumber));
//        textFieldPage.textFieldNumber.has().text(String.valueOf(intNumber));
//        textFieldPage.textFieldNumber.setValue(String.valueOf(floatNumber));
//        textFieldPage.textFieldNumber.has().text(String.valueOf(floatNumber));
//        textFieldPage.textFieldNumber.setValue(String.valueOf(doubleNumber));
//        textFieldPage.textFieldNumber.has().text(String.valueOf(doubleNumber));
//        textFieldPage.textFieldNumber.clear();
//        textFieldPage.textFieldNumber.has().text("");
//
//        textFieldPage.textFieldSearch.is().enabled();
//        textFieldPage.textFieldSearch.setValue(randomString);
//        textFieldPage.textFieldSearch.has().text(randomString);
//        textFieldPage.textFieldSearch.clear();
//        textFieldPage.textFieldSearch.has().text("");
//
//        textFieldPage.textFieldHelper.is().enabled();
//        textFieldPage.textFieldHelper.has().text(DEFAULT_VALUE);
//        textFieldPage.textFieldHelper.setValue(randomString);
//        textFieldPage.textFieldHelper.has().text(randomString);
//        textFieldPage.textFieldHelper.clear();
//        textFieldPage.textFieldHelper.has().text("");
    }

    @Test
    public void validateTextFieldTest() {

        String randomString = generateRandomString();
//        textFieldPage.textFieldFilledError.is().enabled();
//        textFieldPage.textFieldFilledError.setValue(randomString);
//        textFieldPage.textFieldFilledError.has().text(randomString);
//        textFieldPage.textFieldFilledError.clear();
//        textFieldPage.textFieldFilledError.has().text("");
//
//        textFieldPage.textFieldFilledErrorHelperText.is().enabled();
//        textFieldPage.textFieldFilledErrorHelperText.setValue(randomString);
//        textFieldPage.textFieldFilledErrorHelperText.has().text(randomString);
//        textFieldPage.textFieldFilledErrorHelperText.clear();
//        textFieldPage.textFieldFilledErrorHelperText.has().text("");
//        textFieldPage.labelErrorHelperText.has().text("Incorrect entry.");
    }

    @Test
    public void multilineTextFieldTest() {

        String randomString = generateRandomString();
//        textFieldPage.textFieldMultiLine.is().enabled();
//        textFieldPage.textFieldMultiLine.has().text("EUR");
//        textFieldPage.textFieldMultiLine.setText(randomString);
//
//        textFieldPage.textFieldMultiLine.has().text(randomString);
//        textFieldPage.textFieldMultiLine.clear();
//        textFieldPage.textFieldMultiLine.has().text("EUR");
//
//        textFieldPage.textFieldMultiLinePlaceHolder.is().enabled();
//        textFieldPage.textFieldMultiLinePlaceHolder.setValue(randomString);
//        textFieldPage.textFieldMultiLinePlaceHolder.has().text(randomString);
//        textFieldPage.textFieldMultiLinePlaceHolder.clear();
//        textFieldPage.textFieldMultiLinePlaceHolder.has().text("");
//
//        textFieldPage.textFieldMultiLineStatic.is().enabled();
//        textFieldPage.textFieldMultiLineStatic.has().text(DEFAULT_VALUE);
//        textFieldPage.textFieldMultiLineStatic.setText(randomString);
//        textFieldPage.textFieldMultiLineStatic.has().text(randomString);
//        textFieldPage.textFieldMultiLineStatic.clear();
//        textFieldPage.textFieldMultiLineStatic.has().text("");
    }

    @Test
    public void inputAdornmentsTest() {

        String randomString = generateRandomString();
//        textFieldPage.textFieldNormal.is().enabled();
//        textFieldPage.textFieldNormal.setText(randomString);
//        textFieldPage.textFieldNormal.has().text(randomString);
//        textFieldPage.textFieldNormal.clear();
//        textFieldPage.textFieldNormal.has().text("");
//
//        textFieldPage.textFieldWeight.is().enabled();
//        textFieldPage.textFieldWeight.setText(randomString);
//        textFieldPage.textFieldWeight.has().text(randomString);
//        textFieldPage.textFieldWeight.clear();
//        textFieldPage.textFieldWeight.has().text("");
//
//        textFieldPage.textFieldAdornmentPassword.is().enabled();
//        textFieldPage.textFieldAdornmentPassword.setText(randomString);
//        textFieldPage.textFieldAdornmentPassword.has().text(randomString);
//        textFieldPage.textFieldAdornmentPassword.clear();
//        textFieldPage.textFieldAdornmentPassword.has().text("");
//
//        textFieldPage.textFieldAmount.is().enabled();
//        textFieldPage.textFieldAmount.setText(randomString);
//        textFieldPage.textFieldAmount.has().text(randomString);
//        textFieldPage.textFieldAmount.clear();
//        textFieldPage.textFieldAmount.has().text("");
    }

    @Test
    public void selectTest() {
        for (CurrencyItems currency : CurrencyItems.values()) {
            textFieldPage.selectElement.select(currency.ordinal() + 1);
            textFieldPage.selectElement.has().selected(currency);
            textFieldPage.selectNativeSelect.select(currency);
            textFieldPage.selectNativeSelect.has().selected(currency);
        }
    }
}
