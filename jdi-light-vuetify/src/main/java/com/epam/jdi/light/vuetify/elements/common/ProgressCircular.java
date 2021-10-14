package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ProgressCircularAssert;

/**
 * To see an example of Progress Circular web element please visit https://vuetifyjs.com/en/components/progress-circular/
 */

public class ProgressCircular extends UIBaseElement<ProgressCircularAssert> {

    @JDIAction("{name} has {0} color")
    public String hasColor() {
        return this.find("svg").getCssValue("color");
    }

    @JDIAction("{name} has {0} height")
    public String hasHeight() {
        return this.core().getCssValue("height");
    }

    @JDIAction("{name} has {0} width")
    public String hasWidth() {
        return this.core().getCssValue("width");
    }

    @JDIAction("{name} is spinning")
    public boolean isSpinning() {
       return this.core().getAttribute("class").contains("v-progress-circular--indeterminate");
    }

    public ProgressCircularAssert is() {
        return new ProgressCircularAssert().set(this);
    }

    public ProgressCircularAssert has() {
        return this.is();
    }

}
