package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.annotations.JDIExpansionPanels;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanels;

public class ExpansionPanelsPage extends VuetifyPage {

    //Default locators(except root):
    @JDIExpansionPanels(
            root = "#ModelExpansionPanel .v-expansion-panels",
            panels = ".v-expansion-panel",
            header = ".v-expansion-panel-header",
            icon = ".v-expansion-panel-header__icon",
            content = ".v-expansion-panel-content",
            wrapper = ".v-expansion-panel-content__wrap"
    )
    public static ExpansionPanels modelExpansionPanels;

    @JDIExpansionPanels(
            root = "#AccordionExpansionPanel .v-expansion-panels",
            icon = ".v-expansion-panel-header__icon .v-icon"
            //We changed default locator for icon because tests of icons are required icon class from icon's section
    )
    public static ExpansionPanels accordionExpansionPanels;

    @UI("#DisabledExpansionPanel .v-input")
    public static Checkbox disableCheckbox;

    @JDIExpansionPanels(root = "#DisabledExpansionPanel .v-expansion-panels")
    public static ExpansionPanels disabledExpansionPanels;

    @JDIExpansionPanels(
            root = "#FocusableExpansionPanel.v-expansion-panels",
            icon = ".v-expansion-panel-header__icon .v-icon"
    )
    public static ExpansionPanels focusableExpansionPanels;

    @JDIExpansionPanels(
            root = "#InsetExpansionPanel .v-expansion-panels",
            icon = ".v-expansion-panel-header__icon .v-icon"
    )
    public static ExpansionPanels insetExpansionPanels;

    @UI("#ModelExpansionPanel button.v-btn:first-child")
    public static Button allButton;

    @UI("//div[@class='text-center d-flex pb-4']/div")
    public static Label openPanelText;

    @UI("#ModelExpansionPanel button.v-btn:last-child")
    public static Button noneButton;

    @JDIExpansionPanels(
            root = "#PopoutExpansionPanel .v-expansion-panels",
            icon = ".v-expansion-panel-header__icon .v-icon"
    )
    public static ExpansionPanels popOutExpansionPanels;

    @UI("#ReadonlyExpansionPanel div.v-input")
    public static Checkbox readOnlyCheckbox;

    @JDIExpansionPanels(root = "#ReadonlyExpansionPanel .v-expansion-panels")
    public static ExpansionPanels readOnlyExpansionPanels;

    @JDIExpansionPanels(root = "#AdvancedExpansionPanel.v-expansion-panels")
    public static ExpansionPanels advancedExpansionPanels;

    @JDIExpansionPanels(
            root = "#CustomIconExpansionPanel .v-expansion-panels:nth-child(1)",
            icon = ".v-expansion-panel-header__icon .v-icon"
    )
    public static ExpansionPanels customIconExpansionPanelsSameIcons;

    @JDIExpansionPanels(
            root = "#CustomIconExpansionPanel .v-expansion-panels:nth-child(2)",
            icon = ".v-expansion-panel-header__icon .v-icon"
    )
    public static ExpansionPanels customIconExpansionPanelsDifferentIcons;

}
