package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.Root;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;

public class LoginForm extends Form<User> {
	@XPath("*root*.//header//form//input[@type='text']") WebElement name;
	@Css("input[type=password]") WebElement password;

	@Root @XPath(".//header//form//button[@type='submit']") WebElement enter;

}