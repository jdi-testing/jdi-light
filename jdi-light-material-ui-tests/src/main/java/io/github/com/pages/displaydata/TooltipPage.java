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

    @UI("#touchItem .MuiButton-root")
    public static TooltipButton hoverOrTouchButtonWithTooltip;

    @UI("#focusItem .MuiButton-root")
    public static TooltipButton focusOrTouchButtonWithTooltip;

    @UI("#hoverItem .MuiButton-root")
    public static TooltipButton hoverButtonWithTooltip;

    @UI("#clickItem .MuiButton-root")
    public static TooltipButton clickButtonWithTooltip;

    @UI("#disabledBtn")
    public static TooltipButton disabledButtonWithTooltip;

}
