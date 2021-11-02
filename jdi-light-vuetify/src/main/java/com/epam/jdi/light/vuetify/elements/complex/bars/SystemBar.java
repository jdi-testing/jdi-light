package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;

/**
 * To see examples of System Bar web elements please visit https://vuetifyjs.com/en/components/system-bars
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> implements IsText {

    @JDIAction("'{name}' background color")
    public String hasBackgroundColor() {
        return core().getCssValue("background-color");
    }

    @JDIAction("'{name}' position")
    public String hasPosition() {
        return core().getCssValue("position");
    }

    @JDIAction("Get ''{name}'' time")
    public String getTime() {
        return find("span").getText();
    }

    @JDIAction("'{name}' has 'Wi-Fi' icon")
    public boolean hasWiFiIcon() {
        return find(".mdi-wifi-strength-4").isDisplayed();
    }

    @JDIAction("'{name}' has 'signal' icon")
    public boolean hasSignalIcon() {
        return castToIcon(find(".mdi-signal-cellular-outline")).isDisplayed();
    }

    @JDIAction("'{name}' has 'battery' icon")
    public boolean hasBatteryIcon() {
        return castToIcon(find(".mdi-battery")).isDisplayed();
    }

    @JDIAction("'{name}' has 'message' icon")
    public boolean hasMessageIcon() {
        return castToIcon(find(".mdi-message")).isDisplayed();
    }

    @JDIAction("'{name}' has 'minus' icon")
    public boolean hasMinusIcon() {
        return castToIcon(find(".mdi-minus")).isDisplayed();
    }

    @JDIAction("'{name}' has 'empty checkbox' icon")
    public boolean hasEmptyCheckboxIcon() {
        return castToIcon(find(".mdi-checkbox-blank-outline")).isDisplayed();
    }

    @JDIAction("'{name}' has 'close' icon")
    public boolean hasCloseIcon() {
        return castToIcon(find(".mdi-close")).isDisplayed();
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }

    public SystemBarAssert has() {
        return is();
    }
}
