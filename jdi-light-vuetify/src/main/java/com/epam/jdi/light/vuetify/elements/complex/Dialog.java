package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.DialogAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

import static org.openqa.selenium.Keys.ESCAPE;

/**
 * To see example of Dialog web element please visit https://vuetifyjs.com/en/components/dialogs/
 */
public class Dialog extends UIBaseElement<DialogAssert> implements HasAssert<DialogAssert> {

    public UIElement dialogWindow() {
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

    @JDIAction("Scroll {name} to position '{0}'")
    public void scrollToPosition(int y) {
        Card card = new Card().setCore(Card.class, content());
        card.content().jsExecute("scrollTo(0," + y + ")");
    }

    @JDIAction("Close {name}")
    public void close() {
        if (!isPersistent()) {
            core().focus();
            press(ESCAPE);
        } else {
            throw new RuntimeException("Dialog cannot be closed by pressing esc key");
        }
    }

    @JDIAction("Close {name} with {0} button")
    public void close(String closeButtonName) {
        VuetifyButton button = new VuetifyButton(core().find("//span[contains(text()," + closeButtonName + ")]"));
        button.click();
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}