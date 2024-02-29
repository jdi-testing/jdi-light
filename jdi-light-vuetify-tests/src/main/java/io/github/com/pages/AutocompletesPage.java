package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.annotations.JAutocomplete;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.complex.Autocomplete;

public class AutocompletesPage extends VuetifyPage {

    // @todo #5298 Fix locators, they are not stable
    @UI("//div[@id='style']/div[2]//div[2]/div[contains(@class, 'v-autocomplete')]")
    public static Autocomplete lightDenseShapedOutlinedAutocomplete;

    @UI("//div[@id='style']/div[2]//div[3]/div[contains(@class, 'v-autocomplete')]")
    public static Autocomplete lightDenseFilledRoundedAutocomplete;

    @UI("//div[@id='style']/div[3]//div[4]/div[contains(@class, 'v-autocomplete')]")
    public static Autocomplete darkSoloAutocomplete;

    @UI("//div[@id='style']/div[3]//div[5]/div[contains(@class, 'v-autocomplete')]")
    public static Autocomplete darkSoloInvertedAutocomplete;

    @UI("//div[@id='functionality']//div[1]/div[contains(@class, 'v-autocomplete')]")
    public static Autocomplete disabledAutocomplete;

    @UI("//div[@id='functionality']//div[2]/div[contains(@class, 'v-autocomplete')]")
    public static Autocomplete clearableAutocomplete;

    @UI("//div[@id='functionality']//div[3]/div[contains(@class, 'v-autocomplete')]")
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

    // @todo #5298 List item should be located
    @UI("#api .v-list-item__title")
    public static Text selectedApiName;

    @UI("//span[text()[contains(.,'Clear')]]")
    public static Button clearApiButton;

    @UI("#async .v-autocomplete")
    public static Autocomplete asynchronousItemsAutocomplete;
}
