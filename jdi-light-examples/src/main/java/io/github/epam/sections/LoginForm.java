package io.github.epam.sections;

import com.epam.jdi.light.elements.composite.Form;
import io.github.epam.entities.User;
import org.openqa.selenium.WebElement;

public class LoginForm extends Form<User> {
	public WebElement name;
	public WebElement password;
	public WebElement loginButton;

}