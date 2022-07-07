package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch> {

    @JDIAction("Assert that '{name}' is checked")
    public SwitchAssert checked() {
        jdiAssert(element().isChecked() ? "is checked"
                : "isn't checked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public SwitchAssert unchecked() {
        jdiAssert(element().isNotChecked() ? "is unchecked"
                : "isn't unchecked", Matchers.is("is unchecked"));
        return this;
    }
}
