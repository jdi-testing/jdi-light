package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import org.openqa.selenium.By;

/**
 * To see example of Radio buttons web element please visit https://vuetifyjs.com/en/components/radio-buttons/
 */

public class RadioButtons extends com.epam.jdi.light.ui.html.elements.complex.RadioButtons implements HasLabel {

    protected String labelLocator = "//ancestor::div[@class = 'v-input--selection-controls__input']//following-sibling::label";
//    protected String colorLocator = "//following-sibling::div[contains(@class, 'v-input--selection-controls__ripple')]";

    @Override
    public Label label() {
        return new Label().setup(Label.class, j->j
                .setLocator(By.xpath(labelLocator))
                .setName(getName() + " label").setTypeName("Label"));
    }

//    public String color() {
//        find(labelLocator + "[text() = '"+selected()+"']")
//        return core().find(colorLocator).getCssValue("color");
//    }
}
