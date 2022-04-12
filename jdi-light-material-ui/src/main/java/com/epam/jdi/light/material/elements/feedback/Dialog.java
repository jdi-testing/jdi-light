package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.feedback.DialogAssert;
import com.epam.jdi.light.material.elements.displaydata.MUIList;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.inputs.RadioButtons;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * Represents dialog MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/dialogs/">Dialog MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Dialog extends UIBaseElement<DialogAssert> {

    /**
     * Script to find scrollable content.
     */
    private static final String EXECUTE_SCRIPT = "return arguments[0].scrollHeight > arguments[0].offsetHeight;";

    /**
     * Gets the title of this dialog.
     *
     * @return title of this dialog as {@link Text}
     */
    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, core().find(".MuiDialogTitle-root"));
    }

    /**
     * Gets the list with items within the dialog.
     *
     * @return list with items within dialog as {@link MUIList}
     */
    @JDIAction("Get '{name}' list items")
    public MUIList list() {
        return new MUIList().setCore(MUIList.class, core().find(".MuiList-root"));
    }

    /**
     * Gets the text content of this dialog.
     *
     * @return text of this dialog as {@link Text}
     */
    @JDIAction("Get '{name}' text content")
    public Text textContent() {
        return new Text().setCore(Text.class, core().find(".MuiDialogContentText-root"));
    }

    /**
     * Gets the buttons within the dialog for specific actions (e.g. "Cancel", "Confirm", "Subscribe").
     *
     * @return buttons of this dialog as {@link ButtonGroup}
     */
    @JDIAction("Get '{name}' action buttons")
    public ButtonGroup actionButtons() {
        return new ButtonGroup().setCore(ButtonGroup.class, core().find(".MuiDialogActions-root"));
    }

    /**
     * Gets the radiobuttons within the dialog.
     *
     * @return radiobuttons of this dialog as {@link RadioButtons}
     */
    @JDIAction("Get '{name}' radio buttons")
    public RadioButtons radioButtons() {
        return new RadioButtons().setCore(RadioButtons.class, core().find(".MuiRadio-root"));
    }

    /**
     * Gets the text field within the dialog.
     *
     * @return text field of this dialog as {@link TextField}
     */
    @JDIAction("Get '{name}' text field")
    public TextField textField() {
        return new TextField().setCore(TextField.class, core().find(".MuiTextField-root"));
    }

    /**
     * Checks if dialog has scrollable content or not.
     *
     * @return {@code true} if this dialog has scrollable content, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has scrollable content")
    public boolean hasScrollableContent() {
        return jsExecute(EXECUTE_SCRIPT, core().find(".MuiDialogContent-root").getFast());
    }

    /**
     * Scrolls dialog content to specified height.
     *
     * @param scrollHeight height to which the scrolling is performed
     */
    @JDIAction("Scroll '{name}' to height '{0}'")
    public void scrollContentTo(int scrollHeight) {
        jsExecute(String.format("arguments[0].scroll(0, %s)", scrollHeight), core().find(".MuiDialogContent-root").getFast());
    }

    /**
     * Checks if dialog has scrollable body or not.
     *
     * @return {@code true} if this dialog has scrollable body, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' has scrollable body")
    public boolean hasScrollableBody() {
        return jsExecute(EXECUTE_SCRIPT, core().getFast());
    }

    /**
     * Scrolls dialog body to specified height.
     *
     * @param scrollHeight height to which the scrolling is performed
     */
    @JDIAction("Scroll '{name}' to height '{0}'")
    public void scrollDialogBodyTo(int scrollHeight) {
        jsExecute(String.format("arguments[0].scroll(0, %s)", scrollHeight), core().getFast());
    }

    /**
     * Closes this dialog with a button named "close" if it exists, otherwise does nothing.
     */
    @JDIAction("Close '{name}' with 'close' button")
    public void close() {
        close("close");
    }

    /**
     * Closes this dialog with specified button.
     *
     * @param closeButtonName the name of the button to close the dialog
     * @throws RuntimeException if the element does not have a button with the specified name
     */
    @JDIAction("Close '{name}' with {0} button")
    public void close(String closeButtonName) {
        actionButtons().getAllButtons().stream()
                .filter(button -> button.getValue().equalsIgnoreCase(closeButtonName))
                .findFirst()
                .orElseThrow(() -> runtimeException(String.format("Close button %s not found", closeButtonName)))
                .click();
    }

    /**
     * Confirms and closes this dialog with a button named "ok" if it exists, otherwise does nothing.
     */
    @JDIAction("Confirm and close '{name}' with 'ok' button")
    public void confirm() {
        confirm("ok");
    }

    /**
     * Confirms and closes this dialog with specified button.
     *
     * @param confirmButtonName the name of the button to confirm and close the dialog
     * @throws RuntimeException if the element does not have a button with the specified name
     */
    @JDIAction("Confirm and close '{name}' with {0} button")
    public void confirm(String confirmButtonName) {
        actionButtons().getAllButtons().stream()
                .filter(button -> button.getValue().equalsIgnoreCase(confirmButtonName))
                .findFirst()
                .orElseThrow(() -> runtimeException(String.format("Confirm button %s not found", confirmButtonName)))
                .click();
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}
