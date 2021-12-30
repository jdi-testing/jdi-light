package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Button;
import org.hamcrest.Matchers;

public class ButtonAssert extends TextAssert {

    @Override
    public Button element() {
        return (Button) super.element();
    }

    @JDIAction("Assert that '{name}' is loading")
    public ButtonAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }

//    @JDIAction("Assert that '{name}' is displayed")
//    @Override
//    public ButtonAssert displayed() {
//        jdiAssert(element().isDisplayed(), Matchers.is(true));
//        return this;
//    }
//
//    @JDIAction("Assert that '{name}' is hidden")
//    @Override
//    public ButtonAssert hidden() {
//        jdiAssert(element().isHidden(), Matchers.is(true));
//        return this;
//    }

//    @JDIAction("Assert that '{name}' is disabled")
//    @Override
//    public ButtonAssert disabled() {
//        jdiAssert(element().isDisabled(), Matchers.is(true));
//        return this;
//    }

    public ButtonAssert iconType(String type) {
        jdiAssert(element().icon().hasType(), Matchers.is(type));
        return this;
    }

    @Override
    public ButtonAssert has() {
        return this;
    }

    @Override
    public ButtonAssert and() {
        return this;
    }

    @Override
    public ButtonAssert is() {
        return this;
    }
}
