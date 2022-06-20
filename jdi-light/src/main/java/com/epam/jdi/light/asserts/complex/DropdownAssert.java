package com.epam.jdi.light.asserts.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DropdownAssert extends UISelectAssert<DropdownAssert, IsDropdown> {

    /**
     * Checks that Dropdown is expanded.
     *
     * @return this {@link DropdownAssert} instance
     */
    @JDIAction("Assert that '{name}' is expanded")
    public DropdownAssert expanded() {
        jdiAssert(element().isExpanded() ? "expanded" : "collapsed", Matchers.is("expanded"));
        return this;
    }

    /**
     * Checks that Dropdown is collapsed.
     *
     * @return this {@link DropdownAssert} instance
     */
    @JDIAction("Assert that '{name}' is collapsed")
    public DropdownAssert collapsed() {
        jdiAssert(!element().isExpanded() ? "collapsed" : "expanded", Matchers.is("collapsed"));
        return this;
    }
}
