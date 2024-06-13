package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.TextField;
import io.github.com.custom.elements.textfields.MultilineTextField;
import io.github.com.custom.elements.textfields.SelectTextField;
import java.util.List;

public class TextFieldPage extends WebPage {

    @UI("//*[contains(@class, 'MuiTextField-root')][.//input[@id='standard-required']]")
    public static TextField requiredTextField;

    @UI("//*[contains(@class, 'MuiTextField-root')][.//input[@id='standard-disabled']]")
    public static TextField disabledTextField;

    @UI("//*[contains(@class, 'MuiTextField-root')][.//input[@id='standard-password-input']]")
    public static TextField passwordTextField;

    @UI("//*[contains(@class, 'MuiTextField-root')][.//input[@id='standard-read-only-input']]")
    public static TextField readOnlyTextField;

    @UI("//*[contains(@class, 'MuiTextField-root')][.//input[@id='standard-number']]")
    public static TextField numberTextField;

    @UI("//*[contains(@class, 'MuiTextField-root')][.//input[@id='standard-search']]")
    public static TextField searchTextField;

    @UI("//*[contains(@class, 'MuiTextField-root')][.//input[@id='standard-helperText']]")
    public static TextField helperTextTextField;

    @UI("//h2[text()='Validation']//following::div[1]/*[contains(@class, 'MuiTextField-root')]")
    public static List<TextField> validationTextFields;

    @UI("//h2[text()='Multiline']//following::div[1]/*[contains(@class, 'MuiTextField-root')]")
    public static List<MultilineTextField> multilineTextFields;

    @UI("//h2[text()='Select']//following::div[1]/*[contains(@class, 'MuiTextField-root')]")
    public static List<SelectTextField> selectTextFields;

    // @todo #5343 Check that all fields are TextFields, only two of them has such class
    @UI("//h2[text()='Input Adornments']//following::div[1]/*[contains(@class, 'MuiFormControl-root')]")
    public static List<TextField> inputAdornmentsTextFields;

}
