package com.epam.jdi.light.material.asserts.inputs.Buttons;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.inputs.Buttons.TextButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextButtonAssert extends UIAssert<TextButtonAssert, TextButton> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public TextButtonAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public TextButtonAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public TextButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public TextButtonAssert attr(String attrName) {
        jdiAssert(element().hasAttribute(attrName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public TextButtonAssert notVisible() {
        jdiAssert(element().isNotVisible(), Matchers.is(true));
        return this;
    }

}
