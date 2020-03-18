package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
	@Css("h3[name='main-title']") public static WebElement mainTitle;
	@Css(".main-txt") public static UIElement jdiText;
	@UI("['JDI Github']") public static WebElement githubLink;
	@MobileFindBy(name = "main-title") public static WebElement mainTitleName;
	@MobileFindBy(linkText = "JDI Github") public static WebElement linkText;
	@MobileFindBy(partialLinkText = "JDI") public static WebElement partialLinkText;
	@MobileFindBy(tagName = "h3") public static List<WebElement> titleTag;

}