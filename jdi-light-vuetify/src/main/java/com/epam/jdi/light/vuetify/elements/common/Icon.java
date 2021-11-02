package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.IconAssert;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * To see an example of Icon web element please visit https://vuetifyjs.com/en/components/icons/
 */

public class Icon extends UIBaseElement<IconAssert> implements HasClick  {

    @JDIAction("Get '{name}' type")
    private String getType() {
        String iconClass = core().getAttribute("class");
        if(iconClass.contains("mdi-")) {
            return Arrays.stream(iconClass.split(" "))
                    .filter(s -> s.startsWith("mdi-")).collect(Collectors.joining());
        } else if(iconClass.contains("fa-")) {
            return Arrays.stream(iconClass.split(" "))
                    .filter(s -> s.startsWith("fa-")).collect(Collectors.joining());
        } else if(iconClass.contains("material-icons")) {
            return core().getText();
        } else if (iconClass.contains("v-icon notranslate")){
            return "svg icon";
        } else return  null;
    }

    @JDIAction("'{name}' has color")
    public String hasColor() {
        return core().getCssValue("color");
    }

    @JDIAction("'{name}' has height")
    public String hasHeight() {
        return core().getCssValue("height");
    }

    @JDIAction("'{name}' has width")
    public String hasWidth() {
        return core().getCssValue("width");
    }

    @JDIAction("'{name}' has type")
    public String hasType() {
        return Objects.requireNonNull(getType());
    }

    @JDIAction("'{name}' has alert after clicking on it")
    public String hasAlertOnIconClick() {
        return core().driver().switchTo().alert().getText();
    }

    public void handleAlert() {
        core().driver().switchTo().alert().dismiss();
    }

    public IconAssert is() {
        return new IconAssert().set(this);
    }

    public IconAssert has() {
        return is();
    }
}
