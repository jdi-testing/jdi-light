package io.github.com.custom.dialog;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;

public class NestingDialog extends Dialog {

    @UI("//button[./span[contains(text(), 'Open Dialog')]]")
    private VuetifyButton openDialogButton;

    public VuetifyButton openDialogButton() {
        return openDialogButton;
    }
}
