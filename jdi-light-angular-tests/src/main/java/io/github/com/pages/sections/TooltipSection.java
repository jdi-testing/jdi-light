package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.common.Tooltip;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class TooltipSection extends Section {

    /* Basic tooltip */
    @UI("//tooltip-overview-example/button")
    public static Button basicTooltipButton;

    /* Tooltip with a custom position */
    @UI("//tooltip-position-example//mat-select")
    public static com.epam.jdi.light.elements.common.uiElement positionTooltipSelector;

    @UI("//tooltip-position-example/button")
    public static Button positionTooltipButton;

    /* Red tooltip */
    @UI("//tooltip-custom-class-example/button")
    public static Button colorTooltipButton;

    /* Tooltip with a show and hide delay */
    @UI("//tooltip-delay-example/mat-form-field[1]//input")
    public static TextField showDelayInput;

    @UI("//tooltip-delay-example/mat-form-field[2]//input")
    public static TextField hideDelayInput;

    @UI("//tooltip-delay-example/button")
    public static Button delayTooltipButton;

    /* Tooltip that can be disabled */
    @UI("//tooltip-disabled-example//input")
    public static Checkbox disabledCheckbox;

    @UI("//tooltip-disabled-example/button")
    public static Button disabledTooltipButton;

    /* Tooltip that can be manually shown/hidden */
    @UI("//tooltip-manual-example/div/button[1]")
    public static Button showTooltipButton;

    @UI("//tooltip-manual-example/div/button[2]")
    public static Button hideTooltipButton;

    @UI("//tooltip-manual-example/div/button[3]")
    public static Button toggleTooltipButton;

    /* Tooltip with a changing message */
    @UI("//tooltip-message-example//input")
    public static TextField changeMessageTooltipTextField;

    @UI("//tooltip-message-example/button")
    public static Button changeMessageTooltipButton;

    /* Tooltip that demonstrates auto-hiding */
    @UI("//tooltip-auto-hide-example/div")
    public static com.epam.jdi.light.elements.common.uiElement autoHideTooltipContainer;

    @UI("//tooltip-auto-hide-example//button")
    public static Button autoHideTooltipButton;

    @UI(".mat-tooltip")
    public static Tooltip tooltip;
}
