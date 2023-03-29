package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Interface <code>MayContainButtons</code> includes methods to work with buttons.
 */
public interface MayContainButtons extends ICoreElement {
    /**
     * Gets element's buttons
     *
     * @return list of buttons
     */
    @JDIAction("Get '{name}' button")
    default List<VuetifyButton> buttons() {
        return core().finds(".v-btn").stream().map(this::castToButton).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' number of buttons")
    default int hasNumberOfButtons() {
        return buttons().size();
    }

    /**
     * Casts element to VuetifyButton
     *
     * @return VuetifyButton
     */
    default VuetifyButton castToButton(UIElement element) {
        return new VuetifyButton(element);
    }

    /**
     * Get element's button which contains test
     *
     * @return VuetifyButton
     */
    @JDIAction("Get Button with text '{0}'")
    default VuetifyButton getButtonWithText(String text) {
        return buttons().stream().filter(element -> element.getText().contains(text)).findFirst().orElseThrow(
                () -> new NoSuchElementException(
                        "Expected button containing text " + text + "' wasn't found"));
    }

    /**
     * Get element's button with exact text
     *
     * @return VuetifyButton
     */
    @JDIAction("Get Button by text '{0}'")
    default VuetifyButton getButtonByText(String text) {
        return buttons().stream().filter(uiElement -> uiElement.text().equals(text)).findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Expected button with text " + text + "' wasn't found"));
    }
}
