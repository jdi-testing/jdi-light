package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.feedback.BackdropAssert;

/**
 * Represents Backdrop MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/backdrop/">Backdrop MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Backdrop extends UIBaseElement<BackdropAssert> implements HasClick {

    @Override
    public BackdropAssert is() {
        return new BackdropAssert().set(this);
    }
}
