package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.SlideToggle;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SlideToggleAssert extends UIAssert<SlideToggleAssert, SlideToggle> {

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public SlideToggleAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Slide toggle is enabled");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public SlideToggleAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Slide toggle is disabled");
        return this;
    }

    @JDIAction("'{name}' element label is in before position")
    public SlideToggleAssert labelBeforePosition() {
        jdiAssert(element().hasLabelBeforePosition(), Matchers.is(true),
                "Slide toggle label is not in before position");
        return this;
    }

    @JDIAction("'{name}' element label is in after position")
    public SlideToggleAssert labelAfterPosition() {
        jdiAssert(element().hasLabelBeforePosition(), Matchers.is(false),
                "Slide toggle label is not in after position");
        return this;
    }

    @JDIAction("'{name}' has label with value '{0}'")
    public SlideToggleAssert label(String labelText) {
        jdiAssert(element().label().getValue(), Matchers.is(labelText));
        return this;
    }

    @JDIAction("'{name}' is selected")
    public SlideToggleAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "Slide toggle is not selected");
        return this;
    }

    @JDIAction("'{name}' is not selected")
    public SlideToggleAssert notSelected() {
        jdiAssert(element().isSelected(), Matchers.is(false), "Slide toggle is selected");
        return this;
    }
}
