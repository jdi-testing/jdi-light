package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.DateTimePickers;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class DateTimePickersAssert  extends UIAssert<DateTimePickersAssert, DateTimePickers> {
    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public DateTimePickersAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that picker index {index} is displayed")
    public DateTimePickersAssert displayed(final int index) {
        jdiAssert(element().getPickerField(index).isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that picker {index} has text '{0}'")
    public DateTimePickersAssert containigText(final int index, Matcher<String> condition) {
        jdiAssert(element().getPickerField(index).getText(), condition);
        return this;
    }

    @JDIAction("Assert that picker {index} is clickable")
    public DateTimePickersAssert clickable(final int index) {
        jdiAssert(element().getPickerBtn(index).isClickable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that picker {index} has title '{0}'")
    public DateTimePickersAssert havingTitle(final int index, Matcher<String> condition) {
        jdiAssert(element().getPickerLabel(index).getText(), condition);
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
