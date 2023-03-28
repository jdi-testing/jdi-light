package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.app.ICheckbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class CheckboxAssert extends UIAssert<CheckboxAssert, ICheckbox>
        implements SelectedAssert<CheckboxAssert> {
    @JDIAction("Assert that '{name}' is selected")
    public CheckboxAssert selected() {
        jdiAssert(getIsSelected(), Matchers.is("selected"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert deselected() {
        jdiAssert(getIsSelected(), Matchers.is("not selected"));
        return this;
    }

    //protected
    protected String getIsSelected() {
        return element().isChecked() ? "selected" : "not selected";
    }
}