package com.epam.jdi.light.asserts.complex;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DropdownAssert extends UISelectAssert<DropdownAssert, IsDropdown> {
    @JDIAction("Assert that '{name}' is expanded")
    public DropdownAssert expanded() {
        jdiAssert(element.isExpanded() ? "expanded" : "collapsed", Matchers.is("expanded"));
        return this;
    }
    @JDIAction("Assert that '{name}' is collapsed")
    public DropdownAssert collapsed() {
        jdiAssert(element.isExpanded() ? "expanded" : "collapsed", Matchers.is("collapsed"));
        return this;
    }
}
