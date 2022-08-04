package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.OkButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class OkButtonAssert extends UIAssert<OkButtonAssert, OkButton> {
    @JDIAction("Assert that OK button does not visible")
    public OkButtonAssert okButtonIsNotVisible() {
        jdiAssert(element().isNotVisible(), Matchers.is(true));
        return this;
    }
}
