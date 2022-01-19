package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.TimePickersAssert;

/**
 * To see examples of TimePickers web elements please visit https://vuetifyjs.com/en/components/time-pickers/
 */

public class TimePickers extends UIListBase<TimePickersAssert> {

    @Override
    public TimePickersAssert is() {
        return new TimePickersAssert().set(this);
    }

    @JDIAction("Check that {name} is enabled")
    public boolean enabled() {
        return list().isNotEmpty() && list().stream().anyMatch(UIElement::isEnabled)
                && list().stream().anyMatch(UIElement::isClickable);
    }

    @JDIAction("Check that {name} is disabled")
    public boolean disabled() {
        return !enabled();
    }

    @JDIAction("Check that {name} element {0} is disabled")
    public boolean elementDisabled(String value) {
        return list().get(value).hasClass("v-time-picker-clock__item--disabled");
    }

    @JDIAction("Check that {name} element {0} is disabled")
    public boolean elementDisabled(int value) {
        return list().get(value).hasClass("v-time-picker-clock__item--disabled");
    }

    @JDIAction("Check that {name} element {0} is enabled")
    public boolean elementEnabled(String value) {
        return !elementDisabled(value);
    }

    @JDIAction("Check that {name} element {0} is enabled")
    public boolean elementEnabled(int value) {
        return !elementDisabled(value);
    }
}
