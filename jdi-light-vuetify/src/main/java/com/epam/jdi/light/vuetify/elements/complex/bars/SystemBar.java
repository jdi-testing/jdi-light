package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;

/**
 * To see examples of System Bar web elements please visit https://vuetifyjs.com/en/components/system-bars
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> {

    @JDIAction("Get '{name}'s 'Wi-Fi' icon")
    public Icon wiFiIcon() {
        return castToIcon(find(".mdi-wifi-strength-4"));
    }

    @JDIAction("Get '{name}'s 'signal' icon")
    public Icon signalIcon() {
        return castToIcon(find(".mdi-signal-cellular-outline"));
    }

    @JDIAction("Get '{name}'s 'battery' icon")
    public Icon batteryIcon() {
        return castToIcon(find(".mdi-battery"));
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }
}
