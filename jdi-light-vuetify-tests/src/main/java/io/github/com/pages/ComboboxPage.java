package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Combobox;

public class ComboboxPage extends VuetifyPage {

    @UI("#DenseCombobox div[role = 'combobox']")
    public static Combobox denseCombobox;

    @UI("#MultipleCombobox div[role = 'combobox']")
    public static Combobox multipleCombobox;

    @UI("#NoDataWithChipsCombobox div[role = 'combobox']")
    public static Combobox noDataWithChipsCombobox;

    @UI("#AdvancedCustomOptionsCombobox div[role = 'combobox']")
    public static Combobox advancedCustomOptionsCombobox;
}
