package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TabsAssert extends UISelectAssert<TabsAssert, Tabs> {

    @JDIAction("Assert that tab {name} root is disabled")
    public TabsAssert elementDisabled(int index) {
        jdiAssert(element().disabled(index) ?
                "element selected" : "element is not selected", Matchers.is("element selected"));
        return this;
    }

    @JDIAction("Assert that {name} is enabled")
    public TabsAssert elementEnabled(int index) {
        jdiAssert(element().enabled(index) ? "enabled" : "not enabled", Matchers.is("enabled"));
        return this;
    }

    @JDIAction("Assert that tab {name} root is selected")
    public TabsAssert elementSelected(int index) {
        jdiAssert((element().selected(index) ? "selected" : "not selected"), Matchers.is("selected"));
        return this;
    }

    @JDIAction("Assert that tab {name} root is selected")
    public TabsAssert elementNotSelected(int index) {
        jdiAssert((element().notSelected(index) ? "not selected" : "selected"), Matchers.is("not selected"));
        return this;
    }
}
