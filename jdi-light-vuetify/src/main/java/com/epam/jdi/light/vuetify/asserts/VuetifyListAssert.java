package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VuetifyListAssert extends UIAssert<VuetifyListAssert, VuetifyList> {

    public static final String EXPANDED = "expanded";
    public static final String COLLAPSED = "collapsed";

    @JDIAction("Assert that '{name}' menu item {0} is expanded")
    public VuetifyListAssert sublistExpanded(String title) {
        jdiAssert(element().isExpanded(title) ? EXPANDED : COLLAPSED, Matchers.is(EXPANDED));
        return this;
    }

    @JDIAction("Assert that '{name}' menu item {0} is collapsed")
    public VuetifyListAssert sublistCollapsed(String title) {
        jdiAssert(element().isExpanded(title) ? EXPANDED : COLLAPSED, Matchers.is(COLLAPSED));
        return this;
    }

}
