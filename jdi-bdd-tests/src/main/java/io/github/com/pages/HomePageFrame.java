package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class HomePageFrame extends Section {
	@UI("img#user-icon") public com.epam.jdi.light.elements.common.uiElement userIcon;
}