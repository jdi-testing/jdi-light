package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.feedback.BackdropAssert;

public class Backdrop extends UIBaseElement<BackdropAssert> implements HasClick {

    @Override
    public BackdropAssert is() {
        return new BackdropAssert().set(this);
    }
}
