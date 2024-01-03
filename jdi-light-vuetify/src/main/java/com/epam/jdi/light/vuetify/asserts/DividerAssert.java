package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OrientationAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DividerAssert extends UIAssert<DividerAssert, Divider>
        implements OrientationAssert<DividerAssert, Divider>, ThemeAssert<DividerAssert, Divider> {

    @JDIAction(value = "Assert that '{name}' is inset", isAssert = true)
    public DividerAssert inset() {
        jdiAssert(element().isInset(), Matchers.is(true), "Element is not inset");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not inset", isAssert = true)
    public DividerAssert notInset() {
        jdiAssert(element().isInset(), Matchers.is(false), "Element is inset");
        return this;
    }
}
