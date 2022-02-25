package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.TooltipButton;
import java.util.List;

public class TooltipPage extends WebPage {

    @UI("//h2[text()='Simple tooltips']/following-sibling::div[1]/button")
    public static List<TooltipButton> simpleTooltipsButton;

    @UI("//h2[contains(text(), 'Customizable tooltips')]/following::div[1]/button")
    public static List<TooltipButton> customizableTooltipsButton;

    @UI("//div[@id='touchItem']/button")
    public static TooltipButton hoverOrTouchButtonWithTooltip;

    @UI("//div[@id='hoverItem']/button")
    public static TooltipButton hoverButtonWithTooltip;

    @UI("//div[@id='clickItem']/*/button")
    public static TooltipButton clickButtonWithTooltip;

    @UI("#disabledBtn")
    public static TooltipButton disabledButtonWithTooltip;

    @UI("//div[@id='focusItem']/button")
    public static TooltipButton focusOrTouchButtonWithTooltip;

}
