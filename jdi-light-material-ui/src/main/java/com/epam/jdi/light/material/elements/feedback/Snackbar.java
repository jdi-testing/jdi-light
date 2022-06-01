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
 * Represents Snackbar MUI component on GUI.
 * Snackbar appears at the touch of a button and provides brief notifications.
 * Notifications can provide error, warning, information or success message.
 *
 * @see <a href="https://material-ui.com/components/snackbars/">Snackbar MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */

public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasLabel {

    /**
     * Gets specific button of this snackbar using its text (full equality is used by searching).
     *
     * @param name full text content of button to be found
     * @return button of the snackbar as {@link Button}
     */
    @JDIAction("Get '{name}' '{0}' button")
    public Button snackbarButton(String name) {
        return new Button().setCore(Button.class, core().find("//*[contains(text(), '" + name + "')]"));
    }

    /**
     * Gets text message of this snackbar.
     *
     * @return snackbar text message as {@link String}
     */
    @Override
    @JDIAction("Get '{name}' text")
    public String text() {
        UIElement message = core().find("//div[contains(@class, 'message')]");
        if (message.isExist()) {
            return message.text();
        } else {
            return core().text();
        }
    }

    /**
     * Closes this snackbar.
     */
    @JDIAction("Close '{name}'")
    public void close() {
        UIElement close = core().find("[aria-label='close']");
        if (close.isExist()) {
            close.click();
        } else {
            core().find("[aria-label='Close']").click();
        }
    }

    /**
     * Gets type of message of this snackbar.
     *
     * @return type of message as {@link MessageType}
     * @throws RuntimeException if the element does not have a message type property
     */
    @JDIAction("Get '{name}' type of message")
    public MessageType messageType() {
        String messageType = core().find(".MuiAlert-root").classes().stream()
                .filter(s -> s.startsWith("MuiAlert-filled"))
                .findAny().orElse("Unknown type of message")
                .replace("MuiAlert-filled", "")
                .toLowerCase();
        if (!messageType.isEmpty()) {
            return MessageType.fromString(messageType);
        } else {
            throw runtimeException("Unknown type of message");
        }
    }

    /**
     * Gets position of this snackbar on the page.
     *
     * @return position as {@link Position}
     * @throws RuntimeException if the element does not have a position property
     */
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
