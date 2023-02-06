package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanels;
import io.github.com.custom.panels.AdvancedExpansionPanels;

public class ExpansionPanelsPage extends VuetifyPage {

    //Default locators(except root):
    @UI("#ModelExpansionPanel .v-expansion-panels")
    public static ExpansionPanels modelExpansionPanels;

    @UI("#AccordionExpansionPanel .v-expansion-panels")
    public static ExpansionPanels accordionExpansionPanels;

    @UI("#DisabledExpansionPanel .v-input")
    public static Checkbox disableCheckbox;

    @UI("#DisabledExpansionPanel .v-expansion-panels")
    public static ExpansionPanels disabledExpansionPanels;

    @UI("#FocusableExpansionPanel.v-expansion-panels")
    public static ExpansionPanels focusableExpansionPanels;

    @UI("#InsetExpansionPanel .v-expansion-panels")
    public static ExpansionPanels insetExpansionPanels;

    @UI("#PopoutExpansionPanel .v-expansion-panels")
    public static ExpansionPanels popOutExpansionPanels;

    @UI("#ReadonlyExpansionPanel div.v-input")
    public static Checkbox readOnlyCheckbox;

    @UI("#ReadonlyExpansionPanel .v-expansion-panels")
    public static ExpansionPanels readOnlyExpansionPanels;

    @UI("#AdvancedExpansionPanel.v-expansion-panels")
    public static AdvancedExpansionPanels advancedExpansionPanels;

    @UI("#CustomIconExpansionPanel .v-expansion-panels:nth-child(2)")
    public static ExpansionPanels customIconExpansionPanelsDifferentIcons;

    @UI("#FlatExpansionPanel .v-expansion-panels")
    public static ExpansionPanels flatExpansionPanels;

    @UI("#TileExpansionPanel .v-expansion-panels")
    public static ExpansionPanels tileExpansionPanels;
}
