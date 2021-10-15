package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDICombobox;
import com.epam.jdi.light.vuetify.elements.complex.Combobox;

public class ComboboxPage extends VuetifyPage {

    @UI("#DenseCombobox div[role = 'combobox']")
    public static Combobox denseCombobox;

    //div[@id = 'DenseCombobox']//div[@role = 'combobox']

    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][2]//div[@role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][1]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleChipsCombobox;

    @JDICombobox(
            root = "//div[contains(@class, 'col-12')][2]//div[@role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][1]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox noDataWithChipsCombobox;
    //div[@id = 'MultipleCombobox']//div[@role = 'combobox']

    @UI("#AdvancedCustomOptionsCombobox div[role = 'combobox']")
    public static Combobox advancedCustomOptionsCombobox;
}
