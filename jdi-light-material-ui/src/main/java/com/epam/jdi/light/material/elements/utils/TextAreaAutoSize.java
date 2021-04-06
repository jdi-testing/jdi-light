package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.utils.TextAreaAutoSizeAssert;

public class TextAreaAutoSize extends UIBaseElement<TextAreaAutoSizeAssert> {

    @JDIAction("set value")
    public void setValue(String text) {
        core().setValue(text);
    }

    @JDIAction("set value")
    public void clear() {
        core().clear();
    }

    @Override
    public TextAreaAutoSizeAssert is() {
        return new TextAreaAutoSizeAssert().set(this);
    }

    @Override
    public TextAreaAutoSizeAssert has() {
        return this.is();
    }
}
