package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.utils.PopoverAssert;
import org.openqa.selenium.Keys;

/**
 * Represent popover MUI component on GUI. A Popover can be used to display some content on top of another.
 *
 * @see <a href="https://v4.mui.com/components/popover/">popover MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Popover extends UIBaseElement<PopoverAssert> implements IsText {

    /**
     * Closes this popover.
     */
    @JDIAction("Close {name}")
    public void close() {
        core().actions(a -> a.sendKeys(Keys.ESCAPE));
    }

    @Override
    public PopoverAssert is() {
        return new PopoverAssert().set(this);
    }
}
