package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TabsAssert extends UISelectAssert<TabsAssert, Tabs> {

    @JDIAction("Assert that tab {name} root is disabled")
    public TabsAssert disabled() {
        boolean isDisabled = (element().hasClass("Mui-disabled"));
        jdiAssert((isDisabled ? "disabled" : "not disabled"), Matchers.is("disabled"));
        return this;
    }

    @Override
    @JDIAction("Assert that {name} is enabled")
    public TabsAssert enabled() {
        jdiAssert(element().enabled() ? "enabled" : "not enabled", Matchers.is("enabled"));
        return this;
    }

    @JDIAction("Assert that tab {name} root is selected")
    public TabsAssert selected(int index) {
        jdiAssert((element().selected(index) ? "selected" : "not selected"), Matchers.is("selected"));
        return this;
    }
}
