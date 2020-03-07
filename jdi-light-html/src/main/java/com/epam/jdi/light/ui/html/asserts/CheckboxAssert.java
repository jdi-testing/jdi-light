package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.*;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import org.hamcrest.*;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox>
        implements SelectedAssert<CheckboxAssert>, ITextAssert<CheckboxAssert> {
    @JDIAction("Assert that '{name}' is selected")
    public CheckboxAssert selected() {
        jdiAssert(getIsSelected(), Matchers.is("selected"));
        return this;
    }
    @JDIAction("Assert that '{name}' text {0}") @Override
    public CheckboxAssert text(Matcher<String> condition) {
        jdiAssert(element.getText(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert deselected() {
        jdiAssert(getIsSelected(), Matchers.is("not selected"));
        return this;
    }

    //protected
    protected String getIsSelected() {
        return element.isSelected() ? "selected" : "not selected";
    }
}