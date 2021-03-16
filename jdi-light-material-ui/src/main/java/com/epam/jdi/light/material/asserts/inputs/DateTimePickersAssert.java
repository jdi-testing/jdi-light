package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.DateTimePickers;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class DateTimePickersAssert  extends UIAssert<DateTimePickersAssert, DateTimePickers> {
    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public DateTimePickersAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public DateTimePickersAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} value contains attr")
    public DateTimePickersAssert valueContains(String attr){
        jdiAssert(element().valueContains(attr), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is visible")
    public  DateTimePickersAssert visible() {
        boolean isVisible = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isVisible());
        jdiAssert(isVisible, Matchers.is(true));
        return this;
    }

}
