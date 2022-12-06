package io.github.com.custom.dialog;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import com.epam.jdi.light.vuetify.elements.complex.radiobuttons.RadioButtons;

public class ScrollableDialog extends Dialog {

    @UI(".v-card__title")
    private Text title;

    @UI("input[role = 'radio']")
    private RadioButtons radiogroup;

    @UI("//button[./span[contains(text(), 'Close')]]")
    private VuetifyButton closeButton;

    @UI("//button[./span[contains(text(), 'Save')]]")
    private VuetifyButton saveButton;

    public Text title() {
        return title;
    }

    public RadioButtons radiogroup() {
        return radiogroup;
    }

    public VuetifyButton closeButton() {
        return closeButton;
    }

    public VuetifyButton saveButton() {
        return saveButton;
    }
}
