package io.github.epam.pages;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.WebElement;

public class HomePageFrame extends Section {
	@Css("img#user-icon") public WebElement userIcon;
}