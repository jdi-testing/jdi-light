package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.common.Tooltip;
import com.epam.jdi.light.angular.elements.complex.MaterialSelector;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class TooltipSection extends Section {

    /* Basic tooltip */
    @UI("//tooltip-overview-example/button")
    public Button basicTooltipButton;

    /* Tooltip with a custom position */

    @UI("#mat-select-17")
    public MaterialSelector positionTooltipSelector;

    @UI("//tooltip-position-example/button")
    public Button positionTooltipButton;

    /* Red tooltip */
    @UI("//tooltip-custom-class-example/button")
    public Button colorTooltipButton;

    /* Tooltip with a show and hide delay */
    @UI("#mat-input-78")
    public TextField showDelayInput;

    @UI("#mat-input-79")
    public TextField hideDelayInput;

    @UI("//tooltip-delay-example/button")
    public Button delayTooltipButton;

    /* Tooltip that can be disabled */
    @UI("#mat-checkbox-23")
    public Checkbox disabledCheckbox;

    @UI("//tooltip-disabled-example/button")
    public Button disabledTooltipButton;

    /* Tooltip that can be manually shown/hidden */
    @UI("//tooltip-manual-example/div/button[1]")
    public Button showTooltipButton;

    @UI("//tooltip-manual-example/div/button[2]")
    public Button hideTooltipButton;

    @UI("//tooltip-manual-example/div/button[3]")
    public Button toggleTooltipButton;

    /* Tooltip with a changing message */
    @UI("#mat-input-80")
    public TextField changeMessageTooltipTextField;

    @UI("//tooltip-message-example/button")
    public Button changeMessageTooltipButton;

    /* Tooltip that demonstrates auto-hiding */
    @UI("//tooltip-auto-hide-example/div")
    public UIElement autoHideTooltipContainer;

    @UI("//tooltip-auto-hide-example//button")
    public Button autoHideTooltipButton;

    public Tooltip tooltip;
}
