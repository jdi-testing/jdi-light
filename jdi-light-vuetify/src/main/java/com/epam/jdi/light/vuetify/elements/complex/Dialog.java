package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.DialogAssert;

import static com.epam.jdi.light.common.ElementArea.BOTTOM_RIGHT;
import static org.openqa.selenium.Keys.ESCAPE;

/**
 * To see example of Dialog web element please visit https://vuetifyjs.com/en/components/dialogs/
 */
public class Dialog extends UIBaseElement<DialogAssert> implements HasAssert<DialogAssert> {

    protected UIElement dialogWindow() {
        return core().find(".v-dialog");
    }

    @JDIAction("Get {name} content")
    public UIElement content() {
        return dialogWindow().firstChild();
    }

    @JDIAction("Check that {name} is active")
    public boolean isActive() {
        return dialogWindow().hasClass("v-dialog--active");
    }

    @JDIAction("Check that {name} is opened")
    public boolean isOpened() {
        return isActive();
    }

    @JDIAction("Check that {name} is closed")
    public boolean isClosed() {
        return !isActive();
    }

    @JDIAction("Check that {name} is fullscreen")
    public boolean isFullscreen() {
        return dialogWindow().hasClass("v-dialog--fullscreen");
    }

    @JDIAction("Check that {name} is persistent")
    public boolean isPersistent() {
        return dialogWindow().hasClass("v-dialog--persistent");
    }

    @JDIAction("Check that {name} is scrollable")
    public boolean isScrollable() {
        return dialogWindow().hasClass("v-dialog--scrollable");
    }

    @JDIAction("Close {name}")
    public void close() {
        if (!isPersistent()) {
            core().click(BOTTOM_RIGHT);
            press(ESCAPE);
        }
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}