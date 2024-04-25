package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.complex.Autocomplete;

public class AutocompletesPage extends VuetifyPage {

    @UI("//h3[text()='Dense']//following::div[1]//div[contains(@class, 'v-autocomplete')][contains(@class, 'v-text-field--shaped')]")
    public static Autocomplete lightDenseShapedOutlinedAutocomplete;

    @UI("//h3[text()='Dense']//following::div[1]//div[contains(@class, 'v-autocomplete')][contains(@class, 'v-text-field--rounded')]")
    public static Autocomplete lightDenseFilledRoundedAutocomplete;

    @UI("//h3[text()='Dark']//following::div[1]//div[contains(@class, 'v-autocomplete')][contains(@class, 'v-text-field--solo')]")
    public static Autocomplete darkSoloAutocomplete;

    @UI("//h3[text()='Dark']//following::div[1]//div[contains(@class, 'v-autocomplete')][contains(@class, 'v-text-field--solo-inverted')]")
    public static Autocomplete darkSoloInvertedAutocomplete;

    @UI("//div[@id='functionality']//div[contains(@class, 'v-autocomplete')][contains(@class, 'v-input--is-disabled')]")
    public static Autocomplete disabledAutocomplete;

    @UI("(//div[@id='functionality']//div[contains(@class, 'v-autocomplete')])[2]")
    public static Autocomplete clearableAutocomplete;

    @UI("(//div[@id='functionality']//div[contains(@class, 'v-autocomplete')])[3]")
    public static Autocomplete autoselectAutocomplete;

    @UI("#filter .v-btn--round")
    public static Button filterEditButton;

    @UI("#filter .v-input")
    public static Input filterName;

    @UI("#filter .v-autocomplete")
    public static Autocomplete filterStateAutocomplete;

    @UI("#filter .v-btn.success")
    public static Button filterSaveButton;

    @UI("#slots .v-autocomplete")
    public static Autocomplete selectAutocomplete;

    @UI("#api .v-autocomplete")
    public static Autocomplete publicApiAutocomplete;

    @UI("#api .v-list-item__title")
    public static Text selectedApiName;

    @UI("//span[text()[contains(.,'Clear')]]")
    public static Button clearApiButton;

    @UI("#async .v-autocomplete")
    public static Autocomplete asynchronousItemsAutocomplete;
}
