package io.github.com.pages.inputs;

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

    @JDropdown(root = "//*[@id='age-native-helper']/following-sibling::div")
    public static Select nativeHelperSelect;
}
