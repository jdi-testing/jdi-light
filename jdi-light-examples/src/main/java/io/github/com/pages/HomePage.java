package io.github.com.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPage {
	@Css("h3[name='main-title']") public static WebElement mainTitle;
	@Css(".main-txt") public static UIElement jdiText;
	@UI("['JDI Github']") public static WebElement githubLink;
}