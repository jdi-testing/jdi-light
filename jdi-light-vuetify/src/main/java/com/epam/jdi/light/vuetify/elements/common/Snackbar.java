package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.SnackbarAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

/**
 * To see an example of Checkbox web element please visit https://vuetifyjs.com/en/components/snackbars/
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasTheme {

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

    @JDIAction("Check that {name} position is left")
    public boolean isLeft() {
        return core().attr("class").contains("--left");
    }

    @JDIAction("Check that {name} position is right")
    public boolean isRight() {
        return core().attr("class").contains("--right");
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

    @JDIAction("Check that {name} is vertical")
    public boolean isVertical() {
        return core().attr("class").contains("--vertical");
    }

    @JDIAction("Check that {name} is multi-line")
    public boolean isMultiLine() {
        return core().attr("class").contains("--multi-line");
    }

    @JDIAction("Check that {name} is shaped")
    public boolean isShaped() {
        return core().find(".v-snack__wrapper").attr("class").contains("--shaped");
    }

    @JDIAction("Check that {name} is rounded")
    public boolean isRounded() {
        return core().find(".v-snack__wrapper").attr("class").matches(".* rounded-[^0][\\S]* .*");
    }

    @JDIAction("Check that {name} is elevated")
    public boolean isElevated() {
        return core().find(".v-snack__wrapper").attr("class").contains("elevation-");
    }

    @JDIAction("Check that {name} is text")
    public boolean isText() {
        return core().attr("class").contains("--text");
    }

    @JDIAction("Check that {name} is outlined")
    public boolean isOutlined() {
        return core().find(".v-snack__wrapper").attr("class").contains("--outlined");
    }

    @Override
    @JDIAction("Check that {name} has light theme")
    public boolean isLightTheme() {
        return core().find(".v-snack__wrapper").hasClass("theme--light");
    }

    @Override
    @JDIAction("Check that {name} has dark theme")
    public boolean isDarkTheme() {
        return core().find(".v-snack__wrapper").hasClass("theme--dark");
    }

    @JDIAction("Get '{name}' color")
    public String color() { return core().find(".v-snack__wrapper").getCssValue("background-color"); }

    @JDIAction("Get '{name}' height")
    public int height() { return core().find(".v-snack__wrapper").getRect().getHeight(); }

    @JDIAction("Get '{name}' width")
    public int width() { return core().find(".v-snack__wrapper").getRect().getWidth(); }
}
