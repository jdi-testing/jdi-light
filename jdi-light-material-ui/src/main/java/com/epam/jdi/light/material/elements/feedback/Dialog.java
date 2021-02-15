package com.epam.jdi.light.material.elements.feedback;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIDialog;
import com.epam.jdi.light.material.asserts.displaydata.DividerAssert;
import com.epam.jdi.light.material.asserts.feedback.DialogAssert;

import java.lang.reflect.Field;

public class Dialog extends UIBaseElement<DialogAssert> implements ISetup {

    String button;
    String dialogTitle;
    String dialogContent;
    String dialogInputField;
    String dialogCloseButton;
    String dialogOkButton;
    String dialogOptions;

    @Override
    public DialogAssert is() {
        return new DialogAssert().set(this);
    }

    public void openDialog(){
        this.find(button).click();
    }

    public void clickCloseButton(){
        this.find(dialogCloseButton).click();
    }

    public void clickOkButton(){
        this.find(dialogOkButton).click();
    }

    public String getDialogTitle(){
        return this.find(dialogTitle).getText();
    }

    public String getDialogContent(){
        return this.find(dialogContent).getText();
    }

    public void setTextToInput(String text){
        this.find(dialogInputField).setText(text);
    }

    public void selectOption(String option){
        System.out.println();
        this.finds(dialogOptions).select(option);
        System.out.println();
    }


    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIDialog.class, Dialog.class))
            return;
        JDIDialog j = field.getAnnotation(JDIDialog.class);

        button = j.button();
        dialogTitle = j.dialogTitle();
        dialogContent = j.dialogContent();
        dialogInputField = j.dialogInputField();
        dialogCloseButton = j.dialogCloseButton();
        dialogOkButton = j.dialogOkButton();
        dialogOptions = j.dialogOptions();
    }
}
