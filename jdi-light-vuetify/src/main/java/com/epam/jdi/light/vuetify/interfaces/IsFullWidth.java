package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsFullWidth  extends ICoreElement {

	/**
	 * Checks if element is full-width or not.
	 *
	 * @return {@code true} if element is full-width, otherwise {@code false}
	 */
	@JDIAction("Check that '{name}' is full-width")
	default boolean isFullWidth() {
		return core().attr("class").contains("--full-width");
	}
}
