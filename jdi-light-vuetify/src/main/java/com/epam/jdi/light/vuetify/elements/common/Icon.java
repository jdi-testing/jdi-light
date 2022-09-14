package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.IconAssert;
import com.google.common.base.CaseFormat;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * To see an example of Icon web element please visit https://vuetifyjs.com/en/components/icons/
 */

public class Icon extends UIBaseElement<IconAssert> implements HasClick, HasLabel {

    private static BidiMap<String, String> map = null;

    public static List<Icon> findAll(UIBaseElement<?> rootElement) {
        return findAll(rootElement.core());
    }

    public static List<Icon> findAll(UIElement rootElement) {
        return rootElement.finds("v-icon")
                .stream().map(Icon::toIcon).collect(Collectors.toList());
    }

    public static List<Icon> finds(UIBaseElement<?> rootElement, String iconName) {
        return finds(rootElement.core(), iconName);
    }

    public static Icon find(UIBaseElement<?> rootElement, String iconName) {
        return finds(rootElement, iconName).get(0);
    }

    public static Icon toIcon(UIElement element) {
        return new Icon().setCore(Icon.class, element);
    }

    public static List<Icon> finds(UIElement rootElement, String iconName) {
        WebList elements = rootElement.finds(".mdi-" + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, iconName));
        if (elements.size() == 0) {
            elements = rootElement.finds(String.format("//*[@d='%s']/parent::*/parent::*", getMdiMap().get(iconName)));
        }
        if (elements.size() == 0) {
            elements = rootElement.finds(String.format("//*[contains(@class, 'v-icon') and text()='%s']", iconName.toLowerCase()));
        }
        if (elements.size() == 0) {
            throw new IllegalStateException("No icon with such name: " + iconName);
        }
        return elements.stream().map(Icon::toIcon).collect(Collectors.toList());
    }

    public static Icon find(UIElement rootElement, String iconName) {
        return finds(rootElement, iconName).get(0);
    }

    public static BidiMap<String, String> getMdiMap() {
        if (map == null) {
            map = new TreeBidiMap<>();
            Pattern mdiName = Pattern.compile("mdi\\w*");
            Pattern mdiPath = Pattern.compile("\"(.*)\"");
            try {
                new BufferedReader(
                        new InputStreamReader(
                                new URL("https://raw.githubusercontent.com/Templarian/MaterialDesign-JS/master/mdi.js")
                                        .openConnection()
                                        .getInputStream())
                ).lines().forEach(line -> {
                    Matcher mdiNameMatch = mdiName.matcher(line);
                    Matcher mdiPathMatch = mdiPath.matcher(line);
                    if (mdiNameMatch.find() && mdiPathMatch.find()) {
                        String name = mdiNameMatch.group().substring(3).replaceAll("(\\B[A-Z])|(\\B[0-9]+)", "_$1$2").toUpperCase();
                        map.put(name, mdiPathMatch.group(1));
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public String getMdiIconName() {
        Pattern iconPtn = Pattern.compile("(mdi-[\\w-]*)|(fa-[\\w-]*)|material-icons.*>(.*)<|path d=\"(.*)\"");
        Matcher matcher = iconPtn.matcher(core().getAttribute("outerHTML"));

        String name = null;
        if (matcher.find()) {
            if (matcher.group(1) != null) {
                name = matcher.group(1).substring(4).replace("-", "_").toUpperCase();
            } else if (matcher.group(3) != null) {
                name = matcher.group(3).toUpperCase();
            } else if (matcher.group(4) != null) {
                name = getMdiMap().getKey(matcher.group(4));
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
        } else if (core().getAttribute("innerHTML").contains("svg")) {
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
