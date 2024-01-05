package com.epam.jdi.light.angular.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.angular.elements.common.SlideToggle;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

public class SlideToggleAssert extends UIAssert<SlideToggleAssert, SlideToggle> {

    @Override
    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public SlideToggleAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Slide toggle is enabled");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public SlideToggleAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Slide toggle is disabled");
        return this;
    }

    @JDIAction(value = "'{name}' element label is in before position", isAssert = true)
    public SlideToggleAssert labelBeforePosition() {
        jdiAssert(element().hasLabelBeforePosition(), Matchers.is(true),
            "Slide toggle label is not in before position");
        return this;
    }

    @JDIAction(value = "'{name}' element label is in after position", isAssert = true)
    public SlideToggleAssert labelAfterPosition() {
        jdiAssert(element().hasLabelBeforePosition(), Matchers.is(false),
            "Slide toggle label is not in after position");
        return this;
    }

    @JDIAction(value = "'{name}' is selected", isAssert = true)
    public SlideToggleAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "Slide toggle is not selected");
        return this;
    }

    @JDIAction(value = "'{name}' is not selected", isAssert = true)
    public SlideToggleAssert notSelected() {
        jdiAssert(element().isSelected(), Matchers.is(false), "Slide toggle is selected");
        return this;
    }
}
