package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.surfaces.PaperAssert;

/**
 * Represents paper MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/paper/">Paper MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Paper extends UIBaseElement<PaperAssert> {

    @Override
    public PaperAssert is() {
        return new PaperAssert().set(this);
    }
}
