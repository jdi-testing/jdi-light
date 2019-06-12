package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDIAction;
import org.openqa.selenium.By;

public interface WithLabel extends HasUIBase {
    default Label label() {
        return new Label().element()
            .setLocator(By.cssSelector("[for="+element().attr("id")+"]"))
            .setName(element().getName() + " label");
    }
    /**
     * Gets label text
     * @return String text
     */
    @JDIAction("Get '{name}' label text")
    default String labelText() {
        return label().getText();
    }
}
