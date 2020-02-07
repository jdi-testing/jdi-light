package io.github.com.pages;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;

public class HomePageFrame extends Section {
	@UI("img#user-icon") public UIElement userIcon;
}