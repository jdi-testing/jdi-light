package io.github.com.pages;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	@Css("h3[name='main-title']") public static WebElement mainTitle;
	@Css(".main-txt") public static UIElement jdiText;
	@UI("['JDI Github']") public static WebElement githubLink;
}