package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.Image;
import io.github.com.entities.User;
import io.github.com.sections.LoginForm;
import io.github.com.sections.LoginFormSmart;

public class Header extends Section {
	//@Css("form")
	public static LoginForm loginForm;
	public static LoginFormSmart loginFormSmart;
	public static Form<User> loginFormLight;
	@Css(".fa-sign-out") public static Button logout;
	public static Image epamLogo;
	public static Icon userIcon;
	public static Icon userName;

}