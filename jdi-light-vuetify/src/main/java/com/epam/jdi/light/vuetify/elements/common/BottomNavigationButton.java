package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class BottomNavigationButton extends Button {

    public BottomNavigationButton() {
    }

    @JDIAction("Get {name} icon")
    public boolean hasIcon() {
        return core().find(css("i")).hasClass("v-icon");
    }

    @JDIAction("Get {name} text")
    public String getText() {
        return core().firstChild().find(css("span")).getText();
    }

    @JDIAction("Get {name} width")
    public String getWidth() {
        return core().getCssValue("width");
    }

    @JDIAction("Get {name} direction")
    public String getDirection() {
        return core().firstChild().getCssValue("flex-direction");
    }

    @JDIAction("Get {name} color")
    public String getColor() {
        return core().getCssValue("color");
    }
}
