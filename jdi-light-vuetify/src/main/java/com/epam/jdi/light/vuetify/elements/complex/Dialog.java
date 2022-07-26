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

    @JDIAction("Get {name} scrollable content")
    public Card scrollableContent() {
        if (isScrollable()) {
            return new Card().setCore(Card.class, content());
        }
        throw new RuntimeException("Dialog has no scrollable content");
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

    @JDIAction("Check that {name} has visible {0} in dialog content")
    public boolean isVisibleContent(UIElement element) {
        if (isHidden()) {
            return false;
        }
        Object isInView = core().js().executeScript(
            "const rect = arguments[0].getBoundingClientRect();\n"
                + "const dialog = arguments[1].getBoundingClientRect();"
                + "if (!rect) return false;\n"
                + "const windowHeight = Math.min(window.innerHeight, document.documentElement.clientHeight, dialog.bottom);\n"
                + "const windowWidth = Math.min(window.innerWidth, document.documentElement.clientHeight, dialog.right);\n"
                + "if (rect.top < dialog.top) return false;\n"
                + "if (rect.left < dialog.left) return false;\n"
                + "if (rect.bottom > windowHeight) return false;\n"
                + "if (rect.right > windowWidth) return false;\n"
                + "return true;", element.getWebElement(), content().getWebElement());
        return (boolean) isInView;
    }

    @JDIAction("Close {name}")
    public void close() {
        if (!isPersistent()) {
            dialogWindow().focus();
            press(ESCAPE);
        } else {
            throw new RuntimeException("Dialog cannot be closed by pressing esc key");
        }
    }

    @JDIAction("Close {name} with {0} button")
    public void close(String closeButtonName) {
        VuetifyButton button = new VuetifyButton(content().find("//span[contains(text()," + closeButtonName + ")]"));
        button.click();
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}