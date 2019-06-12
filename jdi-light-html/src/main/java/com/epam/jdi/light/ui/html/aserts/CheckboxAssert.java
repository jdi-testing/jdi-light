package com.epam.jdi.light.ui.html.aserts;

import com.epam.jdi.light.asserts.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {
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

    //protected
    protected String getIsSelected() {
        return uiElement.isSelected() ? "selected" : "not selected";
    }
}