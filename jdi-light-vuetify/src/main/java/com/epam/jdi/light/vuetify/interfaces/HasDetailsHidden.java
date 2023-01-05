package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface HasDetailsHidden extends ICoreElement {
	/**
	 * Checks if element has details hidden or not.
	 *
	 * @return {@code true} if element has details hidden, otherwise {@code false}
	 */

	@JDIAction("Check that {name} has details hidden")
	default boolean hasDetailsHidden() {
		return core().attr("class").contains("-hide-details");
	}
}
