package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.SystemBarAssert;
import com.epam.jdi.tools.Timer;

/**
 * To see examples of System Bars web elements please visit https://vuetifyjs.com/en/components/system-bars
 *
 * The v-system-bar component can be used for displaying statuses to the user.
 * It looks like the Android system bar and can contain icons, spacers, and some text.
 *
 */

public class SystemBar extends BasicBar<SystemBar, SystemBarAssert> {

    @JDIAction("Get '{name}' title")
    public UIElement getChecker() {
        return this.find(".v-input__control");
    }

    @JDIAction("Get {name} 'checker' element's state")
    public String getHeaderStatus() {
        return getHeader().getAttribute("class");
    }

    @JDIAction("Get {name} 'checker' element's state")
    public String getHeaderStyle() {
        return getHeader().getAttribute("style");
    }

    @JDIAction("{name} has icon")
    public boolean hasChecker() {
        Timer.waitCondition(this.getChecker()::isDisplayed);
        return getChecker().isClickable();
    }

    public SystemBarAssert is() {
        return new SystemBarAssert().set(this);
    }

    public SystemBarAssert has() {
        return this.is();
    }
}
