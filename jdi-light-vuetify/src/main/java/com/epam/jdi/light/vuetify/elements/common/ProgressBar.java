package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.ProgressBarAssert;

/**
 * To see an example of Progress linear web element please visit https://vuetifyjs.com/en/components/progress-linear/
 */

public class ProgressBar extends UIBaseElement<ProgressBarAssert> implements HasClick {

    @JDIAction("'{name}' has expected color")
    public String hasColor() {
        return this.find(".v-progress-linear__background").getCssValue("background-color");
    }

    @JDIAction("'{name}' has expected bar color")
    public String hasBarColor() {
        if(isIndeterminate()) {
            return this.find("div.short").getCssValue("background-color");
        } else return this.find(".v-progress-linear__determinate").getCssValue("background-color");
    }

    @JDIAction("'{name}' is determinate")
    public boolean isDeterminate() {
        return this.children().stream()
                .anyMatch(element-> element.getAttribute("class")
                .contains("_determinate"));
    }

    @JDIAction("'{name}' is indeterminate")
    public boolean isIndeterminate() {
        return this.children().stream()
                .anyMatch(element-> element.getAttribute("class")
                .contains("indeterminate"));
    }

    @JDIAction("'{name}' is reactive")
    public boolean isReactive() {
        return this.core().getAttribute("class").contains("reactive");
    }

    @JDIAction("'{name}' is rounded")
    public boolean isRounded() {
        return this.core().getAttribute("class").contains("rounded");
    }

    @JDIAction("'{name}' is striped")
    public boolean isStriped() {
        return this.core().getAttribute("class").contains("striped");
    }

    @JDIAction("'{name}' has expected value")
    public Double hasValue() {
        return Double.valueOf(this.core().getAttribute("aria-valuenow"));
    }

    @JDIAction("'{name}' has stream")
    public boolean hasStream() {
        return this.children().stream()
                .anyMatch(element-> element.getAttribute("class")
                        .contains("stream"));
    }

    public ProgressBarAssert is() {
        return new ProgressBarAssert().set(this);
    }

    public ProgressBarAssert has() {
        return this.is();
    }
}
