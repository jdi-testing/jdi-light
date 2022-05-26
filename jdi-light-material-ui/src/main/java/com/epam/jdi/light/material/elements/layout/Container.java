package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layout.ContainerAssert;

/**
 * Represents Container MUI element on GUI
 *
 * <p>The container centers your content horizontally. It's the most basic layout element.</p>
 *
 * @see <a href="https://v4.mui.com/components/container/">Container MUI documentation</a>
 */

public class Container extends UIBaseElement<ContainerAssert> {

    /**
     * Checks whether Container is fixed or not
     *
     * @return {@code true} if Container is fixed
     */
    @JDIAction("Check if {name} is fixed")
    public boolean fixed() {
        return classes().stream().anyMatch(cl -> cl.contains("-fixed"));
    }

    /**
     * Checks whether Container is fluid or not
     *
     * @return {@code true} if Container is fluid
     */
    @JDIAction("Check if {name} width is fluid")
    public boolean fluid() {
        return !fixed();
    }

    /**
     * Get Container maximum width
     *
     * @return 'max-width' value as {@code int}
     */
    @JDIAction("Get max width of {name}")
    public int getMaxWidth() {
        String maxWidth = css("max-width");
        return Integer.parseInt(maxWidth.replaceAll("\\D", ""));
    }

    @Override
    public ContainerAssert is() {
        return new ContainerAssert().set(this);
    }
}
