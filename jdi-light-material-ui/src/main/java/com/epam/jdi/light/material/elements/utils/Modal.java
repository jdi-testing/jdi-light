package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.material.annotations.JDIModal;
import com.epam.jdi.light.material.annotations.JDISnackbar;
import com.epam.jdi.light.material.asserts.utils.ModalAssert;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Modal extends UIBaseElement<ModalAssert> implements HasClick, ISetup {

    String modalTitle;
    String modalDescription;
    String modalInnerButton;
    String innerModalPage;

    @JDIAction("Is '{name}' enabled")
    public void getModalButton() {
        core().click();
    }

    @JDIAction("Is '{name}' opened")
    public boolean isInnerModalOpened() {
        return core().hasClass(innerModalPage);
    }

    @JDIAction("Get '{name}'")
    public boolean verifyModalTitle(String actualTitle) {
        return core().find(modalTitle).getText().equals(actualTitle);
    }

    @JDIAction("Get '{name}'")
    public boolean verifyModalDescription(String actualDescription) {
        return core().find(modalDescription).getText().equals(actualDescription);
    }

    @JDIAction("Get '{name}'")
    public void getInnerModalWindow() {
        core().find(modalInnerButton);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIModal.class, Modal.class))
            return;
        JDIModal j = field.getAnnotation(JDIModal.class);
        modalTitle = j.modalTitle();
        modalDescription = j.modalDescription();
        modalInnerButton = j.modalInnerButton();
        innerModalPage = j.innerModalPage();
    }


}
