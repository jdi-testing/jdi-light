package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.TextField;

import java.util.List;

public class TextFieldPage extends WebPage {

    @UI("//form[@id='formProps']/div[1]/div[contains(@class, 'MuiTextField-root')]")
    public static List<TextField> formPropsTextFields;

    @UI("//form[@id='formProps']/div[2]/div[contains(@class, 'MuiTextField-root')]")
    public static List<TextField> validationTextFields;

    @UI("//form[@id='formProps']/div[3]/div[contains(@class, 'MuiTextField-root')]")
    public static List<TextField> multilineTextFields;

    @UI("//form[@id='formProps']/div[4]/div[contains(@class, 'MuiTextField-root')]")
    public static List<TextField> selectTextFields;

    @UI("//form[@id='formProps']/div[5]/div[contains(@class, 'MuiFormControl-root')]")
    public static List<TextField> inputAdornmentsTextFields;

}
