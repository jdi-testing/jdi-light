package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonAssert extends UIAssert<ButtonAssert, MaterialButton> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public ButtonAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
}
