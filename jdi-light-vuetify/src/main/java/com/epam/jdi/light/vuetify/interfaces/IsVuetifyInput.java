package com.epam.jdi.light.vuetify.interfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

/**
 * Interface <code>IsVuetifyInput</code> includes methods to work with inputs.
 */
public interface IsVuetifyInput extends IsInput {

	/**
	 * Clears input.
	 *
	 * @return {@code void}
	 */

	@JDIAction("Clear '{name}' text")
	default void clear() {
		if (getOs().equals(OsTypes.MAC)) {
			sendKeys(Keys.chord(Keys.COMMAND, "a"));
			sendKeys(Keys.DELETE);
		} else {
			sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		}
	}
}
