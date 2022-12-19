package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface IsSolo extends ICoreElement {

	/**
	 * Checks if element is solo or not.
	 *
	 * @return {@code true} if element is solo, otherwise {@code false}
	 */
	@JDIAction("Check that '{name}' is solo")
	default boolean isSolo() {
		return core().attr("class").contains("--solo");
	}

	@JDIAction("Check that '{name}' is solo-inverted")
	default boolean isSoloInverted() {
		return core().attr("class").contains("--solo-inverted");
	}
}
