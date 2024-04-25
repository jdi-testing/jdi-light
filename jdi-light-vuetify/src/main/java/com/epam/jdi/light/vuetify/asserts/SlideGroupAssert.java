package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.SlideGroup;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SlideGroupAssert extends UIAssert<SlideGroupAssert, SlideGroup>
    implements ThemeAssert<SlideGroupAssert, SlideGroup> {

    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public SlideGroupAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "SlideGroup is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' slide on index {0} is selected", isAssert = true)
    public SlideGroupAssert slideSelected(int index) {
        jdiAssert(element().slideIsSelected(index), Matchers.is(true),
                String.format("Slide with %d is not selected", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' slide on index {0} is not selected", isAssert = true)
    public SlideGroupAssert slideNotSelected(int index) {
        jdiAssert(element().slideIsSelected(index), Matchers.is(false),
                String.format("Slide with %d is selected", index));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' icon is visible", isAssert = true)
    public SlideGroupAssert previousButtonActive() {
        jdiAssert(element().isPreviousButtonDisabled(), Matchers.is(false), "Previous Button is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' icon is visible", isAssert = true)
    public SlideGroupAssert previousButtonDisabled() {
        jdiAssert(element().isPreviousButtonDisabled(), Matchers.is(true), "Previous Button is active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' icon is visible", isAssert = true)
    public SlideGroupAssert nextButtonActive() {
        jdiAssert(element().isNextButtonActive(), Matchers.is(true), "Next Button is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' icon is visible", isAssert = true)
    public SlideGroupAssert nextButtonDisabled() {
        jdiAssert(element().isNextButtonDisabled(), Matchers.is(true), "Next Button is active");
        return this;
    }
}
