package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;

import java.util.List;

public class CheckboxesPage extends VuetifyPage {

    @UI(".col-sm-4 > .v-input--checkbox")
    public static List<Checkbox> colorsCheckboxes;

    @UI("#ModelArrayCheckboxes > .v-input--checkbox")
    public static List<Checkbox> modelAsArrayCheckboxes;

    @UI("#ModelArrayCheckboxes > p")
    public static Text modelArray;

    @UI("#ModelBooleanCheckboxes > .v-input--checkbox")
    public static List<Checkbox> modelBooleanCheckboxes;

    @UI("#StatesCheckboxes .v-input--checkbox")
    public static List<Checkbox> statesCheckboxes;

    @UI("#LabelSlotCheckboxes > .v-input--checkbox")
    public static Checkbox labelSlotCheckbox;

    @UI("#InlineTextFieldCheckboxes .v-input--checkbox")
    public static List<Checkbox> inlineTextFieldCheckboxes;
}
