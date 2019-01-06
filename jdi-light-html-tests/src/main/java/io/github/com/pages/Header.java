package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.Image;
import io.github.com.sections.LoginForm;

public class Header extends Section {
	@Css("form") public static LoginForm loginForm;
	@Css(".fa-sign-out") public static Button logout;
	public static Image epamLogo;
	public static Icon userIcon;
	public static Icon userName;

}