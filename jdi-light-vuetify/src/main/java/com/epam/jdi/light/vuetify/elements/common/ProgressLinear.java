package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.ProgressLinearAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsReverse;

/**
 * To see an example of Progress linear web element please visit https://vuetifyjs.com/en/components/progress-linear/
 */

public class ProgressLinear extends UIBaseElement<ProgressLinearAssert> implements HasClick, HasRounded, HasColor,
        IsReverse, HasMeasurement, HasTheme {

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return find(".v-progress-linear__background").getCssValue("background-color");
    }

    @JDIAction("Get '{name}' bar color")
    public String hasBarColor() {
        if (isIndeterminate()) {
            return find("div.short").getCssValue("background-color");
        } else {
            return find(".v-progress-linear__determinate").getCssValue("background-color");
        }
    }

    @JDIAction("Get if '{name}' is determinate")
    public boolean isDeterminate() {
        return attr("innerHTML").contains("__determinate");
    }

    @JDIAction("Get if '{name}' is indeterminate")
    public boolean isIndeterminate() {
        return attr("innerHTML").contains("__indeterminate");
    }

    @JDIAction("Get if '{name}' is reactive")
    public boolean isReactive() {
        return core().getAttribute("class").contains("reactive");
    }

    @Override
    @JDIAction("Get if '{name}' is rounded")
    public boolean isRounded() {
        return core().getAttribute("class").contains("rounded");
    }

    @JDIAction("Get if '{name}' is striped")
    public boolean isStriped() {
        return core().getAttribute("class").contains("striped");
    }

    @JDIAction("Get '{name}' value")
    public double getValue() {
        return Double.parseDouble(core().getAttribute("aria-valuenow"));
    }

    @JDIAction("Get '{name}' maximum value")
    public double getMaxValue() {
        return Double.parseDouble(core().getAttribute("aria-valuemax"));
    }

    @JDIAction("Get if '{name}' has stream")
    public boolean hasStream() {
        return children().stream()
                .anyMatch(element -> element.getAttribute("class")
                        .contains("stream"));
    }

    public ProgressLinearAssert is() {
        return new ProgressLinearAssert().set(this);
    }
}
