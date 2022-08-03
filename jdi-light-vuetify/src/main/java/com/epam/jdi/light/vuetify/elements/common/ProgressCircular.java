package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ProgressCircularAssert;

/**
 * To see an example of Progress Spinner web element please visit https://vuetifyjs.com/en/components/progress-circular/
 */

public class ProgressCircular extends UIBaseElement<ProgressCircularAssert> {

    @JDIAction("'{name}' has {0} color")
    public String hasColor() {
        return find("svg").getCssValue("color");
    }

    @JDIAction("Get '{name}'  height")
    public String height() {
        return core().getCssValue("height");
    }

    @JDIAction("Get '{name}'  width")
    public String width() {
        return core().getCssValue("width");
    }

    @JDIAction("'{name}' is spinning")
    public boolean isSpinning() {
       return core().getAttribute("class").contains("v-progress-circular--indeterminate");
    }

    public ProgressCircularAssert is() {
        return new ProgressCircularAssert().set(this);
    }

    public ProgressCircularAssert has() {
        return is();
    }

}
