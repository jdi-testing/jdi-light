package com.epam.jdi.light.material.elements.feedback;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIDialog;
import com.epam.jdi.light.material.asserts.feedback.DialogAssert;

import java.lang.reflect.Field;

public class Dialog extends UIBaseElement<DialogAssert> implements ISetup {

    private String root;
    private String dialogCancelButton;
    private String dialogTitle;
    private String dialogCloseButton;
    private String dialogOkButton;

    public void clickCloseButton(){
        this.find(dialogCloseButton).click();
    }

    public void clickCancelButton(){
        this.find(dialogCancelButton).click();
    }

    public void clickOkButton(){
        this.find(dialogOkButton).click();
    }

    private String getDialogTitle(){
        return this.find(dialogTitle).getText();
    }

    public boolean isTitleCorrect(String title){
        return title.equals(getDialogTitle());
    }

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
