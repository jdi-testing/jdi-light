package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.ExpansionPanel;

public class ExpansionPanelsPage extends VuetifyPage {

    @UI("#AccordionExpansionPanel .v-expansion-panel")
    public static JList<ExpansionPanel> accordionExpansionPanels;

    @UI("#DisabledExpansionPanel div.v-input__slot")
    public static Checkbox disableCheckbox;

    @UI("#DisabledExpansionPanel .v-expansion-panel")
    public static JList<ExpansionPanel> disabledExpansionPanels;

    @UI("#FocusableExpansionPanel .v-expansion-panel")
    public static JList<ExpansionPanel> focusableExpansionPanels;

    @UI("#InsetExpansionPanel .v-expansion-panel")
    public static JList<ExpansionPanel> insetExpansionPanels;

    @UI("//*[@id='ModelExpansionPanel']/div/button[1]")
    public static Button allButton;

    @UI("//*[@id='ModelExpansionPanel']/div[1]/div[1]")
    public static Label openPanelText;

    @UI("//*[@id='ModelExpansionPanel']/div/button[2]")
    public static Button noneButton;

    @UI("#ModelExpansionPanel .v-expansion-panel")
    public static JList<ExpansionPanel> modelExpansionPanels;

    @UI("#PopoutExpansionPanel .v-expansion-panel")
    public static JList<ExpansionPanel> popOutExpansionPanels;

    @UI("#ReadonlyExpansionPanel div.v-input__slot")
    public static Checkbox readOnlyCheckbox;

    @UI("#ReadonlyExpansionPanel .v-expansion-panel")
    public static JList<ExpansionPanel> readOnlyExpansionPanels;

    @UI("#AdvancedExpansionPanel .v-expansion-panel")
    public static JList<ExpansionPanel> advancedExpansionPanels;

    @UI("//*[@id='CustomIconExpansionPanel']/div[1]/.//*[@class='v-expansion-panel']")
    public static JList<ExpansionPanel> customIconExpansionPanelsSameIcons;

    @UI("//*[@id='CustomIconExpansionPanel']/div[2]/.//*[@class='v-expansion-panel']")
    public static JList<ExpansionPanel> customIconExpansionPanelsDifferentIcons;

}
