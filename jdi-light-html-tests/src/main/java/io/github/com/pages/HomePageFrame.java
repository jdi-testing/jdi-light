package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.mobile.ui.html.elements.common.Icon;

public class HomePageFrame extends Section {
	@UI("#epam_logo") public Icon epamLogo;
}