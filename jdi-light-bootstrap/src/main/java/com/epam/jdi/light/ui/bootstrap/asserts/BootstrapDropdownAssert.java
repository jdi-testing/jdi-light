package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.complex.BootstrapDropdown;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Arrays;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class BootstrapDropdownAssert<A extends BootstrapDropdownAssert, E extends BootstrapDropdown> extends UIAssert<A, E> {

    @JDIAction("Assert that dropdown '{name}' expanded")
    public A expanded() {
        jdiAssert(element.isExpanded(), is(true));
        return (A) this;
    }

    @JDIAction("Assert that dropdown '{name}' collapsed")
    public A collapsed() {
        jdiAssert(element.isCollapsed(), is(true));
        return (A) this;
    }



}
