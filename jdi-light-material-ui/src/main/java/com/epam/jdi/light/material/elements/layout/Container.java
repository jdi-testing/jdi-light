package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layout.ContainerAssert;

/**
 * Represents container MUI component on GUI.
 * The container centers content horizontally.
 * While containers can be nested, most layouts do not require a nested container.
 *
 * @see <a href="https://mui.com/components/container/">Container MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Container extends UIBaseElement<ContainerAssert> {

    /**
     * Checks that {@link Container} has fixed width.
     * Prop fixed is used to design a fixed set of sizes instead of trying to accommodate a fully fluid viewport.
     *
     * @return {@link String} contains "-fixed".
     */
    @JDIAction("Check if '{name}' width is fixed")
    public boolean fixed() {
        return String.join("", classes()).contains("-fixed");
    }

    /**
     * Checks that {@link Container} has fluid width.
     * A fluid container width is bounded by the maxWidth prop value.
     *
     * @return calls a method fixed() with an opposite result
     */
    @JDIAction("Check if '{name}' width is fluid")
    public boolean fluid() {
        return !fixed();
    }

    /**
     * Gets prop max width of {@link Container}.
     * {@link Container} width is measured in pixels.
     *
     * @return {@link Container} max width in {@link Integer}
     */
    @JDIAction("Get max width of '{name}'")
    public int getMaxWidth() {
        String maxWidth = css("max-width");
        return Integer.parseInt(maxWidth.substring(0, maxWidth.indexOf("px")));
    }

    @Override
    public ContainerAssert is() {
        return new ContainerAssert().set(this);
    }
}
