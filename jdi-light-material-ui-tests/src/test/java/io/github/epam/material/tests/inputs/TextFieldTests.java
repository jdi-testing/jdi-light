package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.utils.enums.CurrencyItems;
import io.github.com.StaticSite;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.material.elements.utils.StringUtils.generateRandomString;
import static io.github.com.StaticSite.textFieldPage;

public class TextFieldTests extends TestsInit {

    public static final String DEFAULT_VALUE = "Default Value";

    @BeforeMethod
    public void openTextFieldsPage(){
        textFieldPage.open();
        jdiAssert(textFieldPage.isOnPage(textFieldPage.url), Matchers.is(true));
    }

    @Test
    public void formPropsTextFieldTest() {

        Random random = new Random();
        int intNumber = random.nextInt();
        double doubleNumber = random.nextDouble();
        float floatNumber = random.nextFloat();

        String randomString = generateRandomString();

        textFieldPage.textFieldRequired.is().enabled();
        textFieldPage.textFieldRequired.setValue(randomString);
        textFieldPage.textFieldRequired.has().text(randomString);
        textFieldPage.textFieldRequired.clear();
        textFieldPage.textFieldRequired.has().text("");

        textFieldPage.textFieldDisabled.is().disabled();

        textFieldPage.textFieldPassword.is().enabled();
        textFieldPage.textFieldPassword.setValue(randomString);
        textFieldPage.textFieldPassword.clear();
        textFieldPage.textFieldPassword.has().text("");

        textFieldPage.textFieldReadOnly.is().enabled();
        textFieldPage.textFieldReadOnly.is().readOnly();

        textFieldPage.textFieldNumber.is().enabled();
        textFieldPage.textFieldNumber.setValue(String.valueOf(intNumber));
        textFieldPage.textFieldNumber.has().text(String.valueOf(intNumber));
        textFieldPage.textFieldNumber.setValue(String.valueOf(floatNumber));
        textFieldPage.textFieldNumber.has().text(String.valueOf(floatNumber));
        textFieldPage.textFieldNumber.setValue(String.valueOf(doubleNumber));
        textFieldPage.textFieldNumber.has().text(String.valueOf(doubleNumber));
        textFieldPage.textFieldNumber.clear();
        textFieldPage.textFieldNumber.has().text("");

        textFieldPage.textFieldSearch.is().enabled();
        textFieldPage.textFieldSearch.setValue(randomString);
        textFieldPage.textFieldSearch.has().text(randomString);
        textFieldPage.textFieldSearch.clear();
        textFieldPage.textFieldSearch.has().text("");

        textFieldPage.textFieldHelper.is().enabled();
        textFieldPage.textFieldHelper.has().text(DEFAULT_VALUE);
        textFieldPage.textFieldHelper.setValue(randomString);
        textFieldPage.textFieldHelper.has().text(randomString);
        textFieldPage.textFieldHelper.clear();
        textFieldPage.textFieldHelper.has().text("");
    }

    @Test
    public void validateTextFieldTest() {

        String randomString = generateRandomString();
        textFieldPage.textFieldFilledError.is().enabled();
        textFieldPage.textFieldFilledError.setValue(randomString);
        textFieldPage.textFieldFilledError.has().text(randomString);
        textFieldPage.textFieldFilledError.clear();
        textFieldPage.textFieldFilledError.has().text("");

        textFieldPage.textFieldFilledErrorHelperText.is().enabled();
        textFieldPage.textFieldFilledErrorHelperText.setValue(randomString);
        textFieldPage.textFieldFilledErrorHelperText.has().text(randomString);
        textFieldPage.textFieldFilledErrorHelperText.clear();
        textFieldPage.textFieldFilledErrorHelperText.has().text("");
        textFieldPage.labelErrorHelperText.has().text("Incorrect entry.");
    }

    @Test
    public void multilineTextFieldTest() {

        String randomString = generateRandomString();
        textFieldPage.textFieldMultiLine.is().enabled();
        textFieldPage.textFieldMultiLine.has().text("EUR");
        textFieldPage.textFieldMultiLine.clearAndSetValue(randomString);
        textFieldPage.textFieldMultiLine.has().text(randomString);
        textFieldPage.textFieldMultiLine.clear();
        textFieldPage.textFieldMultiLine.has().text("");

        textFieldPage.textFieldMultiLinePlaceHolder.is().enabled();
        textFieldPage.textFieldMultiLinePlaceHolder.setValue(randomString);
        textFieldPage.textFieldMultiLinePlaceHolder.has().text(randomString);
        textFieldPage.textFieldMultiLinePlaceHolder.clear();
        textFieldPage.textFieldMultiLinePlaceHolder.has().text("");

        textFieldPage.textFieldMultiLineStatic.is().enabled();
        textFieldPage.textFieldMultiLineStatic.has().text(DEFAULT_VALUE);
        textFieldPage.textFieldMultiLineStatic.clearAndSetValue(randomString);
        textFieldPage.textFieldMultiLineStatic.has().text(randomString);
        textFieldPage.textFieldMultiLineStatic.clear();
        textFieldPage.textFieldMultiLineStatic.has().text("");
    }

    @Test
    public void inputAdornmentsTest() {

        String randomString = generateRandomString();
        textFieldPage.textFieldNormal.is().enabled();
        textFieldPage.textFieldNormal.setValue(randomString);
        textFieldPage.textFieldNormal.has().text(randomString);
        textFieldPage.textFieldNormal.clear();
        textFieldPage.textFieldNormal.has().text("");

        textFieldPage.textFieldWeight.is().enabled();
        textFieldPage.textFieldWeight.setValue(randomString);
        textFieldPage.textFieldWeight.has().text(randomString);
        textFieldPage.textFieldWeight.clear();
        textFieldPage.textFieldWeight.has().text("");

        textFieldPage.textFieldAdornmentPassword.is().enabled();
        textFieldPage.textFieldAdornmentPassword.setValue(randomString);
        textFieldPage.textFieldAdornmentPassword.has().text(randomString);
        textFieldPage.textFieldAdornmentPassword.clear();
        textFieldPage.textFieldAdornmentPassword.has().text("");

        textFieldPage.textFieldAmount.is().enabled();
        textFieldPage.textFieldAmount.setValue(randomString);
        textFieldPage.textFieldAmount.has().text(randomString);
        textFieldPage.textFieldAmount.clear();
        textFieldPage.textFieldAmount.has().text("");
    }

    @Test
    public void selectTest() {

        for(CurrencyItems currency : CurrencyItems.values()){
            textFieldPage.selectElementField.click();
            textFieldPage.selectElement.selectItemByText(currency.currencyItemText);
            jdiAssert(textFieldPage.selectElementField.getText().equals(currency.currencyItemText), Matchers.is(true));

            textFieldPage.selectNativeSelect.select(currency.currencyItemText);
            textFieldPage.selectNativeSelect.has().text(currency.currencyItemText);
        }
    }
}
