package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.material.elements.inputs.TextField;

public class TextFieldPage extends WebPage {

    @UI("//*[@id=\"formProps\"]/div[1]/div[7]")
    public TextField standartTextField;
    /*=========
    From Props
     ==========*/

    @UI("//input[@id='standard-required']")
    public TextField textFieldRequired;

    @UI("//input[@id='standard-disabled']")
    public TextField textFieldDisabled;

    @UI("//input[@id='standard-password-input']")
    public TextField textFieldPassword;

    @UI("//input[@id='standard-read-only-input']")
    public TextField textFieldReadOnly;

    @UI("//input[@id='standard-number']")
    public TextField textFieldNumber;

    @UI("//input[@id='standard-search']")
    public TextField textFieldSearch;

    @UI("//input[@id='standard-helperText']")
    public TextField textFieldHelper;

    /*=========
    Validations
     ==========*/
    @UI("//input[@id='filled-error']")
    public TextField textFieldFilledError;

    @UI("//input[@id='filled-error-helper-text']")
    public TextField textFieldFilledErrorHelperText;

    @UI("//div[input[@id='filled-error-helper-text']]/following-sibling::p")
    public Label labelErrorHelperText;

    /*================
    Multiline
    ==================*/
    @UI("//textarea[@id='outlined-multiline-flexible']")
    public TextField textFieldMultiLine;

    @UI("//textarea[@id='outlined-textarea']")
    public TextField textFieldMultiLinePlaceHolder;

    @UI("//textarea[@id='outlined-multiline-static']")
    public TextField textFieldMultiLineStatic;

    /*================
    Input Adornments
    ==================*/
    @UI("//input[@id='standard-start-adornment']")
    public TextField textFieldNormal;

    @UI("//input[@id='standard-adornment-weight']")
    public TextField textFieldWeight;

    @UI("//input[@id='standard-adornment-password']")
    public TextField textFieldAdornmentPassword;

    @UI("//input[@id='standard-adornment-amount']")
    public TextField textFieldAmount;

    /*================
    Select
    ==================*/
    @UI("//div[contains(@class, 'MuiSelect-selectMenu')]")
    public TextField selectElementField;

    @UI("//ul[contains(@class, 'MuiMenu-list')]")
    public Select selectElement;

    @UI("//select[@id='outlined-select-currency-native']")
    public Dropdown selectNativeSelect;
}
