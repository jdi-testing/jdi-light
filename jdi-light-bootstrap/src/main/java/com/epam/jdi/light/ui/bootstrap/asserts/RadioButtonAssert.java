package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class RadioButtonAssert extends UIAssert<RadioButtonAssert, RadioButton>
        implements SelectedAssert<RadioButtonAssert> {

    @JDIAction("Assert that '{name}' is selected")
    public RadioButtonAssert selected() {
        jdiAssert(getIsSelected(), is("selected"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not selected")
    public RadioButtonAssert deselected() {
        jdiAssert(getIsSelected(), is("not selected"));
        return this;
    }

    //protected
    protected String getIsSelected() {
        return element.isSelected() ? "selected" : "not selected";
    }

}
