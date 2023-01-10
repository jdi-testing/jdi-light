package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.TooltipAssert;
import org.openqa.selenium.By;

/**
 * Represents tooltip MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/tooltips/">Tooltip MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Tooltip extends UIBaseElement<TooltipAssert> {

    /**
     * Locator for tooltip element.
     */
    public static final By TOOLTIP_PLACEHOLDER_LOCATOR = By.xpath(".//*[contains(@class,'MuiTooltip-tooltip')]");

    /**
     * Gets the text of this tooltip.
     *
     * @return text of this tooltip as {@link String}
     */
    @JDIAction("Get value of '{name}'")
    public String getValue() {
        return core().find(TOOLTIP_PLACEHOLDER_LOCATOR).getText();
    }

    /**
     * Gets the content of this tooltip.
     *
     * @return text of this tooltip as {@link UIElement}
     */
    @JDIAction("Get value of '{name}'")
    public UIElement getContent() {
        return find(TOOLTIP_PLACEHOLDER_LOCATOR);
    }

    @Override
    public TooltipAssert is() {
        return new TooltipAssert().set(this);
    }

    /**
     * Checks if tooltip is interactive or not. Interactive tooltip doesn't close when the user hovers over it.
     *
     * @return {@code true} if this tooltip interactive, otherwise {@code false}
     * @see <a href="https://mui.com/components/tooltips/#interactive">Interactive tooltips</a>
     */
    @JDIAction("Check that '{name}' is interactive")
    public boolean isInteractive() {
        return core().hasClass("MuiTooltip-popperInteractive");
    }
}
