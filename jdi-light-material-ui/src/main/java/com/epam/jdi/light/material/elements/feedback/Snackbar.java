package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.feedback.SnackbarAssert;
import com.epam.jdi.light.material.elements.utils.enums.MessageType;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.util.Arrays;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * To see an example of Snackbar web element please visit
 * https://material-ui.com/components/snackbars/
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasLabel {

    @JDIAction("Get '{name}' '{0}' button")
    public Button snackbarButton(String name) {
        return new Button().setCore(Button.class, find("//*[contains(text(), '" + name + "')]"));
    }

    @JDIAction("Get '{name}' text")
    @Override
    public String text() {
        UIElement message = find("//div[contains(@class, 'message')]");
        if (message.isExist()) {
            return message.text();
        } else {
            return core().text();
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        UIElement close = find("[aria-label='close']");
        if (close.isExist()) {
            close.click();
        } else {
            find("[aria-label='Close']").click();
        }
    }

    @JDIAction("Show that the '{name}' message has '{0}' type")
    public boolean messageType(MessageType messageType) {
        boolean result = false;
        switch (messageType) {
            case ERROR:
                result = core().hasClass("MuiAlert-filledError");
                break;
            case WARNING:
                result =  core().hasClass("MuiAlert-filledWarning");
                break;
            case INFO:
                result = core().hasClass("MuiAlert-filledInfo");
                break;
            case SUCCESS:
                result = core().hasClass("MuiAlert-filledSuccess");
                break;
            default:
                logger.error("Unknown message type %s", messageType);
                break;
        }
        return result;
    }

    @JDIAction("Get '{name}' position")
    public Position position() {
        String position = Arrays.stream(core().attr("class")
                        .split("[^a-zA-Z0-9]"))
                .map(String::toLowerCase)
                .filter(s -> s.contains("anchor"))
                .findAny().orElse("Unknown position")
                .replace("anchororigin", "");
        System.out.println(position);
        if (!position.isEmpty()) {
            return Position.fromString(position);
        } else {
            throw runtimeException("Unknown position");
        }
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }
}
