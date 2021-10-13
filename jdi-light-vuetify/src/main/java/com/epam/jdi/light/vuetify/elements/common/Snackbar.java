package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.SnackbarAssert;

/**
 * To see an example of Checkbox web element please visit https://vuetifyjs.com/en/components/snackbars/
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText {

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
    @JDIAction("Get {name} text")
    @Override
    public String text() {
        return find(".v-snack__content").text();
    }

    @JDIAction("Close {name}")
    public void close() {
        find("button[class*='v-btn--text']").click();
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

    @JDIAction("Check that {name} is vertical")
    public boolean isVertical() {
        return core().attr("class").contains("--vertical");
    }
}
