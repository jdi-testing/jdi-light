package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.VerticalAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DividerAssert extends UIAssert<DividerAssert, Divider>
        implements VerticalAssert<DividerAssert, Divider>, ThemeAssert<DividerAssert, Divider> {

    @JDIAction("Assert that '{name}' is horizontal")
    public DividerAssert horizontal() {
        jdiAssert(element().isHorizontal(), Matchers.is(true));
        return this;
    }
}
