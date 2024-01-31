package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.DialogAssert;
import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.enums.DialogPosition;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import org.openqa.selenium.Keys;

/**
 * To see an example of Dialog web element please visit https://material.angular.io/components/dialog/overview.
 */

public class Dialog extends UIBaseElement<DialogAssert> {

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }

    @JDIAction("Close '{name}'")
    public void close() {
        core().focus();
        press(Keys.ESCAPE);
//        if (isOpened()) {
//            throw runtimeException("Dialog cannot be closed by pressing esc key");
//        }
    }

    @JDIAction("Close '{name}' with '{0}' button")
    public void close(String closeButtonName) {
        Button button = new Button().setCore(Button.class, core().find("//span[contains(text(), '" + closeButtonName + "')]"));
        button.click();
    }

    @JDIAction("Check that '{name}' is open")
    public boolean isOpened() {
        return core().isDisplayed();
    }

    @JDIAction("Check that '{name}' is close")
    public boolean isClosed() {
        return !isOpened();
    }

    @JDIAction("Get '{name}' dialog actions align")
    public DialogPosition dialogActionsAlign() {
        return DialogPosition.from(core().find("mat-dialog-actions").css("justify-content"));
    }

    @JDIAction("Get '{name}' max height")
    public String maxHeight() {
        return core().css("max-height");
    }

    @JDIAction("Get '{name}' mix height")
    public String minHeight() {
        return core().css("min-height");
    }

    @JDIAction("Get '{name}' max width")
    public String maxWidth() {
        return core().css("max-width");
    }

    @JDIAction("Get '{name}' mix width")
    public String minWidth() {
        return core().css("min-width");
    }

    @JDIAction("Get '{name}' height")
    public String height() {
        return core().css("height");
    }

    @JDIAction("Get '{name}' animation duration")
    public String animationDuration() {
        return core().attr("style").substring(34).replace(";", "");
    }
}
