package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

public class VuetifyButtonAssert extends TextAssert implements ThemeAssert<VuetifyButtonAssert, VuetifyButton>,
    ColorAssert<VuetifyButtonAssert, VuetifyButton>, OutlinedAssert<VuetifyButtonAssert, VuetifyButton>,
    ElevationAssert<VuetifyButtonAssert, VuetifyButton> {

    @Override
    public VuetifyButton element() {
        return (VuetifyButton) super.element();
    }

    @JDIAction("Assert that '{name}' is loading")
    public VuetifyButtonAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is clickable")
    public VuetifyButtonAssert clickable() {
        jdiAssert(element().core().isClickable(), Matchers.is(true));
        return this;
    }

    @Override
    public VuetifyButtonAssert has() {
        return this;
    }

    @Override
    public VuetifyButtonAssert and() {
        return this;
    }

    @Override
    public VuetifyButtonAssert is() {
        return this;
    }
}
