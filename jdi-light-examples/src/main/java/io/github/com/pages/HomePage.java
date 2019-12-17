package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	@Css("h3[name='main-title']") public static WebElement mainTitle;
	@Css(".main-txt") public static Label jdiText;
	@UI("['JDI Github']") public static WebElement githubLink;
}