package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import io.github.com.sections.LoginForm;
import org.openqa.selenium.WebElement;

public class Header extends Section {
	@Css("form") public static LoginForm loginForm;
	@Css(".fa-sign-out") public static WebElement logout;
	@Css("#epam_logo") public static WebElement epamLogo;
	public static WebElement userIcon;
	@XPath("//*[@ui='label']") public static UIElement userName;

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