package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CarouselAssert extends UIAssert<CarouselAssert, Carousel> {

    @JDIAction("Assert that {name} is displayed")
    public CarouselAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        element().scrollIntoView();
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert checker() {
        jdiAssert(element().hasChecker(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is checked")
    public CarouselAssert checkerChecked() {
        jdiAssert(element().checkerState(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is unchecked")
    public CarouselAssert checkerUnchecked() {
        jdiAssert(element().checkerState(), Matchers.is("false"));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public CarouselAssert properTitle(String title) {
        jdiAssert(element().hasTitle(), Matchers.is(title));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public CarouselAssert properText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has button")
    public CarouselAssert button() {
        jdiAssert(element().hasButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has icon")
    public CarouselAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has alert after clicking on icon")
    public CarouselAssert alertOnIconClick(String text) {
        jdiAssert(element().hasAlertOnIconClick(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that banner has buttons")
    public CarouselAssert buttons() {
        for (UIElement button : element().getButtons()) {
            jdiAssert(button.getAttribute("type"), Matchers.is("button"));
        }
        jdiAssert(element().hasButtons(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner's buttons are hidden")
    public CarouselAssert hiddenButtons() {
        for(UIElement button: element().getButtons()) {
            jdiAssert(button.isHidden(), Matchers.is(true));
        }
        return this;
    }

    @JDIAction("Assert that banner's text field is hidden")
    public CarouselAssert hiddenTextField() {
        jdiAssert(element().getTextField().isHidden(), Matchers.is(true));
        return this;
    }
}
