package io.github.com.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import io.github.com.sections.LoginForm;
import org.openqa.selenium.WebElement;

public class Header extends Section {
	@Css("form") public static LoginForm loginForm;
	@Css(".fa-sign-out") public static WebElement logout;
	public static WebElement epamLogo;
	public static WebElement userIcon;
	@Css(".icon-search:not(.active)") public static WebElement searchIcon;
	@XPath(".//*[@ui='label']") public static UIElement userName;

}