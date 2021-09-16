package com.epam.jdi.light.material.asserts.inputs;


import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SelectAssert extends DropdownAssert {
    private final String disabled = "Mui-disabled";

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public SelectAssert enabled() {
        jdiAssert(element().core().hasClass(disabled), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public SelectAssert disabled() {
        jdiAssert(element().core().hasClass(disabled), Matchers.is(true));
        return this;
    }
}
