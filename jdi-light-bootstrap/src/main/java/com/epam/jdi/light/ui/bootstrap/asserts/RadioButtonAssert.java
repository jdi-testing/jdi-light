package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 24.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class RadioButtonAssert extends UISelectAssert<RadioButtonAssert, RadioButton>
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
