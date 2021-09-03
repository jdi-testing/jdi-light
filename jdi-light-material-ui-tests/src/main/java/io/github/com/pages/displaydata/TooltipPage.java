package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;

public class TooltipPage extends WebPage {

    @UI("//*[contains(@class, 'MuiIconButton-root')]")
    public static MaterialButton deleteButtonWithTooltip;

    @UI("(//button[contains(@title, 'Add')])[1]")
    public static MaterialButton addButtonWithTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[1]")
    public static MaterialButton buttonWithLightTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[2]")
    public static MaterialButton buttonWithBootstrapTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[3]")
    public static MaterialButton buttonWithHtmlTooltip;

    @UI("//div[@id='touchItem']/button")
    public static MaterialButton hoverOrTouchButtonWithTooltip;

    @UI("//div[@id='hoverItem']/button")
    public static MaterialButton hoverButtonWithTooltip;

    @UI("//div[@id='clickItem']/*/button")
    public static MaterialButton clickButtonWithTooltip;

    @UI("#disabledBtn")
    public static MaterialButton disabledButtonWithTooltip;

}
