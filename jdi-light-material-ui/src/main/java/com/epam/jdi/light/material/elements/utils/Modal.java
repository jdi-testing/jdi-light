package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.utils.ModalAssert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

/**
 * To see an example of Modal web element please visit
 * https://material-ui.com/components/modal/
 */

public class Modal extends UIBaseElement<ModalAssert> implements IsText {

    @JDIAction("Get {name} title")
    public UIElement title() {
        return find("h2");
    }

    @Override
    @JDIAction("Get {name} text")
    public String getText() {
        return find("p").text();
    }

    @JDIAction("Close {name}")
    public void close() {
        new Actions(core().driver()).sendKeys(core().seleniumElement(), Keys.ESCAPE).perform();
    }

    @Override
    public ModalAssert is() {
        return new ModalAssert().set(this);
    }
}
