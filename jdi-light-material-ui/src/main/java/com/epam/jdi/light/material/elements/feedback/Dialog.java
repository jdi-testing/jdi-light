package com.epam.jdi.light.material.elements.feedback;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIDialog;
import com.epam.jdi.light.material.asserts.feedback.DialogAssert;
import com.epam.jdi.light.material.elements.inputs.Button;

import java.lang.reflect.Field;

public class Dialog extends UIBaseElement<DialogAssert> implements ISetup {

    private String root;
    private String dialogCancelButton;
    private String dialogTitle;
    private String dialogCloseButton;
    private String dialogOkButton;

    @JDIAction("Get Close button")
    public Button getCloseButton(){
        return new Button(this.find(dialogCloseButton));
    }

    @JDIAction("Get Cancel button")
    public Button getCancelButton(){
        return new Button(this.find(dialogCancelButton));
    }

    @JDIAction("Get OK button")
    public Button getOkButton(){
        return new Button(this.find(dialogOkButton));
    }

    @JDIAction("Get Title text")
    public String getTitle(){
        return this.find(dialogTitle).getText();
    }

    @JDIAction("Check that dialog is displayed")
    public boolean isDialogDisplayed(){
        return this.find(root).isDisplayed();
    }

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIDialog.class, Dialog.class))
            return;
        JDIDialog j = field.getAnnotation(JDIDialog.class);

        root = j.root();
        dialogTitle = j.dialogTitle();
        dialogCloseButton = j.dialogCloseButton();
        dialogOkButton = j.dialogOkButton();
        dialogCancelButton = j.dialogCancelButton();

    }
}
