package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.SlideGroup;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SlideGroupAssert extends UIAssert<SlideGroupAssert, SlideGroup>
    implements ThemeAssert<SlideGroupAssert, SlideGroup> {
    @Override
    public SlideGroup element() {
        return (SlideGroup) super.element();
    }

    @JDIAction("Assert that '{name}' is displayed")
    public SlideGroupAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' slide on index {0} is selected")
    public SlideGroupAssert slideSelected(int index) {
        jdiAssert(element().slideIsSelected(index), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' slide on index {0} is not selected")
    public SlideGroupAssert slideNotSelected(int index) {
        jdiAssert(element().slideIsSelected(index), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that all slide with id '{0}' is not selected except {1}")
    public SlideGroupAssert slidesNotSelectedExcept(String slideId, int... indexes) {
        jdiAssert(element().notSelectedExcept(slideId, indexes), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'next' button visible")
    public SlideGroupAssert visibleSlidesPosition(int position) {
        jdiAssert(element().slidesPosition(), Matchers.is(String.format("transform: translateX(%spx);", position)));
        return this;
    }

    @JDIAction("Assert that '{name}' has center active slide")
    public SlideGroupAssert centerActiveSlide() {
        int lstSliderSize = element().getSlidesCount().size();
        double centerSlideIndex = Math.round((double) lstSliderSize / 2);
        if (element().previousButtonIsDisabled()) {
            jdiAssert(element().position() <= centerSlideIndex, Matchers.is(true));
        } else if (element().nextButtonIsDisabled()) {
            jdiAssert(element().position() > centerSlideIndex, Matchers.is(true));
        } else {
            jdiAssert(element().position() == centerSlideIndex, Matchers.is(true));
        }
        return this;
    }

    @JDIAction("Assert that '{name}' icon is visible")
    public SlideGroupAssert iconSlidesVisible(String by) {
        jdiAssert(element().find(by).isDisplayed(), Matchers.is(true));
        return this;
    }
}
