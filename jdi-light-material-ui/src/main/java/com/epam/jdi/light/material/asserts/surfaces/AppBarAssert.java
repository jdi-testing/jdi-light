package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.AppBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert extends UIAssert<AppBarAssert, AppBar> {

    @JDIAction("Assert '{name}'")
    public AppBarAssert assertTitle(String expectedTitle) {
        jdiAssert(element().verifyTitle(expectedTitle), Matchers.is(true));
        return this;
    }
}
