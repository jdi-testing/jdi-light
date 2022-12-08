package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

/**
 * To see examples of Tool Bar web elements please visit https://vuetifyjs.com/en/components/toolbars
 */

public class ToolBar extends BasicBar<ToolBar, ToolBarAssert> {
    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }
    @JDIAction("Get '{name}' 'close' button")
    public VuetifyButton closeButton() {
        return findIconButton("mdi-close");
    }

    @JDIAction("Get '{name}' 'delete' button")
    public VuetifyButton deleteButton() {
        return findIconButton("mdi-delete");
    }

    @JDIAction("Check that '{name}' has background image")
    public boolean hasBackgroundImage() {
        return core().find("div.v-toolbar__image .v-image").isExist();
    }
}
