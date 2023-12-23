package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.IconAssert;

import com.epam.jdi.light.vuetify.interfaces.HasAlignment;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasCursor;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * To see an example of Icon web element please visit https://vuetifyjs.com/en/components/icons/
 */

public class Icon extends UIBaseElement<IconAssert> implements HasClick, HasLabel, HasCursor,
    HasAlignment, HasTheme, HasMeasurement, HasColor {

    //TODO: implement SVG icon class, implement name, getNameByType methods, map SVG path to a name, example commit: @cbc6e414c1e9edeb853b57e5a3f7007930d500fe
    public String getMdiIconName() {
        Pattern iconPtn = Pattern.compile("(mdi-[\\w-]*)");
        Matcher matcher = iconPtn.matcher(core().getAttribute("outerHTML"));

        String name = null;
        if (matcher.find()) {
            if (matcher.group(1) != null) {
                name = matcher.group(1).substring(4).replace("-", "_").toUpperCase();
            } else {
                throw new IllegalStateException(core().attr("class") + " is not Material Design Icon");
            }
        }
        return name;
    }

    private String getType() {
        String res = null;
        String iconClass = core().getAttribute("class");
        if (iconClass.contains("mdi-")) {
            res = Arrays.stream(iconClass.split(" "))
                .filter(s -> s.startsWith("mdi-")).collect(Collectors.joining());
        } else if (iconClass.contains("fa-")) {
            res = Arrays.stream(iconClass.split(" "))
                .filter(s -> s.startsWith("fa-")).collect(Collectors.joining());
        } else if (iconClass.contains("material-icons")) {
            res = core().getText();
        } else if (iconClass.contains("v-icon notranslate")) {
            res = "svg icon";
        }
        return res;
    }

    @JDIAction("Get '{name}' type")
    public String type() {
        return Objects.requireNonNull(getType());
    }

    @JDIAction("'{name}' has alert after clicking on it")
    public String hasAlertOnIconClick() {
        return core().driver().switchTo().alert().getText();
    }

    @JDIAction("Dismiss '{name}' alert")
    public void dismissAlert() {
        core().driver().switchTo().alert().dismiss();
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().getAttribute("class").contains("v-icon--disabled");
    }

    @JDIAction("Check that '{name}' is Accessible")
    public boolean isAccessible() {
        return core().getAttribute("aria-hidden").contains("true");
    }

    public IconAssert is() {
        return new IconAssert().set(this);
    }

    public IconAssert has() {
        return is();
    }
}
