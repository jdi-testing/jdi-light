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

/**
 * To see an example of Snackbar web element please visit
 * https://material-ui.com/components/snackbars/
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasLabel {

    @JDIAction("Get '{name}' '{0}' button")
    public Button snackbarButton(String name) {
        return new Button().setCore(Button.class, core().find("//*[contains(text(), '" + name + "')]"));
    }

    @JDIAction("Get '{name}' text")
    @Override
    public String text() {
        UIElement message = core().find("//div[contains(@class, 'message')]");
        if (message.isExist()) {
            return message.text();
        } else {
            return core().text();
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        UIElement close = core().find("[aria-label='close']");
        if (close.isExist()) {
            close.click();
        } else {
            core().find("[aria-label='Close']").click();
        }
    }

    @JDIAction("Get '{name}' type of message")
    public MessageType messageType() {
        String position = core().classes().stream()
                .filter(s -> s.startsWith("MuiAlert-filled"))
                .findAny().orElse("Unknown type of message")
                .replace("MuiAlert-filled", "")
                .toLowerCase();
        if (!position.isEmpty()) {
            return MessageType.fromString(position);
        } else {
            throw runtimeException("Unknown type of message");
        }
    }

    @JDIAction("Get '{name}' position")
    public Position position() {
        String position = Arrays.stream(core().attr("class")
                        .split("[^a-zA-Z0-9]"))
                .map(String::toLowerCase)
                .filter(s -> s.contains("anchor"))
                .findAny().orElse("Unknown position")
                .replace("anchororigin", "");
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
