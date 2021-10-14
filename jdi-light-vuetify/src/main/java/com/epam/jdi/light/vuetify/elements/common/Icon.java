package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.IconAssert;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * To see an example of Icon web element please visit https://vuetifyjs.com/en/components/icons/
 */

public class Icon extends UIBaseElement<IconAssert> implements HasClick  {

    @JDIAction("Get {name} type")
    private String getType() throws Exception {
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

    @JDIAction("{name} has expected color")
    public boolean hasColor(String color) {
        return this.core().getCssValue("color").equals(color);
    }

    @JDIAction("{name} has expected height")
    public boolean hasHeight(String height) {
        return this.core().getCssValue("height").equals(height);
    }

    @JDIAction("{name} has expected width")
    public boolean hasWidth(String width) {
        return this.core().getCssValue("width").equals(width);
    }

    @JDIAction("{name} has expected type")
    public boolean hasType(String iconType) throws Exception {
        return this.getType().equals(iconType);
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
