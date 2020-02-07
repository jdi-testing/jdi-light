package io.github.com.pages;

import com.epam.jdi.mobile.elements.composite.Form;
import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.mobile.ui.html.elements.common.Button;
import com.epam.jdi.mobile.ui.html.elements.common.Icon;
import com.epam.jdi.mobile.ui.html.elements.common.Image;
import com.epam.jdi.mobile.ui.html.elements.common.Text;
import io.github.com.entities.User;

public class Header extends Section {
	public static Form<User> loginForm;
	@UI(".fa-sign-out") public static Button logout;
	public static Image epamLogo;
	public static Icon userIcon;
	public static Text userName;
}