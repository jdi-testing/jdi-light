package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.feedback.DialogAssert;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.inputs.RadioButtons;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * To see an example of Dialog web element please visit
 * https://mui.com/components/dialogs/
 */

public class Dialog extends UIBaseElement<DialogAssert> {

    public Text title() {
        return new Text().setCore(Text.class, find(".MuiDialogTitle-root"));
    }

    public WebList listItems() {
        return finds(".MuiListItem-root");
    }

    public ListItem listitem(int index) {
        return new ListItem().setCore(ListItem.class, listItems().get(index));
    }

    public Text textContent() {
        return new Text().setCore(Text.class, find(".MuiDialogContentText-root"));
    }

    private ButtonGroup actions() {
        return new ButtonGroup().setCore(ButtonGroup.class, find(".MuiDialogActions-root"));
    }

    public RadioButtons radioButtons() {
        return new RadioButtons().setCore(RadioButtons.class, find(".MuiRadio-root"));
    }

    public void close() {
        if(actions().get(1).text().contains("CANCEL") || actions().get(1).text().contains("CLOSE")) {
            actions().get(1).click();
        }
    }

    public void confirm() {
        if(actions().get(2).text().contains("OK") || actions().get(2).text().contains("SUBSCRIBE")) {
            actions().get(2).click();
        }
    }

    public TextField input() {
        return new TextField().setCore(TextField.class, find(".MuiTextField-root"));
    }

    public WebList itemsGroup() {
        return finds(".MuiFormControlLabel-root");
    }

    public String getItemText(int index) {
        return itemsGroup().get(index).getText();
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }
}
