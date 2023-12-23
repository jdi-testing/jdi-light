package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.SlideGroup;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SlideGroupAssert extends UIAssert<SlideGroupAssert, SlideGroup>
    implements ThemeAssert<SlideGroupAssert, SlideGroup> {

    @JDIAction("Assert that '{name}' is displayed")
    public SlideGroupAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "SlideGroup is not displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' slide on index {0} is selected")
    public SlideGroupAssert slideSelected(int index) {
        jdiAssert(element().slideIsSelected(index), Matchers.is(true),
                String.format("Slide with %d is not selected", index));
        return this;
    }

    @JDIAction("Assert that '{name}' slide on index {0} is not selected")
    public SlideGroupAssert slideNotSelected(int index) {
        jdiAssert(element().slideIsSelected(index), Matchers.is(false),
                String.format("Slide with %d is selected", index));
        return this;
    }

    @JDIAction("Assert that '{name}' icon is visible")
    public SlideGroupAssert iconSlidesVisible(String by) {
        jdiAssert(element().find(by).isDisplayed(), Matchers.is(true), "SlideGroup icons are not displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' icon is visible")
    public SlideGroupAssert previousButtonActive() {
        jdiAssert(element().isPreviousButtonDisabled(), Matchers.is(false), "Previous Button is disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' icon is visible")
    public SlideGroupAssert previousButtonDisabled() {
        jdiAssert(element().isPreviousButtonDisabled(), Matchers.is(true), "Previous Button is active");
        return this;
    }

    @JDIAction("Assert that '{name}' icon is visible")
    public SlideGroupAssert nextButtonActive() {
        jdiAssert(element().isNextButtonActive(), Matchers.is(true), "Next Button is disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' icon is visible")
    public SlideGroupAssert nextButtonDisabled() {
        jdiAssert(element().isNextButtonDisabled(), Matchers.is(true), "Next Button is active");
        return this;
    }
}
