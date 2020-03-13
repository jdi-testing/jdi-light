package io.github.com.pages;

import com.epam.jdi.light.elements.composite.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import io.github.com.entities.User;

public class Header extends Section {
	public static Form<User> loginForm;
	@UI(".fa-sign-out") public static Button logout;
	public static Image epamLogo;
	public static Icon userIcon;
	public static Text userName;
}