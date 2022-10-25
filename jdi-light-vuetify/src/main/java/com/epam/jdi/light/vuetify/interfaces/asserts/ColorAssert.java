package com.epam.jdi.light.vuetify.interfaces.asserts;

import com.epam.jdi.light.asserts.generic.BaseAssert;
import com.epam.jdi.light.asserts.generic.CommonAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.AlertAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface ColorAssert<A> extends BaseVuetifyAssert<HasColor> {

    @JDIAction("Assert that '{name}' has color '{0}'")
    default A color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has background color '{0}'")
    default A backgroundColor(String color) {
        jdiAssert(element().backgroundColor(), Matchers.is(color));
        return (A) this;
    }
}
