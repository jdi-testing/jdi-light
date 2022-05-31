package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layout.ContainerAssert;

/**
 * Represents container MUI component on GUI.
 * <p>
 * The container centers content horizontally.
 * While containers can be nested, most layouts do not require a nested container.
 *
 * @see <a href="https://mui.com/components/container/">Container MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */

public class Container extends UIBaseElement<ContainerAssert> {

    /**
     * Checks that container has fixed width or not.
     *
     * @return {@code true} if the container has fixed width, otherwise {@code false}
     */
    @JDIAction("Check if '{name}' width is fixed or not")
    public boolean isFixed() {
        return classes().stream().anyMatch(cl -> cl.contains("-fixed"));
    }

    /**
     * Checks that container has fluid width.
     *
     * @return {@code true} if the container has fluid width, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' width is fluid or not")
    public boolean isFluid() {
        return !isFixed();
    }

    /**
     * Gets max width of container.
     * {@link Container} width is measured in pixels.
     *
     * @return max width as {@code int}
     */
    @JDIAction("Get max width of '{name}'")
    public int maxWidth() {
        String maxWidth = css("max-width");
        return Integer.parseInt(maxWidth.replaceAll("\\D", ""));
    }

    @Override
    public ContainerAssert is() {
        return new ContainerAssert().set(this);
    }
}
