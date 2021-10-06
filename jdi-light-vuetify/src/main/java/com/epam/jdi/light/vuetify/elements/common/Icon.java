package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.IconAssert;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * To see an example of Banner web element please visit https://jdi-testing.github.io/jdi-light/vuetify/icons
 *
 * From vuetify docs: "The v-icon component provides a large set of glyphs to provide context to various aspects
 * of your application."
 *
 */

public class Icon extends UIBaseElement<IconAssert> implements HasClick {

    @JDIAction("Get {name} type")
    public String getType() throws Exception {
        String iconClass = this.core().getAttribute("class");
        if(iconClass.contains("mdi-")) {
            return Arrays.stream(iconClass.split(" "))
                    .filter(s -> s.startsWith("mdi-")).collect(Collectors.joining());
        } else if(iconClass.contains("fa-")) {
            return Arrays.stream(iconClass.split(" "))
                    .filter(s -> s.startsWith("fa-")).collect(Collectors.joining());
        } else if(iconClass.contains("material-icons")) {
            return this.core().getText();
        } else if (iconClass.contains("v-icon notranslate")){
            return "svg icon";
        } else throw new Exception("unknown type of icon");
    }

    @JDIAction("Get {name} color")
    public String getColor() {
        return this.core().getCssValue("color");
    }

    @JDIAction("Get {name} color")
    public String getHeight() {
        return this.core().getCssValue("height");
    }

    @JDIAction("Get {name} color")
    public String getWidth() {
        return this.core().getCssValue("width");
    }

    @JDIAction("{name} has alert after clicking on it")
    public String hasAlertOnIconClick() {
        return this.core().driver().switchTo().alert().getText();
    }

    public void handleAlert() {
        this.core().driver().switchTo().alert().dismiss();
    }

    public IconAssert is() {
        return new IconAssert().set(this);
    }

    public IconAssert has() {
        return this.is();
    }
}
