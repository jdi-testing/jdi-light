package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.WebElement;

public class HomePageFrame {
	@Css("img#user-icon") public WebElement userIcon;
}