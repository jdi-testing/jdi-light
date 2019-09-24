package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;

public interface HasBadge extends ICoreElement{
    /**
     * Gets badge
     * @return UIElement text
     */
    @JDIAction("Get '{name}' badge text")
    default UIElement badge() {
        return core().find(By.cssSelector(".badge"));
    }

    /**
     * Gets badge text
     * @return String text
     */
    @JDIAction("Get '{name}' badge text")
    default String badgeText() {
        return core().find(By.cssSelector(".badge")).getText();
    }

    /**
     * Gets badge value
     * @return String text
     */
    @JDIAction("Get '{name}' badge text")
    default String badgeValue() {
        return core().find(By.cssSelector(".badge")).getValue();
    }
}