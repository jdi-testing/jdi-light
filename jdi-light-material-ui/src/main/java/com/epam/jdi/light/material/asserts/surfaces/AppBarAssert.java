package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.AppBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert extends UIAssert<AppBarAssert, AppBar> {

    @JDIAction("Assert '{name}'")
    public AppBarAssert assertTitle(String actualTitle) {
        jdiAssert(element().verifyTitle(actualTitle), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert '{name}'")
    public AppBarAssert enabled(int index) {
        jdiAssert(element().isMenuButtonEnabled(index), Matchers.is(true));
        return this;
    }
}
