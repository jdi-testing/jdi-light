package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.vuetify.annotations.JAutocomplete;
import com.epam.jdi.light.vuetify.elements.complex.Autocomplete;

public class AutocompletesPage extends VuetifyPage {
    @JAutocomplete(combobox = "//div[contains(@class, 'col-12')][1]//div[@role='combobox']",
            listItems = "//div[contains(@class, 'v-autocomplete__content')][2]//div[@class='v-list-item__title']")
    public static Autocomplete outlinedDenseAutocomplete;

    @JAutocomplete(combobox = "//div[contains(@class, 'col-12')][3]//div[@role='combobox']",
    listItems = "//div[contains(@class, 'v-autocomplete__content')][3]//div[@class='v-list-item__title']")
    public static Autocomplete filledDenseAutocomplete;

    @UI("//div[contains(@class, 'v-card')][1]//button[@type='button']")
    public static Button filterEditButton;

    @UI("//div[@class='container'][2]//div[contains(@class, 'v-card')]//div[@class='v-text-field__slot']/input")
    public static TextField filterName;

    @JAutocomplete(combobox = "//div[@class='v-card__text'][1]//div[@role='combobox']",
            listItems = "//div[contains(@class, 'v-autocomplete__content')][2]//div[@class='v-list-item__title']")
    public static Autocomplete filterStateAutocomplete;

    @UI("//span[text()[contains(.,'Save')]]")
    public static Button filterSaveButton;

    @JAutocomplete(combobox = "//div[@class='container'][3]//div[@role='combobox']",
            listItems = "//div[contains(@class, 'v-autocomplete__content')][4]//div[@class='v-list-item__title']")
    public static Autocomplete selectAutocomplete;

    @JAutocomplete(combobox = "//div[@class='container'][4]//div[@role='combobox']",
            listItems = "//div[contains(@class, 'v-autocomplete__content')][5]//div[@class='v-list-item__title']")
    public static Autocomplete publicApiAutocomplete;

    @UI("//div[text()='Daily cat facts']")
    public static Text selectedApiName;

    @UI("//span[text()[contains(.,'Clear')]]")
    public static Button clearApiButton;

    @JAutocomplete(combobox = "//div[@class='container'][5]//div[@role='combobox']",
            listItems = "//div[contains(@class, 'v-autocomplete__content')][6]//div[@class='v-list-item__title']")
    public static Autocomplete asynchronousItemsAutocomplete;
}
