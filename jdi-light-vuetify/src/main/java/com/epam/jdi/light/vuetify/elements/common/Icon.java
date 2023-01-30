package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.IconAssert;

import com.epam.jdi.light.vuetify.interfaces.HasAlignment;
import com.epam.jdi.light.vuetify.interfaces.HasCursor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

/**
 * To see an example of Icon web element please visit https://vuetifyjs.com/en/components/icons/
 */

public class Icon extends UIBaseElement<IconAssert> implements HasClick, HasLabel, HasCursor,
    HasAlignment, HasTheme {

    public String getMdiIconName() {
        Pattern iconPtn = Pattern.compile("(mdi-[\\w-]*)");
        Matcher matcher = iconPtn.matcher(core().getAttribute("outerHTML"));

        String name = null;
        if (matcher.find()) {
            if (matcher.group(1) != null) {
                name = matcher.group(1).substring(4).replace("-", "_").toUpperCase();
            } else {
                throw new IllegalStateException(attr("class") + " is not Material Design Icon");
            }
        }
        return name;
    }

    @JDIAction("Get '{name}' type")
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
