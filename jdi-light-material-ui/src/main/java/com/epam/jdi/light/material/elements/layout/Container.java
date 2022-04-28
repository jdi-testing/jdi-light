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
     * Prop fixed is used to design a fixed set of sizes instead of trying to accommodate a fully fluid viewport.
     *
     * @return {@code true} if the container has fixed width, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has fixed width or not")
    public boolean isFixed() {
        return core().hasClass(".MuiContainer-isFixed");
    }

    /**
     * A fluid container width is bounded by the max width value.
     *
     * @return {@code true} if the container has fluid width, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has fluid width or not")
    public boolean isFluid() {
        return !isFixed();
    }

    /**
     * {@link Container} width is measured in pixels.
     *
     * @return max width as {@link int}
     */
    @JDIAction("Get max width of '{name}'")
    public int maxWidth() {
        String maxWidth = css("max-width");
        return Integer.parseInt(maxWidth.substring(0, maxWidth.indexOf("px")));
    }

    @Override
    public ContainerAssert is() {
        return new ContainerAssert().set(this);
    }
}
