package com.epam.jdi.light.material.asserts.inputs.Buttons;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Buttons.CustomizedButton;
import com.epam.jdi.light.material.elements.inputs.Buttons.IconButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CustomizedButtonAssert extends UIAssert<CustomizedButtonAssert, CustomizedButton> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public CustomizedButtonAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public CustomizedButtonAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public CustomizedButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has attribute")
    @Override
    public CustomizedButtonAssert attr(String attrName) {
        jdiAssert(element().hasAttribute(attrName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not visible")
    @Override
    public CustomizedButtonAssert notVisible() {
        jdiAssert(element().isNotVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} child contains svg")
    public CustomizedButtonAssert hasSvg(String className){
        jdiAssert(element().find("//*[name()='svg']").hasClass(className), Matchers.is(true));
        return this;
    }

}
