package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.vuetify.annotations.JAutocomplete;
import com.epam.jdi.light.vuetify.elements.complex.autocomplete.Autocomplete;

public class AutocompletesPage extends VuetifyPage {
//    @JDropdown(root = "//div[contains(@class, 'col-12')][1]//div[@role='combobox']", value = "input",
//            list = ".v-list-item__title", expand = ".v-input__append-inner")
    @JAutocomplete(combobox = "//div[contains(@class, 'col-12')][1]//div[@role='combobox']",
            listItems = "//div[contains(@class, 'v-autocomplete__content')][2]//div[@class='v-list-item__title']")
    public static Autocomplete outlinedDenseCombobox;

    @UI("//div[contains(@class, 'col-12')][2]//div[@role='combobox']")
    public static Autocomplete denseCombobox;

    @UI("//div[contains(@class, 'col-12')][3]//div[@role='combobox']")
    public static Autocomplete filledDenseCombobox;

    @UI("//div[contains(@class, 'v-card')][1]//button[@type='button']")
    public static Button filterEditButton;

    @UI("//div[@class='container'][2]//div[contains(@class, 'v-card')]//div[@class='v-text-field__slot']/input")
    public static TextField filterName;

    @JAutocomplete(combobox = "//div[@class='v-card__text'][1]//div[@role='combobox']",
            listItems = "//div[contains(@class, 'v-autocomplete__content')][2]//div[@class='v-list-item__title']")
    public static Autocomplete filterStateDropdown;
}
