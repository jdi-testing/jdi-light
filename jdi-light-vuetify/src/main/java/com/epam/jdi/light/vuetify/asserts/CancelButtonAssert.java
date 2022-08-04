package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.CancelButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CancelButtonAssert extends UIAssert<CancelButtonAssert, CancelButton> {

    @JDIAction("Assert that Cancel button does not visible")
    public CancelButtonAssert cancelButtonIsNotVisible() {
        jdiAssert(element().isNotVisible(), Matchers.is(true));
        return this;
    }
}
