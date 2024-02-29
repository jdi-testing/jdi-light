package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.navigation.LinkAssert;
import com.epam.jdi.light.material.interfaces.displaydata.HasIcon;
import com.epam.jdi.light.material.interfaces.displaydata.StyledText;

/**
 * Represents link MUI component on GUI.
 *
 * @see <a href="https://v4.mui.com/components/links/">Link MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Link extends UIBaseElement<LinkAssert> implements IsText, StyledText, HasClick, HasIcon {

    /**
     * Checks if the link is underlined or not.
     *
     * @return {@code true} if the link is underlined, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is underlined")
    public boolean isUnderlined() {
        return core().css("text-decoration-line").equals("underline");
    }

    /**
     * Checks if the link is underlined or not.
     *
     * @return {@code true} if the link is not underlined, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is not underlined")
    public boolean isNotUnderlined() {
        return !isUnderlined();
    }

    @Override
    public LinkAssert is() {
        return new LinkAssert().set(this);
    }
}
