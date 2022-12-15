package io.github.com.custom.windows;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Windows;

public class CustomizedArrowsWindows<T extends ICoreElement> extends Windows<T> {
    @Override
	protected WebList nextPreviousButtons() {
		return finds(".v-window__container button");
	}

	@JDIAction("Get '{name}' previous button")
	public Button previousButton() {
		return new Button().setCore(Button.class, find(".v-window__container > .v-window__prev > button"));
	}

	@JDIAction("Get '{name}' next button")
	public Button nextButton() {
		return new Button().setCore(Button.class, find(".v-window__container > .v-window__next > button"));
	}
}
