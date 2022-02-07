package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.feedback.SnackbarAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * To see an example of Snackbar web element please visit
 * https://material-ui.com/components/snackbars/
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasLabel {

    @JDIAction("Get {name} {0} button")
    public Button snackbarButton(String name) {
        return new Button().setCore(Button.class, find("//*[contains(text(), '" + name + "')]"));
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
        boolean result = false;
        switch (messageType.toLowerCase()) {
            case "error":
                result = attr("class").contains("filledError");
                break;
            case "warning":
                result =  attr("class").contains("filledWarning");
                break;
            case "info":
                result = attr("class").contains("filledInfo");
                break;
            case "success":
                result = attr("class").contains("filledSuccess");
                break;
            default:
                System.out.println("Unknown type");
                break;
        }
        return result;
    }

    @JDIAction("Show that {name} has {0} position")
    public boolean hasPosition(String type) {
        boolean result = false;
        switch (type.toLowerCase()) {
            case "top right":
                result = attr("class").contains("TopRight");
                break;
            case "top center":
                result = attr("class").contains("TopCenter");
                break;
            case "top left":
                result = attr("class").contains("TopLeft");
                break;
            case "bottom right":
                result = attr("class").contains("BottomRight");
                break;
            case "bottom center":
                result = attr("class").contains("BottomCenter");
                break;
            case "bottom left":
                result = attr("class").contains("BottomLeft");
                break;
            default:
                System.out.println("Unknown type");
                break;
        }
        return result;
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
}
