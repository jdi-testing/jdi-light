package io.github.com.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;

public class AutocompletesPage extends VuetifyPage {
//    @JDropdown(root = "//div[contains(@class, 'col-12')][1]//div[@role='combobox']", value = "input",
//            list = ".v-list-item__title", expand = ".v-input__append-inner")
    @UI("//div[contains(@class, 'col-12')][1]//div[@role='combobox']")
    public static MultiSelector outlinedDenseCombobox;

    @JDropdown(root = "//div[contains(@class, 'col-12')][2]//div[@role='combobox']", value = "input",
            list = ".v-list-item__title", expand = ".v-input__append-inner")
    public static MultiSelector denseCombobox;

    @JDropdown(root = "//div[contains(@class, 'col-12')][3]//div[@role='combobox']", value = "input",
            list = ".v-list-item__title", expand = ".v-input__append-inner")
    public static MultiSelector filledDenseCombobox;

    @UI("//div[contains(@class, 'v-card')][1]//button[@type='button']")
    public static Button filterEditButton;

    @UI("//div[@class='container'][2]//div[contains(@class, 'v-card')]//div[@class='v-text-field__slot']/input")
    public static TextField filterName;

    @JDropdown(root = "//div[@class='v-card__text'][1]//div[@role='combobox']", value = "input",
            list = ".v-list-item__title", expand = ".v-input__append-inner")
    public static Dropdown filterStateDropdown;
}
