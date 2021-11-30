package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;

/**
 * To see examples of System Bar web elements please visit https://vuetifyjs.com/en/components/system-bars
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> implements IsText {

    @JDIAction("Get '{name}'s background color")
    public String getBackgroundColor() {
        return core().getCssValue("background-color");
    }

    @JDIAction("Get '{name}'s position")
    public String getPosition() {
        return core().getCssValue("position");
    }

    @JDIAction("Get '{name}'s time")
    public String getTime() {
        return find("span").getText();
    }

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

    @JDIAction("Get '{name}'s 'message' icon")
    public Icon messageIcon() {
        return castToIcon(find(".mdi-message"));
    }

    @JDIAction("Get '{name}'s 'minus' icon")
    public Icon minusIcon() {
        return castToIcon(find(".mdi-minus"));
    }

    @JDIAction("Get '{name}'s 'empty checkbox' icon")
    public Icon blankCheckboxIcon() {
        return castToIcon(find(".mdi-checkbox-blank-outline"));
    }

    @JDIAction("Get '{name}'s 'close' icon")
    public Icon closeIcon() {
        return castToIcon(find(".mdi-close"));
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }

    public SystemBarAssert has() {
        return is();
    }
}
