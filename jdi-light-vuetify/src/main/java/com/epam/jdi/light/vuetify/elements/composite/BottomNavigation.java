package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.BottomNavigationAssert;

/**
 * To see example of Bottom Navigation web element please visit https://vuetifyjs.com/en/components/bottom-navigation/
 */

public class BottomNavigation extends UIBaseElement<BottomNavigationAssert> {

    @JDIAction("Get {name} background color")
    public String getBackgroundColor() {
        return core().getCssValue("background-color");
    }

    @JDIAction("Grt {name} class attribute")
    public String getClassAttribute() {
        return core().getAttribute("class");
    }

    @JDIAction("Grt {name} class attribute")
    public String getStyleAttribute() {
        return core().getAttribute("style");
    }

    @JDIAction("Get {name} transform")
    public String getTransform() {
        return core().getCssValue("transform");
    }

    @JDIAction("Get {name} list of buttons")
    public WebList bottomNavigationButtonList() {
        return core().finds("//button");
    }

    @JDIAction("Get {name} button by index")
    public String getButtonColor(int index) {
        return core().finds("//button").get(index).getCssValue("color");
    }

    @JDIAction("Get {name} button width")
    public String getButtonWight(int index) {
        return core().finds("//button").get(index).getCssValue("width");
    }

    @JDIAction("Get {name} button direction")
    public String getButtonDirection(int index) {
        return core().finds("//button").get(index).firstChild().getCssValue("flex-direction");
    }

    @JDIAction("Get {name} button text")
    public String getButtonText(int index) {
        try {
            return core().finds("//button").get(index).find("//span/span").getText();
        } catch (RuntimeException e) {
            return "Text is not visible";
        }
    }

    public BottomNavigationAssert is() {
        return new BottomNavigationAssert().set(this);
    }
}
