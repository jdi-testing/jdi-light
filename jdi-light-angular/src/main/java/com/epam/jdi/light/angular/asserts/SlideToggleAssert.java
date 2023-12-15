package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.SlideToggle;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class SlideToggleAssert extends UIAssert<SlideToggleAssert, SlideToggle> {

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public SlideToggleAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Button toggle is enabled");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public SlideToggleAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Button toggle is disabled");
        return this;
    }

    @JDIAction("'{name}' element label is in before position")
    public SlideToggleAssert labelBeforePosition() {
        jdiAssert(element().hasLabelBeforePosition(), Matchers.is(true),
            "Button toggle label is not in before position");
        return this;
    }

    @JDIAction("'{name}' element label is in after position")
    public SlideToggleAssert labelAfterPosition() {
        jdiAssert(element().hasLabelBeforePosition(), Matchers.is(false),
            "Button toggle label is not in after position");
        return this;
    }

    @JDIAction("'{name}' is selected")
    public SlideToggleAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "Button toggle is not selected");
        return this;
    }

    @JDIAction("'{name}' is not selected")
    public SlideToggleAssert notSelected() {
        jdiAssert(element().isSelected(), Matchers.is(false), "Button toggle is selected");
        return this;
    }
}
