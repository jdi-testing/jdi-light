package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.elements.surfaces.Accordion;

public class ControlledAccordion extends Accordion {

    @JDIAction("Get '{name}'s first header text")
    public UIElement firstHeaderText() {
        return core().find("//div[@class='MuiAccordionSummary-content']//p[1]");
    }

    @JDIAction("Get '{name}'s second header text")
    public UIElement secondHeaderText() {
        return core().find("//div[@class='MuiAccordionSummary-content']//p[2]");
    }
}
