package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;

public interface MayContainButtons extends ICoreElement {
	/**
	 * Gets element's buttons
	 *
	 * @return list of buttons
	 */
	@JDIAction("Get '{name}' button")
	default WebList buttons() {
		return core().finds(".v-btn");
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
		return castToButton(buttons().stream().filter(element -> element.getText().contains(text)).findFirst().orElse(null));
	}

	/**
	 * Get element's button with exact text
	 *
	 * @return VuetifyButton
	 */
	@JDIAction("Get Button by text '{0}'")
	default VuetifyButton getButtonByText(String text) {
		return castToButton(buttons().stream().filter(uiElement -> uiElement.text().equals(text)).findFirst()
				.orElse(null));
	}
}
