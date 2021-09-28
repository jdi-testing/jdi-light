package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.ExpansionPanels;

public class ExpansionPanelsPage extends VuetifyPage {

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

    @UI("#ModelExpansionPanel button.v-btn:first-child")
    public static Button allButton;

    @UI("//div[@class='text-center d-flex pb-4']/div")
    public static Label openPanelText;

    @UI("#ModelExpansionPanel button.v-btn:last-child")
    public static Button noneButton;

    @UI("#ModelExpansionPanel .v-expansion-panels")
    public static ExpansionPanels modelExpansionPanels;

    @UI("#PopoutExpansionPanel .v-expansion-panels")
    public static ExpansionPanels popOutExpansionPanels;

    @UI("#ReadonlyExpansionPanel div.v-input")
    public static Checkbox readOnlyCheckbox;

    @UI("#ReadonlyExpansionPanel .v-expansion-panels")
    public static ExpansionPanels readOnlyExpansionPanels;

    @UI("#AdvancedExpansionPanel.v-expansion-panels")
    public static ExpansionPanels advancedExpansionPanels;

    @UI("#CustomIconExpansionPanel .v-expansion-panels:nth-child(1)")
    public static ExpansionPanels customIconExpansionPanelsSameIcons;

    @UI("#CustomIconExpansionPanel .v-expansion-panels:nth-child(2)")
    public static ExpansionPanels customIconExpansionPanelsDifferentIcons;

}
