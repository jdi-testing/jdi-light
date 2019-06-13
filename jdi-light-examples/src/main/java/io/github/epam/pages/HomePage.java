package io.github.epam.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPage {
	@Css("h3[name='main-title']") public WebElement mainTitle;
	@Css(".main-txt") public UIElement jdiText;
	@UI("['JDI Github']") public WebElement githubLink;
}