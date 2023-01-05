package io.github.com.custom.windows;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Windows;

public class AccountCreationWindows<T extends ICoreElement> extends Windows<T> {
	@JDIAction("Get '{name}' previous button")
	public Button previousActionsButton() {
		return new Button().setCore(Button.class, actions().find("//*[contains(text(), 'Back')]//ancestor::button"));
	}

	@JDIAction("Get '{name}' next button")
	public Button nextActionsButton() {
		return new Button().setCore(Button.class, actions().find("//*[contains(text(), 'Next')]//ancestor::button"));
	}
}
