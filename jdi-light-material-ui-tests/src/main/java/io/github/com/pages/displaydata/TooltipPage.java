package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ButtonWithTooltip;

public class TooltipPage extends WebPage {

    @UI("//*[contains(@class, 'MuiIconButton-root')]")
    public ButtonWithTooltip buttonWithTooltip;

}
