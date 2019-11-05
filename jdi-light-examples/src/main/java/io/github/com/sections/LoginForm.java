package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.Root;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;
@SuppressWarnings({"PMD.UnusedLocalVariable"})
public class LoginForm extends Form<User> {
	@UI("*root*//header//form//input[@type='text']")
	private WebElement name;
	@Css("input[type=password]")private WebElement password;

	@Root @XPath(".//header//form//button[@type='submit']") WebElement enter;

}