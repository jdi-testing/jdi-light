package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ButtonWithTooltip;

public class TooltipFrame extends Section {

    @UI(".MuiIconButton-root[1]")
    public ButtonWithTooltip buttonWithTooltip;

}
