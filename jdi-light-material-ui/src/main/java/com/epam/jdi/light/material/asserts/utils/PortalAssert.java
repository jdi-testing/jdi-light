package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Portal;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PortalAssert extends UIAssert<PortalAssert, Portal> {
    @JDIAction("Assert that '{name}' text is '{0}'")
    public PortalAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }
}
