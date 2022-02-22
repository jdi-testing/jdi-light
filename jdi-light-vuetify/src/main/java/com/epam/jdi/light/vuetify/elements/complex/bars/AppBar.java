package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.bars.AppBarAssert;

/**
 * To see examples of App Bar web elements please visit https://vuetifyjs.com/en/components/app-bars
 */

public class AppBar extends BasicBar<AppBar, AppBarAssert> {

    @Override
    @JDIAction("Check that {name} is displayed")
    public boolean isDisplayed() {
        return attr("style").contains("translateY(0px)");
    }

    @Override
    @JDIAction("Check that {name} is hidden")
    public boolean isHidden() {
        return attr("style").contains("translateY(-128px)");
    }

    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }
}
