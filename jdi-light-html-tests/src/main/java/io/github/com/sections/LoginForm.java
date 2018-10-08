package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import io.github.com.entities.User;

public class LoginForm extends Form<User> {
	@Css("input[type=text]") public TextField userName;
	@Css("input[type=password]") public TextField password;

	@XPath(".//button[@type='submit']") public Button enter;

}