package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.annotations.JDIModal;
import com.epam.jdi.light.material.asserts.utils.ModalAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Modal extends UIBaseElement<ModalAssert> implements HasClick, ISetup {

    String modalTitle;
    String modalDescription;
    String root;
    String additionalModal;

    private String getModalTitle() {
        return this.find(modalTitle).getText();
    }

    private String getModalDescription() {
        return this.find(modalDescription).getText();
    }

    @JDIAction("Verify '{name}' displayed")
    public boolean verifyAdditionalModalOpened() {
        return this.find(additionalModal).isDisplayed();
    }

    @JDIAction("Verify '{name}'")
    public boolean verifyModalTitle(String actualTitle) {
        return getModalTitle().equals(actualTitle);
    }

    @JDIAction("Verify '{name}'")
    public boolean verifyModalDescription(String actualDescription) {
        return getModalDescription().equals(actualDescription);
    }

    @Override
    public ModalAssert is() {
        return new ModalAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIModal.class, Modal.class))
            return;
        JDIModal j = field.getAnnotation(JDIModal.class);
        root = j.root();
        modalTitle = j.modalTitle();
        modalDescription = j.modalDescription();
        additionalModal = j.additionalModal();
    }


}
