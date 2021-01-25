package com.epam.jdi.light.mobile.elements.complex;

import org.openqa.selenium.By;

public class RadioButtonsList extends MobileWebList {
    public String radioButton = "android.widget.RadioButton";

    /**
     * Get a list of expander items.
     *
     * @return WebList element
     */
    public MobileWebList list() {
        return new MobileWebList(By.className(radioButton));
    }
}
