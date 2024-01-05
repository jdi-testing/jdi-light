package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.asserts.AlignmentAssert;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.CursorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class IconAssert extends UIAssert<IconAssert, Icon> implements
    CursorAssert<IconAssert, Icon>,
    AlignmentAssert<IconAssert, Icon>, ThemeAssert<IconAssert, Icon>,
    MeasurementAssert<IconAssert, Icon>, ColorAssert<IconAssert, Icon> {

    @JDIAction(value = "Assert that '{name}' is clickable", isAssert = true)
    public IconAssert clickable() {
        jdiAssert(element().core().isClickable(),
            Matchers.is(true), "Icon is not clickable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected type", isAssert = true)
    public IconAssert type(String iconType) {
        jdiAssert(element().type(), Matchers.is(iconType));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has alert after clicking on it", isAssert = true)
    public IconAssert alertOnIconClick(String text) {
        jdiAssert(element().hasAlertOnIconClick(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no label", isAssert = true)
    public IconAssert hasNoLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There a label for element");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has a name", isAssert = true)
    public IconAssert iconName(String iconName) {
        jdiAssert(element().getMdiIconName(), Matchers.is(iconName));
        return this;
    }
}
