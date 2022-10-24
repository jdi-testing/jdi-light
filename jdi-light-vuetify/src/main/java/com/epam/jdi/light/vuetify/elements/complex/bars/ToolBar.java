package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;

/**
 * To see examples of Tool Bar web elements please visit https://vuetifyjs.com/en/components/toolbars
 */

public class ToolBar extends BasicBar<ToolBar, ToolBarAssert> implements IsFlat {

    @JDIAction("Get '{name}'s 'close' button")
    public VuetifyButton closeButton() {
        return findIconButton("mdi-close");
    }

    @JDIAction("Get '{name}'s 'delete' button")
    public VuetifyButton deleteButton() {
        return findIconButton("mdi-delete");
    }

    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }
}
