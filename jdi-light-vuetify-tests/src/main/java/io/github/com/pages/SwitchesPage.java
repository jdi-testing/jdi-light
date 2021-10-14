package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.Switch;

import java.util.List;

public class SwitchesPage extends VuetifyPage {

    @UI("#ColorsSwitch .v-input--switch")
    public static List<Switch> colorSwitches;

    @UI("#FlatSwitch .v-input--switch")
    public static List<Switch> flatSwitches;

    @UI("#InsetSwitch .v-input--switch")
    public static List<Switch> insetSwitches;

    @UI("#ModelAsArraySwitch .v-input--switch")
    public static List<Switch> modelAsArraySwitches;

    @UI("#ModelAsArraySwitch > p")
    public static Text modelArray;

    @UI("#ModelAsBooleanSwitch .v-input--switch")
    public static List<Switch> modelAsBooleanSwitches;

    @UI("#StatesSwitch .v-input--switch")
    public static List<Switch> statesSwitches;

    @UI("#LabelSwitch .v-input--switch")
    public static List<Switch> labelSwitches;

}
