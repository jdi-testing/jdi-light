package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.feedback.SnackbarAssert;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.ui.html.elements.common.Button;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * Represents Snackbar MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/snackbars/">Snackbar MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Snackbar extends UIBaseElement<SnackbarAssert> implements IsText, HasLabel {

    /**
     * Gets a snackbar by given name (partial equality is used).
     *
     * @param name expected snackbar partial name
     * @return the found snackbar as {@link Button}
     */
    @JDIAction("Get {name} {0} button")
    public Button snackbarButton(String name) {
        return new Button().setCore(Button.class, find("//*[contains(text(), '" + name + "')]"));
    }

    /**
     * Gets the text content of this snackbar.
     *
     * @return the text content of this snackbar as {@link String}
     */
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

    /**
     * Closes this snackbar.
     */
    @JDIAction("Close {name}")
    public void close() {
        UIElement close = find("[aria-label='close']");
        if (close.isExist()) {
            close.click();
        } else {
            find("[aria-label='Close']").click();
        }
    }

    /**
     * Checks that the snackbar message is of the given type (e.g. error message, success message) or not.
     *
     * @param messageType expected message type
     * @return {@code true} if the message type of this snackbar matches given message type, otherwise {@code false}
     */
    @JDIAction("Show that the {name} message has {0} type")
    public boolean messageType(String messageType) {
        boolean result = false;
        String msgType = messageType.toLowerCase();
        switch (msgType) {
        case "error":
            result = core().hasClass("MuiAlert-filledError");
            break;
        case "warning":
            result = core().hasClass("MuiAlert-filledWarning");
            break;
        case "info":
            result = core().hasClass("MuiAlert-filledInfo");
            break;
        case "success":
            result = core().hasClass("MuiAlert-filledSuccess");
            break;
        default:
            logger.error("Unknown message type %s", msgType);
            break;
        }
        return result;
    }

    /**
     * Checks that the snackbar is at the given position (e.g. top left, bottom center) or not.
     *
     * @param align expected snackbar position
     * @return {@code true} if the snackbar is at the given position, otherwise {@code false}
     */
    @JDIAction("Show that {name} has {0} position")
    public boolean hasPosition(Position align) {
        boolean result = true;
        String[] positions = align.name().toLowerCase().split("_");
        for (String position : positions) {
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
