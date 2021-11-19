package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.utils.ModalAssert;

/**
 * To see an example of Modal web element please visit
 * https://material-ui.com/components/modal/
 */

public class Modal extends UIBaseElement<ModalAssert> implements IsText, HasAssert<ModalAssert> {
    private static final String NEW_MODAL = "div:not([aria-hidden='true']) div.jss2";

    protected Modal modal() {
        return new Modal().setCore(Modal.class, core().setLocator(NEW_MODAL));
    }

    protected UIElement modalButton() {
        return find("button");
    }

    @JDIAction("Open {name}")
    public Modal open() {
        modalButton().click();
        return modal();
    }

    @JDIAction("Close {name}")
    public void close() {
        modalButton().click(-200, -100);
    }

    @JDIAction("Get {name} title")
    public String title() {
        return find("h2").text();
    }

    @Override
    @JDIAction("Get {name} text")
    public String text() {
        return find("p").text();
    }

    @Override
    public ModalAssert is() {
        return new ModalAssert().set(this);
    }
}
