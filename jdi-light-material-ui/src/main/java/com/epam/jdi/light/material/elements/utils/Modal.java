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

    private static final String BUTTON = "#root > div > button";
    private static final String SIMPLE_MODAL_TITLE = "#simple-modal-title";
    private static final String SIMPLE_MODAL_DESCRIPTION = "#simple-modal-description";
    private static final String TRANSITION_MODAL_TITLE = "#transition-modal-title";
    private static final String TRANSITION_MODAL_DESCRIPTION = "#transition-modal-description";
    private static final String SERVER_MODAL_TITLE = "#server-modal-title";
    private static final String SERVER_MODAL_DESCRIPTION = "#server-modal-description";

    String modalTitle;
    String modalDescription;

    @JDIAction("Is '{name}' enabled")
    public void clickModalButton() {
        this.find(BUTTON).click();
    }

    private String getSimpleModalTitle() {
        return this.find(SIMPLE_MODAL_TITLE).getText();
    }

    private String getTransitionModalTitle() {
        return this.find(TRANSITION_MODAL_TITLE).getText();
    }

    private String getServerModalTitle() {
        return this.find(SERVER_MODAL_TITLE).getText();
    }

    private String getSimpleModalDescription() {
        return this.find(SIMPLE_MODAL_DESCRIPTION).getText();
    }

    private String getTransitionModalDescription() {
        return this.find(TRANSITION_MODAL_DESCRIPTION).getText();
    }

    private String getServerModalDescription() {
        return this.find(SERVER_MODAL_DESCRIPTION).getText();
    }

    @JDIAction("Verify '{name}'")
    public boolean verifySimpleModalTitle(String actualTitle) {
        return getSimpleModalTitle().equals(actualTitle);
    }

    @JDIAction("Verify '{name}'")
    public boolean verifyTransitionModalTitle(String actualTitle) {
        return getTransitionModalTitle().equals(actualTitle);
    }

    @JDIAction("Verify '{name}'")
    public boolean verifyServerModalTitle(String actualTitle) {
        return getServerModalTitle().equals(actualTitle);
    }

    @JDIAction("Verify '{name}'")
    public boolean verifySimpleModalDescription(String actualDescription) {
        return getSimpleModalDescription().equals(actualDescription);
    }

    @JDIAction("Verify '{name}'")
    public boolean verifyTransitionModalDescription(String actualDescription) {
        return getTransitionModalDescription().equals(actualDescription);
    }

    @JDIAction("Verify '{name}'")
    public boolean verifyServerModalDescription(String actualDescription) {
        return getServerModalDescription().equals(actualDescription);
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
        modalTitle = j.modalTitle();
        modalDescription = j.modalDescription();
    }


}
