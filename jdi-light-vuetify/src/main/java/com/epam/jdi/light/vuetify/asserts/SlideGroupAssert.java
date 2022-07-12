package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.SlideGroup;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SlideGroupAssert extends ItemGroupAssert {
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

    @JDIAction("Assert that '{name}' has 'next' button visible")
    public SlideGroupAssert visibleSlidesPosition(int position) {
        jdiAssert(element().slidesPosition(), Matchers.is(String.format("transform: translateX(%spx);", position)));
        return this;
    }

    @JDIAction("Assert that '{name}' has center selected slider")
    public SlideGroupAssert slideCenter() {
        int lstSliderSize = element().getAllSlide().size();
        if (element().previousButtonIsDisabled()){
            jdiAssert(element().position() <= Math.round((double)lstSliderSize / 2), Matchers.is(true));
        } else if (element().nextButtonIsDisabled()) {
            jdiAssert(element().position() > lstSliderSize / 2, Matchers.is(true));
        }else {
            jdiAssert(element().position() == Math.round((double)lstSliderSize / 2), Matchers.is(true));
        }
        return this;
    }
}
