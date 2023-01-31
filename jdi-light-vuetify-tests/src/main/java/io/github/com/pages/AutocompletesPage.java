package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.annotations.JAutocomplete;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.complex.Autocomplete;

public class AutocompletesPage extends VuetifyPage {

    @JAutocomplete(root = "//div[@id='style']/div[2]//div[2]/div[contains(@class, 'v-autocomplete')]",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[@class='v-list-item__title']")
    public static Autocomplete lightDenseShapedOutlinedAutocomplete;

    @JAutocomplete(root = "//div[@id='style']/div[2]//div[3]/div[contains(@class, 'v-autocomplete')]",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[@class='v-list-item__title']")
    public static Autocomplete lightDenseFilledRoundedAutocomplete;

    @JAutocomplete(root = "//div[@id='style']/div[3]//div[4]/div[contains(@class, 'v-autocomplete')]",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[@class='v-list-item__title']")
    public static Autocomplete darkSoloAutocomplete;

    @JAutocomplete(root = "//div[@id='style']/div[3]//div[5]/div[contains(@class, 'v-autocomplete')]",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[@class='v-list-item__title']")
    public static Autocomplete darkSoloInvertedAutocomplete;

    @JAutocomplete(root = "//div[@id='functionality']//div[1]/div[contains(@class, 'v-autocomplete')]",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[@class='v-list-item__title']")
    public static Autocomplete disabledAutocomplete;

    @JAutocomplete(root = "//div[@id='functionality']//div[2]/div[contains(@class, 'v-autocomplete')]",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[@class='v-list-item__title']")
    public static Autocomplete clearableAutocomplete;

    @JAutocomplete(root = "//div[@id='functionality']//div[3]/div[contains(@class, 'v-autocomplete')]",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[contains(@class,'v-list-item')]")
    public static Autocomplete autoselectAutocomplete;

    @UI("#filter .v-btn--round")
    public static Button filterEditButton;

    @UI("#filter .v-input")
    public static Input filterName;

    @JAutocomplete(
            root = "#filter .v-autocomplete",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[@class='v-list-item__title']"
    )
    public static Autocomplete filterStateAutocomplete;

    @UI("#filter .v-btn.success")
    public static Button filterSaveButton;

    @JAutocomplete(root = "#slots .v-autocomplete",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[contains(@class,'v-list-item')]")
    public static Autocomplete selectAutocomplete;

    @JAutocomplete(root = "#api .v-autocomplete",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[contains(@class,'v-list-item')]")
    public static Autocomplete publicApiAutocomplete;

    @UI("#api .v-list-item__title")
    public static Text selectedApiName;

    @UI("//span[text()[contains(.,'Clear')]]")
    public static Button clearApiButton;

    @JAutocomplete(root = "#async .v-autocomplete",
            listItems = "//div[contains(@class, 'v-autocomplete__content') and not(contains(@style, 'display'))]//div[contains(@class,'v-list-item')]")
    public static Autocomplete asynchronousItemsAutocomplete;
}
