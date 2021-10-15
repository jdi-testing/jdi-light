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

    @JDIAction("Assert that {name} has text")
    public DateTimePickerAssert text(Matcher condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Assert that {name} has title")
    public DateTimePickerAssert title(String reqTitle) {
        jdiAssert(element().title(), Matchers.is(reqTitle));
        return this;
    }
}
