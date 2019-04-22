package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import io.github.com.entities.User;

public class LoginForm extends Form<User> {
	TextField name, password;
	Button loginButton;
}