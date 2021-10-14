package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ProgressBarAssert;

public class ProgressBar extends UIBaseElement<ProgressBarAssert> {

    @JDIAction("'{name}' has expected background color")
    public String hasColor() {
        return this.find(".v-progress-linear__background").getCssValue("background-color");
    }

    @JDIAction("'{name}' has expected background color")
    public String hasBarColor() {
        if(isIndeterminate()) {
            return this.find("div.short").getCssValue("background-color");
        } else return this.find(".v-progress-linear__determinate").getCssValue("background-color");
    }

    @JDIAction("'{name}' is indeterminate")
    public boolean isIndeterminate() {
        return this.children().stream()
                .anyMatch(element-> element.getAttribute("class")
                .contains("indeterminate"));
    }



    public ProgressBarAssert is() {
        return new ProgressBarAssert().set(this);
    }

    public ProgressBarAssert has() {
        return this.is();
    }
}
