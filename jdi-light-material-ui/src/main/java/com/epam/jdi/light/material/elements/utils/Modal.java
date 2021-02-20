package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.utils.ModalAssert;
import org.openqa.selenium.By;

public class Modal extends UIBaseElement<ModalAssert> {

    @JDIAction("Click on '{name}'")
    public void clickOn() {
        core().click();
    }

    @JDIAction("Is '{name}' enabled")
    public boolean isModalEnabled() {
        return core().find("#root > div > button").isEnabled();
    }

    @JDIAction("Is '{name}' opened")
    public boolean isSimpleModalWindowOpened() {
        return core().hasClass("makeStyles-paper-103");
    }

    @JDIAction("Get '{name}' description")
    public boolean getSimpleModalDescription(String description) {
        return core().find(By.id("simple-modal-description")).getText().equals(description);
    }

    @JDIAction("Is '{name}' opened")
    public boolean isTransitionModalOpened() {
        return core().hasClass("makeStyles-paper-108");
    }

    @JDIAction("Get '{name}' description")
    public boolean getTransitionModalDescription(String description) {
        return core().find(By.id("transition-modal-description")).getText().equals(description);
    }

    @JDIAction("Is '{name}' opened")
    public boolean isSpringModalWindowOpened() {
        return core().hasClass("makeStyles-paper-110");
    }

    @JDIAction("Get '{name}' description")
    public boolean getSpringModalDescription(String description) {
        return core().find(By.id("transition-modal-description")).getText().equals(description);
    }
}
