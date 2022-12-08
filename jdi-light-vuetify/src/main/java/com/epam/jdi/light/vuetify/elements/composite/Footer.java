package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.FooterAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsTile;

/**
 * To see an example of Footer web element please visit https://vuetifyjs.com/en/components/footer/
 *
 * According to the documentation:
 * "The v-footer component in its simplest form is a container."
 *
 * No other specification is given.
 *
 * Created by Nikita Nechepurenko on 29.09.2021
 */
public class Footer extends UIBaseElement<FooterAssert> implements IsText, HasColor, HasTheme, HasElevation,
		HasMeasurement, IsOutlined, HasRounded, IsShaped, IsTile {
	@Override
	public FooterAssert is() {
		return new FooterAssert().set(this);
	}

	@JDIAction("Check that '{name}' is padless")
	public boolean isPadless() {
		return hasClass("v-footer--padless");
	}

	@JDIAction("Check that '{name}' is absolute")
	public boolean isAbsolute() {
		return hasClass("v-footer--absolute");
	}

	@JDIAction("Check that '{name}' is fixed")
	public boolean isFixed() {
		return hasClass("v-footer--fixed");
	}

	@JDIAction("Get '{name}' max height")
	public int maxHeight() {
		return Integer.parseInt(css("max-height").replace("px", ""));
	}

	@JDIAction("Get '{name}' max width")
	public int maxWidth() {
		return Integer.parseInt(css("max-width").replace("px", ""));
	}

	@JDIAction("Get '{name}' min height")
	public int minHeight() {
		return Integer.parseInt(css("min-height").replace("px", ""));
	}

	@JDIAction("Get '{name}' min width")
	public int minWidth() {
		return Integer.parseInt(css("min-width").replace("px", ""));
	}
}
