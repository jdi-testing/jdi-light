package com.epam.jdi.light.vuetify.elements.complex.radiobuttons;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.radiobuttons.RadioButtonAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

public class RadioButton extends UIBaseElement<RadioButtonAssert> implements HasColor, HasTheme, HasLabel {
	private static final String INPUT_SELECTION_CONTROL = "//div[@class='v-input--selection-controls__input']/div";
	private static final String LABEL_LOCATOR = "//label";
	private static final String ICON = "//i";

	@Override
	public RadioButtonAssert is() {
		return new RadioButtonAssert().set(this);
	}

	@Override
	public Label label() {
		return new Label().setCore(Label.class, find(LABEL_LOCATOR));
	}

	private Icon icon() {
		return new Icon().setCore(Icon.class, find(ICON));
	}

	@Override
	@JDIAction("Get if '{name}' is disabled")
	public boolean isDisabled() {
		return hasClass("v-radio--is-disabled");
	}

	@Override
	@JDIAction("Get '{name}' theme")
	public String theme() {
		return classLike("theme--");
	}

	@JDIAction("Get '{name}' input control color")
	public String color() {
		return find(INPUT_SELECTION_CONTROL).css("color");
	}

	@JDIAction("Get '{name}' label color")
	public String labelColor() {
		return label().css("color");
	}

	@JDIAction("Get if '{name}' is success")
	public boolean isSuccess() {
		return icon().hasClass("success--text") || label().hasClass("success--text");
	}

	@JDIAction("Get if '{name}' is error")
	public boolean isError() {
		return icon().hasClass("error--text") || label().hasClass("error--text");
	}
}
