package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.GroupCheckbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GroupCheckBoxAssert extends UIAssert<GroupCheckBoxAssert, GroupCheckbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public GroupCheckBoxAssert enabled() {
        jdiAssert(element().isCheckBoxEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public GroupCheckBoxAssert checked() {
        jdiAssert(element().isCheckBoxChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public GroupCheckBoxAssert unchecked() {
        jdiAssert(element().isCheckBoxUnchecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public GroupCheckBoxAssert disabled() {
        jdiAssert(element().isCheckBoxDisabled(), Matchers.is(true));
        return this;
    }
}
