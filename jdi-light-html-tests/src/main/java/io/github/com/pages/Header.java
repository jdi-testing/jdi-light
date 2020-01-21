package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Image;
import io.github.com.custom.LoginFormSmart;
import io.github.com.entities.User;
import io.github.com.sections.LoginForm;

public class Header extends Section {
	//@Css("form")
	public static LoginForm loginForm;
	public static LoginFormSmart loginFormSmart;
	public static Form<User> loginFormLight;
	@UI("#login-form") public static Form<User> loginFormLightLocator;
	@Css(".fa-sign-out") public static Button logout;
	public static Icon userIcon;
	@UI("#user-name")
	public static Icon userName;
	public static Image epamLogo;
}