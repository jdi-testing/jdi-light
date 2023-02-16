package io.github.com.custom;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Overlay;

import static com.jdiai.tools.Timer.waitCondition;

public class OverlayWithCloseButton extends Overlay {
    private static final String CLOSE_BUTTON_PATH = "button[class*='v-btn']";

    public void close() {
        UIElement closeButton = find(CLOSE_BUTTON_PATH);
        waitCondition(closeButton.core()::isClickable);
        closeButton.click();
    }
}
