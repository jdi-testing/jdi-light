package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class SelectPage extends WebPage {

    @JDropdown(root = "//*[@id='demo-simple-select']/following-sibling::div")
    public static Select simpleSelect;

    @JDropdown(root = "//*[@id='demo-disabled-select']/following-sibling::div")
    public static Select disabledSelect;

    @JDropdown(root = "//*[@id='demo-multiple-select']/following-sibling::div", autoClose = true)
    public static Select multipleSelect;

    @JDropdown(root = "//div[@id='grouped-select']/..")
    public static Select groupedSelect;

    @UI("//button[./span[text()='Open the select']]")
    public static Button openSelectButton;

    @JDropdown(root = "//*[@id='demo-controlled-open-select-label']/following-sibling::div")
    public static Select controlledOpenSelect;

    @UI("//*[@id='age-native-helper']/..")
    public static Dropdown nativeHelperSelect;

    @UI("//*[@id='name-native-error']/..")
    public static Dropdown nativeErrorSelect;

    @UI("//*[@id='age-native-label-placeholder']/..")
    public static Dropdown labelPlaceholderSelect;

    @UI("//*[@id='name-native-disabled']")
    public static Dropdown nativeDisableSelect;

    @UI("p.MuiFormHelperText-root.Mui-error")
    public static Label errorLabel;

    @UI("p.MuiFormHelperText-root.Mui-disabled")
    public static Label disableLabel;

    @UI("//*[@id='age-native-label-placeholder']//../following-sibling::p")
    public static Label placeholderLabel;

    @UI("//*[@id='age-native-helper']//../following-sibling::p")
    public static Label helperLabel;
}
