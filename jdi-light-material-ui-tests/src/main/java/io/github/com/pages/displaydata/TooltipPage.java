package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Button;

public class TooltipPage extends WebPage {

    @UI("//*[contains(@class, 'MuiIconButton-root')]")
    public static Button deleteButtonWithTooltip;

    @UI("(//button[contains(@title, 'Add')])[1]")
    public static Button addButtonWithTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[1]")
    public static Button buttonWithLightTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[2]")
    public static Button buttonWithBootstrapTooltip;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::button[3]")
    public static Button buttonWithHtmlTooltip;

    @UI("//div[@id='touchItem']/button")
    public static Button hoverOrTouchButtonWithTooltip;

    @UI("//div[@id='hoverItem']/button")
    public static Button hoverButtonWithTooltip;

    @UI("//div[@id='clickItem']/*/button")
    public static Button clickButtonWithTooltip;

    @UI("#disabledBtn")
    public static Button disabledButtonWithTooltip;

}
