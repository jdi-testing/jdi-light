package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.annotations.JDIExpansionPanels;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanels;
import io.github.com.custom.panels.AdvancedExpansionPanels;

public class ExpansionPanelsPage extends VuetifyPage {

    //Default locators(except root):
    @JDIExpansionPanels(
            root = "#ModelExpansionPanel .v-expansion-panels",
            panels = ".v-expansion-panel",
            header = ".v-expansion-panel-header",
            headerIcon = ".v-expansion-panel-header__icon",
            icon = ".v-expansion-panel-header__icon .v-icon",
            content = ".v-expansion-panel-content"
    )
    public static ExpansionPanels modelExpansionPanels;

    @JDIExpansionPanels(root = "#AccordionExpansionPanel .v-expansion-panels")
    public static ExpansionPanels accordionExpansionPanels;

    @UI("#DisabledExpansionPanel .v-input")
    public static Checkbox disableCheckbox;

    @JDIExpansionPanels(root = "#DisabledExpansionPanel .v-expansion-panels")
    public static ExpansionPanels disabledExpansionPanels;

    @JDIExpansionPanels(root = "#FocusableExpansionPanel.v-expansion-panels")
    public static ExpansionPanels focusableExpansionPanels;

    @JDIExpansionPanels(root = "#InsetExpansionPanel .v-expansion-panels")
    public static ExpansionPanels insetExpansionPanels;

    @JDIExpansionPanels(root = "#PopoutExpansionPanel .v-expansion-panels")
    public static ExpansionPanels popOutExpansionPanels;

    @UI("#ReadonlyExpansionPanel div.v-input")
    public static Checkbox readOnlyCheckbox;

    @JDIExpansionPanels(root = "#ReadonlyExpansionPanel .v-expansion-panels")
    public static ExpansionPanels readOnlyExpansionPanels;

    @JDIExpansionPanels(root = "#AdvancedExpansionPanel.v-expansion-panels")
    public static AdvancedExpansionPanels advancedExpansionPanels;

    @JDIExpansionPanels(root = "#CustomIconExpansionPanel .v-expansion-panels:nth-child(2)")
    public static ExpansionPanels customIconExpansionPanelsDifferentIcons;

    @JDIExpansionPanels(root = "#FlatExpansionPanel .v-expansion-panels")
    public static ExpansionPanels flatExpansionPanels;

    @JDIExpansionPanels(root = "#TileExpansionPanel .v-expansion-panels")
    public static ExpansionPanels tileExpansionPanels;
}
