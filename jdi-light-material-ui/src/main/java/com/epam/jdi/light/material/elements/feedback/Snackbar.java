package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.feedback.SnackbarAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;
import static com.epam.jdi.light.settings.WebSettings.logger;

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
        String msgType = messageType.toLowerCase();
        switch (msgType) {
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
                logger.error("Unknown message type %s", msgType);
                break;
        }
        return result;
    }

    @JDIAction("Show that {name} has {0} position")
    public boolean hasPosition(String align) {
        boolean result = true;
        String[] positions = align.toLowerCase().split(" ");
        for (String position: positions) {
            switch (position) {
                case "top":
                    result = result && attr("class").contains("Top");
                    break;
                case "right":
                    result = result && attr("class").contains("Right");
                    break;
                case "center":
                    result = result && attr("class").contains("Center");
                    break;
                case "left":
                    result = result && attr("class").contains("Left");
                    break;
                case "bottom":
                    result = result && attr("class").contains("Bottom");
                    break;
                default:
                    logger.error("Unknown position %s", position);
                    result = false;
                    break;
            }
        }
        return result;
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
}
