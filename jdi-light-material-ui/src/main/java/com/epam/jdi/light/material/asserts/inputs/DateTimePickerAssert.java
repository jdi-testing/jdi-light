package com.epam.jdi.light.material.asserts.inputs;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.DateTimePicker;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class DateTimePickerAssert extends UIAssert<DateTimePickerAssert, DateTimePicker>
        implements ITextAssert<DateTimePickerAssert> {

    @Override
    @JDIAction("Assert that {name} text {0}")
    public DateTimePickerAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Assert that {name} has title '{0}'")
    public DateTimePickerAssert title(String reqTitle) {
        jdiAssert(element().title(), Matchers.is(reqTitle));
        return this;
    }
}
