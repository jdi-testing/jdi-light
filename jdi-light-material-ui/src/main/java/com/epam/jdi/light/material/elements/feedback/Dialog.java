package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.feedback.DialogAssert;
import com.epam.jdi.light.material.elements.displaydata.list.SimpleList;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.inputs.RadioButtons;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * Represents dialog MUI component on GUI.
 *
 * @see <a href="https://v4.mui.com/components/dialogs/">Dialog MUI documentation</a>
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
     * @return list with items within dialog as {@link SimpleList}
     */
    // @todo #5431 looks like list is not a required part of Dialog, should be removed
    @JDIAction("Get '{name}' list items")
    public SimpleList list() {
        return new SimpleList().setCore(SimpleList.class, core().find(".MuiList-root"));
    }

    public UIElement content() {
        return core().find(".MuiDialogContent-root");
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
    // @todo #5341 this is not a ButtonGroup, Dialog is only a container
    @JDIAction("Get '{name}' action buttons")
    public ButtonGroup actionButtons() {
        return new ButtonGroup().setCore(ButtonGroup.class, core().find(".MuiDialogActions-root"));
    }

    /**
     * Gets the radioButtons within the dialog.
     *
     * @return radioButtons of this dialog as {@link RadioButtons}
     */
    // @todo #5431 radiobuttons is not a part of standard dialog, should be removed
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
     * Closes this dialog with a button named "close" if it exists.
     *
     * @throws RuntimeException if 'close' button doesn't exist
     */
    @JDIAction("Close '{name}' dialog")
    public void close() {
        core().actions(a -> a.sendKeys(Keys.ESCAPE));
        waitCondition(() -> core().isHidden());
    }

    /**
     * Clicks on button by name
     *
     * @param buttonName button label to look for
     * @throws RuntimeException if the element does not have a button with the specified name
     */
    @JDIAction("Click '{0}' button on '{name}'")
    public void clickButton(String buttonName) {
        actionButtons().buttons().stream()
                .filter(button -> button.getValue().equalsIgnoreCase(buttonName))
                .findFirst()
                .orElseThrow(() -> runtimeException(String.format("Close button %s not found", buttonName)))
                .click();
    }

    /**
     * Confirms and closes this dialog with a button named "ok" if it exists
     *
     * @throws RuntimeException if 'ok' button doesn't exist
     */
    @JDIAction("Confirm and close '{name}' with 'ok' button")
    public void confirm() {
        clickButton("ok");
    }

    /**
     * Closes this dialog with a button named "cancel" if it exists.
     *
     * @throws RuntimeException if 'cancel' button doesn't exist
     */
    @JDIAction("Click Cancel button")
    public void cancel() {
        clickButton("cancel");
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}
