package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.displaydata.AvatarAssert;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonAssert extends UIAssert<ButtonAssert, Button> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public ButtonAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public ButtonAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public ButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has attribute")
    @Override
    public ButtonAssert attr(String attrName) {
        jdiAssert(element().hasAttribute(attrName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not visible")
    @Override
    public ButtonAssert notVisible() {
        jdiAssert(element().isNotVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has {className}")
    public ButtonAssert hasClass(String className){
        jdiAssert(element().hasClass(className), Matchers.is(true));
        return this;
    }
}
