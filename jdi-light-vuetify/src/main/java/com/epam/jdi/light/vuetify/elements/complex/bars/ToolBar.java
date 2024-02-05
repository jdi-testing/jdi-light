package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;

/**
 * To see examples of Tool Bar web elements please visit https://v2.vuetifyjs.com/en/components/toolbars
 */

public class ToolBar extends BasicBar<ToolBar, ToolBarAssert> {
    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }

    @JDIAction("Get if '{name}' has background image")
    public boolean hasBackgroundImage() {
        return core().find("div.v-toolbar__image .v-image").isExist();
    }
}
