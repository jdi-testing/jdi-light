package io.github.com.custom;

import com.epam.jdi.light.vuetify.elements.common.Overlay;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

import static com.jdiai.tools.Timer.waitCondition;

public class OverlayWithCloseButton extends Overlay {
    private static final String CLOSE_BUTTON_PATH = "button[class*='v-btn']";

    public void close() {
        VuetifyButton closeButton = new VuetifyButton().setCore(VuetifyButton.class, find(CLOSE_BUTTON_PATH));
        waitCondition(closeButton.core()::isClickable);
        closeButton.click();
    }
}
