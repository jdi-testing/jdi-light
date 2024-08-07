package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;

import java.util.List;

public class CheckboxesPage extends VuetifyPage {

    @UI(".col-sm-4 > .v-input--checkbox")
    @WaitAfterAction(1)
    public static List<VueCheckbox> colorsCheckboxes;

    @UI("#ModelArrayCheckboxes > .v-input--checkbox")
    @WaitAfterAction(1)
    public static List<VueCheckbox> modelAsArrayCheckboxes;

    @UI("#ModelArrayCheckboxes > p")
    public static Text modelArray;

    @UI("#ModelBooleanCheckboxes > .v-input--checkbox")
    @WaitAfterAction(1)
    public static List<VueCheckbox> modelBooleanCheckboxes;

    @UI("#StatesCheckboxes .v-input--checkbox")
    @WaitAfterAction(1)
    public static List<VueCheckbox> statesCheckboxes;

    @UI("#VariousAttributesCheckbox .v-input--checkbox")
    @WaitAfterAction(1)
    public static List<VueCheckbox> variousAttributesCheckboxes;
}
