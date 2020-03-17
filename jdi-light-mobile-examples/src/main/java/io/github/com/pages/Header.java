package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import io.github.com.sections.LoginForm;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Header extends Section {
	@Css("form") public static LoginForm loginForm;
	@Css(".fa-sign-out") public static WebElement logout;
	@Css("#epam_logo") public static WebElement epamLogo;
	//public static WebElement userIcon;
	@FindBy (id = "user-icon") public static WebElement userIcon;
	@MobileFindBy (name = "main-title") public static WebElement mainTitleNames;
	@MobileFindBy (className = "icon-search") public static WebElement iconSearch;
	@XPath ("//*[text()='About']") public static WebElement linkTexts;
	@FindBy (xpath = "//*[text()='About']") public static WebElement linkText;
	//@MobileFindBy (tagName = "title") public static List<WebElement> titleTags;
	//@XPath ("//title") public static List<WebElement> titleTag;
	//@XPath ("//h3[@name='main-title']") public static WebElement mainTitleName;
	@XPath("//*[@ui='label']") public static UIElement userName;
	@FindBy(id = "name") public static WebElement name;

	@Css(".search-field input") static UIElement searchInput;
	@Css(".icon-search") static WebElement searchIcon;
	@Css(".icon-search.active") static WebElement doSearch;

	public static void search(String text) {
		if(logout.isDisplayed())
			userName.click();
		if (searchInput.isHidden())
			searchIcon.click();
		searchInput.input(text);
		doSearch.click();
	}
}