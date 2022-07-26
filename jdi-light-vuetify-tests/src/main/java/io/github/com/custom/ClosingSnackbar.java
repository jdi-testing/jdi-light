package io.github.com.custom;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Snackbar;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

public class ClosingSnackbar extends Snackbar {

    @UI("button[class*='v-btn--text']")
    private VuetifyButton closeButton;

    public VuetifyButton closeButton() {
        return closeButton;
    }
}
