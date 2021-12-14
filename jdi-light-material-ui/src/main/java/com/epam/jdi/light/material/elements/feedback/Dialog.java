package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.asserts.feedback.DialogAssert;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.material.elements.navigation.Menu;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.lang.reflect.Field;

public class Dialog extends UIBaseElement<DialogAssert> implements ISetup {

    public Dialog(ICoreElement element) {
        setCore(Dialog.class, element.core());
    }

    public Text title() {
        return new Text().setCore(Text.class, find(".MuiDialogTitle-root"));
    }

    public Menu list() {
        return new Menu().setCore(Menu.class, find(".MuiList-root"));
    }

    public Text textContent() {
        return new Text().setCore(Text.class, find(".MuiDialogContentText-root"));
    }

    public ButtonGroup actions() {
        return new ButtonGroup().setCore(ButtonGroup.class, find(".MuiDialogActions-root"));
    }

    public TextField input() {
        return new TextField().setCore(TextField.class, find(".MuiTextField-root"));
    }

    public Menu itemsGroup() {
        return new Menu().setCore(Menu.class, find(".MuiFormGroup-root"));
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }

    @Override
    public void setup(Field field) {

    }
}
