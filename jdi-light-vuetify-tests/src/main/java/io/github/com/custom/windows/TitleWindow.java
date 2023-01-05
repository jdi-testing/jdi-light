package io.github.com.custom.windows;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class TitleWindow extends Section {
	@UI(".v-card .text-h6")
	private UIElement title;

	public UIElement title() {
		return title;
	}
}
