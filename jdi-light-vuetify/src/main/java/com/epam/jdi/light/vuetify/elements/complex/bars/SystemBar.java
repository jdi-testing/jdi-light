package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;
import com.epam.jdi.light.vuetify.elements.complex.ButtonGroup;

/**
 * To see examples of System Bar web elements please visit https://vuetifyjs.com/en/components/system-bars
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> {

    public ButtonGroup icons () {
        return new ButtonGroup(systemBar());
    }

    public UIElement systemBar () {
        return core().find(".v-system-bar");
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }
}
