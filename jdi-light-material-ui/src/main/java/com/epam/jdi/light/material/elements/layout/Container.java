package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.layout.ContainerAssert;

/**
 * Represents container MUI component on GUI.
 * <p>
 * The container centers content horizontally.
 * While containers can be nested, most layouts do not require a nested container.
 *
 * @see <a href="https://v4.mui.com/components/container/">Container MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */

public class Container extends UIBaseElement<ContainerAssert> implements IsText {

    /**
     * Checks that container is fixed.
     *
     * @return {@code true} if the container is fixed, otherwise {@code false}
     */
    @JDIAction("Check if '{name}' is fixed")
    public boolean isFixed() {
        return !core().classLike("-fixed").isEmpty();
    }

    /**
     * Checks that container is fluid.
     *
     * @return {@code true} if the container is fluid, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is fluid")
    public boolean isFluid() {
        return !isFixed();
    }

    /**
     * Gets max width of container.
     * {@link Container} width is measured in pixels.
     *
     * @return 'max-width' as {@code int}
     */
    @JDIAction("Get max width of '{name}'")
    public int maxWidth() {
        String maxWidth = core().css("max-width");
        return Integer.parseInt(maxWidth.replaceAll("\\D", ""));
    }

    @Override
    public ContainerAssert is() {
        return new ContainerAssert().set(this);
    }
}
