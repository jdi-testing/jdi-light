package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.feedback.DialogAssert;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.inputs.RadioButtons;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

/**
 * To see an example of Dialog web element please visit
 * https://mui.com/components/dialogs/
 */

public class Dialog extends UIBaseElement<DialogAssert> {

    private static final String EXECUTE_SCRIPT = "return arguments[0].scrollHeight > arguments[0].offsetHeight;";

    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, find(".MuiDialogTitle-root"));
    }

    @JDIAction("Get '{name}' list items")
    public List list() {
        return new List(find(".MuiList-root"));
    }

    @JDIAction("Get '{name}' text content")
    public Text textContent() {
        return new Text().setCore(Text.class, find(".MuiDialogContentText-root"));
    }

    @JDIAction("Get '{name}' action buttons")
    public ButtonGroup actions() {
        return new ButtonGroup().setCore(ButtonGroup.class, find(".MuiDialogActions-root"));
    }

    @JDIAction("Get '{name}' radio buttons")
    public RadioButtons radioButtons() {
        return new RadioButtons().setCore(RadioButtons.class, find(".MuiRadio-root"));
    }

    @JDIAction("Get '{name}' input field")
    public TextField input() {
        return new TextField().setCore(TextField.class, find(".MuiTextField-root"));
    }

    @JDIAction("Check that '{name}' has scrollable content")
    public Boolean hasScrollableContent() {
        return jsExecute(EXECUTE_SCRIPT, find(".MuiDialogContent-root").getFast());
    }

    @JDIAction("Scroll '{name}' to target height")
    public void scrollContentTo(int scrollHeight) {
        jsExecute(String.format("arguments[0].scroll(0, %s)", scrollHeight), find(".MuiDialogContent-root").getFast());
    }

    @JDIAction("Check that '{name}' has scrollable body")
    public Boolean hasScrollableBody() {
        return jsExecute(EXECUTE_SCRIPT, core().getFast());
    }

    @JDIAction("Scroll '{name}' to target height")
    public void scrollDialogBodyTo(int scrollHeight) {
        jsExecute(String.format("arguments[0].scroll(0, %s)", scrollHeight), core().getFast());
    }

    @JDIAction("Close '{name}'")
    public void close() {
        close("close");
    }

    @JDIAction("Close '{name}'")
    public void close(String closeButtonName) {
        actions().getAllButtons().stream()
                .filter(button -> button.getValue().equalsIgnoreCase(closeButtonName))
                .findFirst()
                .get()
                .click();
    }

    @JDIAction("Confirm and close '{name}'")
    public void confirm() {
        confirm("ok");
    }

    @JDIAction("Confirm and close '{name}'")
    public void confirm(String confirmButtonName) {
        actions().getAllButtons().stream()
                .filter(button -> button.getValue().equalsIgnoreCase(confirmButtonName))
                .findFirst()
                .get()
                .click();
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}
