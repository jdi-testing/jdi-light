package io.github.epam.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;

public class LoginForm extends Form<User> {
	@XPath(".//button[@type='submit']") public WebElement enter;
	@Css("input[type=text]") public WebElement name;
	@Css("input[type=password]") public WebElement password;

}