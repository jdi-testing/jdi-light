package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ButtonWithTooltip;

public class TooltipPage extends WebPage {

    @UI("//*[contains(@class, 'MuiIconButton-root')]")
    public static ButtonWithTooltip deleteButtonWithTooltip;

    @UI("(//button[contains(@title, 'Add')])[1]")
    public static ButtonWithTooltip addButtonWithTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[1]")
    public static ButtonWithTooltip buttonWithLightTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[2]")
    public static ButtonWithTooltip buttonWithBootstrapTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[3]")
    public static ButtonWithTooltip buttonWithHtmlTooltip;

    @UI("//div[@id='touchItem']/button")
    public static ButtonWithTooltip hoverOrTouchButtonWithTooltip;

    @UI("//div[@id='hoverItem']/button")
    public static ButtonWithTooltip hoverButtonWithTooltip;

    @UI("//div[@id='clickItem']/*/button")
    public static ButtonWithTooltip clickButtonWithTooltip;

    @UI("#disabledBtn")
    public static ButtonWithTooltip disabledButtonWithTooltip;

}
