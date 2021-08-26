package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TabsAssert extends UIAssert<TabsAssert, Tabs> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public TabsAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
}
