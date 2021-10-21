package io.github.com.pages;

import com.epam.jdi.light.vuetify.annotations.JDICombobox;
import com.epam.jdi.light.vuetify.elements.complex.AdvancedCombobox;
import com.epam.jdi.light.vuetify.elements.complex.Combobox;

public class ComboboxPage extends VuetifyPage {

    @JDICombobox(
            root = "#DenseCombobox div[role ='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]//div[@class='v-list-item__title']")
    public static Combobox denseCombobox;

    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][1]//div[@role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][1]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleStringCombobox;

    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][2]//div[@role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][2]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleChipsCombobox;

    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][3]//div[@role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][3]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleScopedCombobox;

    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][4]//div[@role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][4]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleReadOnlyCombobox;

    @JDICombobox(
            root = "#NoDataWithChipsCombobox div[role ='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox noDataWithChipsCombobox;

    @JDICombobox(
            root = "//div[@id = 'AdvancedCustomOptionsCombobox']//div[@role = 'combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//span[@class='v-chip__content']")
    public static AdvancedCombobox advancedCustomOptionsCombobox;
}
