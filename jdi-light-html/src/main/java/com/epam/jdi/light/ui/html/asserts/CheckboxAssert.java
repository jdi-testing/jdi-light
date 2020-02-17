package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox>
        implements SelectedAssert<CheckboxAssert> {
    @JDIAction("Assert that '{name}' is selected")
    public CheckboxAssert selected(String... messages) {
        jdiAssert(getIsSelected(), Matchers.is("selected"), messages);
        return this;
    }
    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert deselected(String... messages) {
        jdiAssert(getIsSelected(), Matchers.is("not selected"), messages);
        return this;
    }

    //protected
    protected String getIsSelected() {
        return element.isSelected() ? "selected" : "not selected";
    }
}