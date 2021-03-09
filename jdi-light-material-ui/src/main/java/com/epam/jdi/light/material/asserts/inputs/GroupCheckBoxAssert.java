package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.GroupCheckbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GroupCheckBoxAssert extends UIAssert<GroupCheckBoxAssert, GroupCheckbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public GroupCheckBoxAssert enabled(int index) {
        jdiAssert(element().isCheckBoxEnabled(index), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public GroupCheckBoxAssert disabled(int index) {
        jdiAssert(element().isCheckBoxDisabled(index), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public GroupCheckBoxAssert checked(int index) {
        jdiAssert(element().isCheckboxChecked(index), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public GroupCheckBoxAssert unchecked(int index) {
        jdiAssert(element().isCheckboxUnchecked(index), Matchers.is(true));
        return this;
    }
}
