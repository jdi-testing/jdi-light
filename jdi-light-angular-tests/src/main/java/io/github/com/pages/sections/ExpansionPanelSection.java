package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.ExpansionPanel;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class ExpansionPanelSection {

    @UI("#basic-expansion-panel")
    public static ExpansionPanel basicExpansionPanel;

    @UI("#accordion-expansion-panel")
    public static ExpansionPanel accordionExpansionPanel;
}
