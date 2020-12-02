package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;

public class HomePageFrame extends Section {
	@UI("#epam-logo") public Icon epamLogo;
}