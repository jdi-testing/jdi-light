package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.Sheet;
import com.epam.jdi.light.vuetify.elements.enums.Colors;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

public class SheetAssert extends UIAssert<SheetAssert, Sheet> implements ITextAssert<SheetAssert> {

    @JDIAction("Assert that '{name}' has elevation value {0}")
    public SheetAssert elevation(Matcher<Integer> condition) {
        final String elevationClass = element().elevation();
        jdiAssert(elevationClass, not(emptyOrNullString()));
        if (!elevationClass.isEmpty()) {
            final int elevationLevel = Integer.parseInt(elevationClass.split("-")[1]);
            jdiAssert(elevationLevel, condition);

        }
        return this;
    }

    public SheetAssert elevation(Integer value) {
        return elevation(Matchers.is(value));
    }

    @JDIAction("Assert that '{name}' is rounded")
    public SheetAssert rounded() {
        jdiAssert(element().rounded(), not(emptyOrNullString()));
        return this;
    }

    @JDIAction("Assert that '{name}' has color {0}")
    public SheetAssert color(Matcher<String> condition) {
        jdiAssert(element().css("background-color"), condition);
        return this;
    }

    public SheetAssert color(Colors color) {
        return color(Matchers.is(color.value()));
    }

    @JDIAction("Assert that '{name}' border radius is {0}")
    public SheetAssert borderRadius(int value) {
        jdiAssert(element().css("border-top-left-radius"), Matchers.is(String.format("%dpx", value)));
        jdiAssert(element().css("border-top-right-radius"), Matchers.is(String.format("%dpx", value)));
        return this;
    }

    @Override
    public SheetAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
}
