package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.DateTimePicker;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Asserts for {@link DateTimePicker}
 */
public class DateTimePickerAssert extends UIAssert<DateTimePickerAssert, DateTimePicker>
        implements ITextAssert<DateTimePickerAssert> {

    /**
     * Checks that {@link DateTimePicker} has text from input field meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link DateTimePickerAssert} instance
     */
    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public DateTimePickerAssert text(Matcher<String> condition) {
        jdiAssert(element().value(), condition);
        return this;
    }

    /**
     * Checks that {@link DateTimePicker} has title meets the given condition.
     *
     * @param text expected full-text content of item to be found as {@link String}
     * @return this {@link DateTimePickerAssert} instance
     */
    @JDIAction("Assert that '{name}' has title '{0}'")
    public DateTimePickerAssert title(String text) {
        jdiAssert(element().title(), Matchers.is(text));
        return this;
    }
}
