package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class Accordion extends Dropdown implements CanBeDisabled {

    @UI("//div[@class='MuiAccordionSummary-content']//p[1]")
    protected Text firstHeaderText;
    @UI("//div[@class='MuiAccordionSummary-content']//p[2]")
    protected Text secondHeaderText;

    @JDIAction("Get '{name}'s first header")
    public Text firstHeaderText() {
        return firstHeaderText;
    }

    @JDIAction("Get '{name}'s second header")
    public Text secondHeaderText() {
        return secondHeaderText;
    }
}
