package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.VuetifyFormAssert;

/**
 * To see an example of Forms web element please visit <a href="https://vuetifyjs.com/en/components/forms/">...</a>
 */
public abstract class VuetifyForm<T> extends UIBaseElement<VuetifyFormAssert> {
	public abstract void fill(T entity);

	public boolean isValid() {
		return true;
	}
}
