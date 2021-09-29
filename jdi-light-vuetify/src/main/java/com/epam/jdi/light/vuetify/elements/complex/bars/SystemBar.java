package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;

/**
 * To see examples of System Bar web elements please visit https://vuetifyjs.com/en/components/system-bars
 *
 * The v-system-bar component can be used for displaying statuses to the user.
 * It looks like the Android system bar and can contain icons, spacers, and some text.
 *
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> {

    @JDIAction("Get '{name}' text")
    public String getText() {
        return this.core().getText();
    }

    @JDIAction("Get '{name}' background color")
    public String getBackgroundColor() {
        return this.core().getCssValue("background-color");
    }

    @JDIAction("Get '{name}' position")
    public String getPosition() {
        return this.core().getCssValue("position");
    }

    @JDIAction("Get '{name}' 'Wi-Fi' icon")
    public UIElement getWiFiIcon() {
        return this.find(".mdi-wifi-strength-4");
    }

    @JDIAction("Get '{name}' 'signal' icon")
    public UIElement getSignalIcon() {
        return this.find(".mdi-signal-cellular-outline");
    }

    @JDIAction("Get '{name}' 'battery' icon")
    public UIElement getBatteryIcon() {
        return this.find(".mdi-battery");
    }

    @JDIAction("Get '{name}' 'message' icon")
    public UIElement getMessageIcon() {
        return this.find(".mdi-message");
    }

    @JDIAction("Get '{name}' 'minus' icon")
    public UIElement getMinusIcon() {
        return this.find(".mdi-minus");
    }

    @JDIAction("Get '{name}' 'empty checkbox' icon")
    public UIElement getEmptyCheckboxIcon() {
        return this.find(".mdi-checkbox-blank-outline");
    }

    @JDIAction("Get '{name}' 'close' icon")
    public UIElement getCloseIcon() {
        return this.find(".mdi-close");
    }

    @JDIAction("Get '{name}' time")
    public String getTime() {
        return this.find("span").getText();
    }

    @JDIAction("{name} has 'Wi-Fi' icon")
    public boolean hasWiFiIcon() {
        return getWiFiIcon().isDisplayed();
    }

    @JDIAction("{name} has 'signal' icon")
    public boolean hasSignalIcon() {
        return getSignalIcon().isDisplayed();
    }

    @JDIAction("{name} has 'battery' icon")
    public boolean hasBatteryIcon() {
        return getBatteryIcon().isDisplayed();
    }

    @JDIAction("{name} has 'message' icon")
    public boolean hasMessageIcon() {
        return getMessageIcon().isDisplayed();
    }

    @JDIAction("{name} has 'minus' icon")
    public boolean hasMinusIcon() {
        return getMinusIcon().isDisplayed();
    }

    @JDIAction("{name} has 'empty checkbox' icon")
    public boolean hasEmptyCheckboxIcon() {
        return getEmptyCheckboxIcon().isDisplayed();
    }

    @JDIAction("{name} has 'close' icon")
    public boolean hasCloseIcon() {
        return getCloseIcon().isDisplayed();
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }

    public SystemBarAssert has() {
        return this.is();
    }
}
