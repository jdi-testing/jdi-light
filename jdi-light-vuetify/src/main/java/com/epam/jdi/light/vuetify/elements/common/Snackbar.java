package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.SnackbarAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.HasOrientation;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.IsTile;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasStyledText;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.HasAlignment;

/**
 * To see an example of Checkbox web element please visit https://vuetifyjs.com/en/components/snackbars/
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasTheme, HasOrientation,
        IsOutlined, HasColor, HasRounded, HasElevation, IsTile, HasMeasurement, HasStyledText, IsShaped, HasAlignment {

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }

    @JDIAction("Get {name} text")
    @Override
    public String text() {
        return core().find(".v-snack__content").text();
    }

    @JDIAction("Check {name} is open")
    public boolean isOpen() {
        return core().attr("class").contains("--active");
    }

    @JDIAction("Check {name} is close")
    public boolean isClosed() {
        return !isOpen();
    }

    @JDIAction("Check that {name} is centered")
    public boolean isCentered() {
        return core().attr("class").contains("--centered");
    }

    @JDIAction("Check that {name} is top")
    public boolean isTop() {
        return core().attr("class").contains("--top");
    }

    @JDIAction("Check that {name} is bottom")
    public boolean isBottom() {
        return core().attr("class").contains("--bottom");
    }

    @JDIAction("Check that {name} is multi-line")
    public boolean isMultiLine() {
        return core().attr("class").contains("--multi-line");
    }

    @Override
    @JDIAction("Check that {name} is shaped")
    public boolean isShaped() {
        return core().find(".v-snack__wrapper").attr("class").contains("--shaped");
    }

    @Override
    @JDIAction("Check that {name} is rounded")
    public boolean isRounded() {
        return core().find(".v-snack__wrapper").attr("class").matches(".* rounded-[^0][\\S]* .*");
    }

    @Override
    @JDIAction("Check that {name} is elevated")
    public boolean isElevated() {
        return core().find(".v-snack__wrapper").attr("class").contains("elevation-");
    }

    @JDIAction("Check that {name} is outlined")
    public boolean isOutlined() {
        return core().find(".v-snack__wrapper").attr("class").contains("--outlined");
    }

    @JDIAction("Check that {name} is tile")
    public boolean isTile() {
        return core().find(".v-snack__wrapper").attr("class").contains("rounded-0");
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
    public String color() { return core().find(".v-snack__wrapper").getCssValue("color"); }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() { return core().find(".v-snack__wrapper").getCssValue("background-color"); }

    @Override
    @JDIAction("Get '{name}' height")
    public int height() { return core().find(".v-snack__wrapper").getRect().getHeight(); }

    @Override
    @JDIAction("Get '{name}' width")
    public int width() { return core().find(".v-snack__wrapper").getRect().getWidth(); }
}
