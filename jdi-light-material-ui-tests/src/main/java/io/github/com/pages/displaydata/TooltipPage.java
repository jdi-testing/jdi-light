package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.TooltipButton;

public class TooltipPage extends WebPage {

    @UI("//*[contains(@class, 'MuiIconButton-root')]")
    public static TooltipButton deleteButtonWithTooltip;

    @UI("(//button[contains(@title, 'Add')])[1]")
    public static TooltipButton addButtonWithTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[1]")
    public static TooltipButton buttonWithLightTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[2]")
    public static TooltipButton buttonWithBootstrapTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[3]")
    public static TooltipButton buttonWithHtmlTooltip;

    @UI("//div[@id='touchItem']/button")
    public static TooltipButton hoverOrTouchButtonWithTooltip;

    @UI("//div[@id='hoverItem']/button")
    public static TooltipButton hoverButtonWithTooltip;

    @UI("//div[@id='clickItem']/*/button")
    public static TooltipButton clickButtonWithTooltip;

    @UI("#disabledBtn")
    public static TooltipButton disabledButtonWithTooltip;

}
