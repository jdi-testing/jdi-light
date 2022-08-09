package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.ProgressLinearAssert;

/**
 * To see an example of Progress linear web element please visit https://vuetifyjs.com/en/components/progress-linear/
 */

public class ProgressLinear extends UIBaseElement<ProgressLinearAssert> implements HasClick {

    @JDIAction("'{name}' has expected color")
    public String hasColor() {
        return find(".v-progress-linear__background").getCssValue("background-color");
    }

    @JDIAction("'{name}' has expected bar color")
    public String hasBarColor() {
        if (isIndeterminate()) {
            return find("div.short").getCssValue("background-color");
        } else {
            return find(".v-progress-linear__determinate").getCssValue("background-color");
        }
    }

    @JDIAction("Get if '{name}' is determinate")
    public boolean isDeterminate() {
        return children().stream()
                .anyMatch(element -> element.getAttribute("class")
                        .contains("_determinate"));
    }

    @JDIAction("Get if '{name}' is indeterminate")
    public boolean isIndeterminate() {
        return children().stream()
                .anyMatch(element -> element.getAttribute("class")
                        .contains("indeterminate"));
    }

    @JDIAction("Get if '{name}' is reactive")
    public boolean isReactive() {
        return core().getAttribute("class").contains("reactive");
    }

    @JDIAction("Get if '{name}' is rounded")
    public boolean isRounded() {
        return core().getAttribute("class").contains("rounded");
    }

    @JDIAction("Check if '{name}' is striped")
    public boolean isStriped() {
        return core().getAttribute("class").contains("striped");
    }

    @JDIAction("Get '{name}' value")
    public Double hasValue() {
        return Double.valueOf(core().getAttribute("aria-valuenow"));
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

    public ProgressLinearAssert has() {
        return is();
    }
}
