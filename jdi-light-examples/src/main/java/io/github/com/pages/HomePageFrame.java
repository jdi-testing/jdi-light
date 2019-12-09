package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

public class HomePageFrame extends Section {
	@Css("img#user-icon") public WebElement userIcon;
	@UI("#user-name")
	public UIElement userName;
}