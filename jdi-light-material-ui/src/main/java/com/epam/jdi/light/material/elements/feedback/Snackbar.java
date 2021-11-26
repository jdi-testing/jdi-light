package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.feedback.SnackbarAssert;

/**
 * To see an example of Snackbar web element please visit
 * https://material-ui.com/components/snackbars/
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasLabel {

    @JDIAction("Get {name} {0} button")
    public UIElement snackbarButton(String name) {
        return find("//*[contains(text(), '" + name + "')]");
    }


    @JDIAction("Get {name} text")
    @Override
    public String text() {
        UIElement message = find("//div[contains(@class, 'message')]");
        if (message.isExist()) {
            return message.text();
        } else {
            return core().text();
        }
    }

    @JDIAction("Close {name}")
    public void close() {
        UIElement close = find("[aria-label='close']");
        if (close.isExist()) {
            close.click();
        } else {
            find("[aria-label='Close']").click();
        }
    }

    @JDIAction("Show that the {name} message has {0} type")
    public boolean messageType(String messageType) {
        switch (messageType.toLowerCase()) {
            case "error":
                return attr("class").contains("filledError");
            case "warning":
                return attr("class").contains("filledWarning");
            case "info":
                return attr("class").contains("filledInfo");
            case "success":
                return attr("class").contains("filledSuccess");
            default:
                System.out.println("Unknown type");
                return false;
        }
    }

    @JDIAction("Show that {name} has {0} position")
    public boolean position(String type) {
        switch (type.toLowerCase()) {
            case "top right":
                return attr("class").contains("TopRight");
            case "top center":
                return attr("class").contains("TopCenter");
            case "top left":
                return attr("class").contains("TopLeft");
            case "bottom right":
                return attr("class").contains("BottomRight");
            case "bottom center":
                return attr("class").contains("BottomCenter");
            case "bottom left":
                return attr("class").contains("BottomLeft");
            default:
                System.out.println("Unknown type");
                return false;
        }
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
}
