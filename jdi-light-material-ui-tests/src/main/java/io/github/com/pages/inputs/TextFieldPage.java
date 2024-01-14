package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.TextField;
import io.github.com.custom.elements.textfields.MultilineTextField;
import io.github.com.custom.elements.textfields.SelectTextField;
import java.util.List;

public class TextFieldPage extends WebPage {

    // @todo #5297 Fix locators for more stable variant
    @UI("//input[@id='standard-required']/../..")
    public static TextField requiredTextField;

    @UI("//input[@id='standard-disabled']/../..")
    public static TextField disabledTextField;

    @UI("//input[@id='standard-password-input']/../..")
    public static TextField passwordTextField;

    @UI("//input[@id='standard-read-only-input']/../..")
    public static TextField readOnlyTextField;

    @UI("//input[@id='standard-number']/../..")
    public static TextField numberTextField;

    @UI("//input[@id='standard-search']/../..")
    public static TextField searchTextField;

    @UI("//input[@id='standard-helperText']/../..")
    public static TextField helperTextTextField;

    @UI("//form[@id='formProps']/div[2]/div[contains(@class, 'MuiTextField-root')]")
    public static List<TextField> validationTextFields;

    @UI("//form[@id='formProps']/div[3]/div[contains(@class, 'MuiTextField-root')]")
    public static List<MultilineTextField> multilineTextFields;

    @UI("//form[@id='formProps']/div[4]/div[contains(@class, 'MuiTextField-root')]")
    public static List<SelectTextField> selectTextFields;

    @UI("//form[@id='formProps']/div[5]/div[contains(@class, 'MuiFormControl-root')]")
    public static List<TextField> inputAdornmentsTextFields;

}
