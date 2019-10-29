package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Checkbox;


import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox>
        implements SelectedAssert<CheckboxAssert> {
    @JDIAction("Assert that '{name}' is selected")
    public CheckboxAssert selected() {
        jdiAssert(getIsSelected(), is("selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert deselected() {
        jdiAssert(getIsSelected(), is("not selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert enabled() {
        jdiAssert(getIsEnabled(), is("enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert disabled() {
        jdiAssert(getIsEnabled(), is("disabled"));
        return this;
    }

    //protected
    protected String getIsSelected() {
        return element.isSelected() ? "selected" : "not selected";
    }

    protected String getIsEnabled() {
        return element.isEnabled() ? "enabled" : "disabled";
    }
}