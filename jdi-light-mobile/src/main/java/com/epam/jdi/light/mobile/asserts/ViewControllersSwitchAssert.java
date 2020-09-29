package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.composite.ios.app.ViewControllersSwitch;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ViewControllersSwitchAssert extends UIAssert<ViewControllersSwitchAssert, ViewControllersSwitch> {

    @JDIAction(value = "Assert that {0} value selected for '{name}'")
    public ViewControllersSwitchAssert selected(String selectedElement) {
        jdiAssert(element().selected(), Matchers.is(selectedElement));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} values")
    public ViewControllersSwitchAssert values(List<String> values) {
        jdiAssert(element().values(), Matchers.contains(values.toArray()));
        return this;
    }
}
