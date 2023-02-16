package io.github.com.custom.windows;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Windows;

public class AccountCreationWindows extends Card {

	@UI(".v-window")
	public Windows<Card> slider;

	@JDIAction("Get '{name}' previous button")
	public VuetifyButton previousActionsButton() {
		return actions().getButtonByText("BACK");
	}

	@JDIAction("Get '{name}' next button")
	public VuetifyButton nextActionsButton() {
		return actions().getButtonByText("NEXT");
	}
}
