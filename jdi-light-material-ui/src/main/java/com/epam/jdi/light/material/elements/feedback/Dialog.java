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

    @JDIAction("Get '{name}'s title")
    public Text title() {
        return new Text().setCore(Text.class, find(".MuiDialogTitle-root"));
    }

    @JDIAction("Get '{name}'s list items")
    public List list() {
        return new List(find(".MuiList-root"));
    }

    @JDIAction("Get '{name}'s text content")
    public Text textContent() {
        return new Text().setCore(Text.class, find(".MuiDialogContentText-root"));
    }

    @JDIAction("Get '{name}'s action buttons")
    public ButtonGroup actions() {
        return new ButtonGroup().setCore(ButtonGroup.class, find(".MuiDialogActions-root"));
    }

    @JDIAction("Get '{name}'s radio buttons")
    public RadioButtons radioButtons() {
        return new RadioButtons().setCore(RadioButtons.class, find(".MuiRadio-root"));
    }

    @JDIAction("Get '{name}'s input field")
    public TextField input() {
        return new TextField().setCore(TextField.class, find(".MuiTextField-root"));
    }

    @JDIAction("Does '{name}' have scrollable content")
    public Boolean hasScrollableContent() {
        return jsExecute(EXECUTE_SCRIPT, find(".MuiDialogContent-root").getFast());
    }

    @JDIAction("Does '{name}' have scrollable body")
    public Boolean hasScrollableBody() {
        return jsExecute(EXECUTE_SCRIPT, core().getFast());
    }

    @JDIAction("Close (cancel) '{name}'")
    public void close() {
        if(actions().get(1).text().contains("CANCEL") || actions().get(1).text().contains("CLOSE")) {
            actions().get(1).click();
        }
    }

    @JDIAction("Confirm and close '{name}'")
    public void confirm() {
        if(actions().get(2).text().contains("OK") || actions().get(2).text().contains("SUBSCRIBE")) {
            actions().get(2).click();
        }
    }

    @JDIAction("Scroll '{name}' to target height")
    public void scrollDialogBodyTo(int scrollHeight) {
        jsExecute(String.format("arguments[0].scroll(0, %s)", scrollHeight), core().getFast());
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}
