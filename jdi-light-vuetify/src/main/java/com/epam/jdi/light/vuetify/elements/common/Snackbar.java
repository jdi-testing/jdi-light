package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.SnackbarAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.HasOrientation;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasStyledText;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.HasAlignment;

/**
 * To see an example of Checkbox web element please visit https://v2.vuetifyjs.com/en/components/snackbars/
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasTheme, HasOrientation,
        IsOutlined, HasColor, HasRounded, HasElevation, HasMeasurement, HasStyledText, IsShaped, HasAlignment {

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }

    @JDIAction("Get {name} text")
    @Override
    public String text() {
        return core().find(".v-snack__content").text();
    }

    @JDIAction("Get if {name} is open")
    public boolean isOpen() {
        return core().attr("class").contains("--active");
    }

    @JDIAction("Get if {name} is close")
    public boolean isClosed() {
        return !isOpen();
    }

    @JDIAction("Get if {name} is centered")
    public boolean isCentered() {
        return core().attr("class").contains("--centered");
    }

    @JDIAction("Get if {name} is on top")
    public boolean isTop() {
        return core().attr("class").contains("--top");
    }

    @JDIAction("Get if {name} is on bottom")
    public boolean isBottom() {
        return core().attr("class").contains("--bottom");
    }

    @JDIAction("Get if {name} is multilined")
    public boolean isMultiLine() {
        return core().attr("class").contains("--multi-line");
    }

    @Override
    @JDIAction("Get if {name} is shaped")
    public boolean isShaped() {
        return core().find(".v-snack__wrapper").attr("class").contains("--shaped");
    }

    @Override
    @JDIAction("Get if {name} is elevated")
    public boolean isElevated() {
        return core().find(".v-snack__wrapper").attr("class").contains("elevation-");
    }

    @JDIAction("Get if {name} is outlined")
    public boolean isOutlined() {
        return core().find(".v-snack__wrapper").attr("class").contains("--outlined");
    }

    @Override
    @JDIAction("Get 'name' color")
    public String theme() {
        return core().find(".v-snack__wrapper").classes().stream()
                .filter(value -> value.contains("theme--"))
                .findFirst()
                .get();
    }

    @Override
    @JDIAction("Get '{name}' color")
    public String color() {
        return core().find(".v-snack__wrapper").getCssValue("color");
    }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return core().find(".v-snack__wrapper").getCssValue("background-color");
    }

    @Override
    @JDIAction("Get '{name}' height")
    public int height() {
        return core().find(".v-snack__wrapper").getRect().getHeight();
    }

    @Override
    @JDIAction("Get '{name}' width")
    public int width() {
        return core().find(".v-snack__wrapper").getRect().getWidth();
    }

    @Override
    public String wrapperLocator() {
        return ".v-snack__wrapper";
    }
}
