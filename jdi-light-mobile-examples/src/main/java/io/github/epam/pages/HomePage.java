package io.github.epam.pages;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPage {
	@Css("h3[name='main-title']") public WebElement mainTitle;
	@Css(".main-txt") public UIElement jdiText;
	@UI("['JDI Github']") public WebElement githubLink;
}