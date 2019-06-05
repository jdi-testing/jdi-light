package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.asserts.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.openqa.selenium.By;

public class WithLabel<A extends UIAssert> extends UIBaseElement<A> implements HasLabel {
    public Label label() {
        return new Label().element
                .setLocator(By.cssSelector("[for="+element.getAttribute("id")+"]"))
                .setName(getName() + " label");
    }
    /**
     * Gets label text
     * @return String text
     */
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }
}
