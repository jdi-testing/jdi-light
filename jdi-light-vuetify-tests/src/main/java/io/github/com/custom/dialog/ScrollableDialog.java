package io.github.com.custom.dialog;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;

public class ScrollableDialog extends Dialog {

    @UI("//div[@role='radiogroup']/child::div")
    private WebList radiogroup;

    public WebList radiogroup() {
        return radiogroup;
    }
}
