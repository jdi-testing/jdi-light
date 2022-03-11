package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        jdiAssert(element().isChecked() ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public CheckboxAssert unchecked() {
        jdiAssert(element().isUnchecked() ? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }

    @JDIAction("Assert that '{name}' has color '{0}'")
    public CheckboxAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' label has position {0}")
    public CheckboxAssert labelPosition(Position position) {
        jdiAssert(element().labelPosition(), Matchers.is(position));
        return this;
    }

}
