package io.github.com;

import com.epam.jdi.light.elements.composite.*;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.ui.html.elements.common.*;
import io.github.com.entities.User;
import io.github.com.pages.BootstrapPage;

@SuppressWarnings("PMD.ClassNamingConventions")
//@JSite("http://localhost:8000/")
@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {
	@Url("/index.html") @Title("Home Page") public static WebPage homePage;
	@Url("/bootstrap-new.html") public static BootstrapPage bsPage;

	@UI("#login-form")
	public static Form<User> loginForm;

	@Css(".fa-sign-out") public static Button logout;
	public static Button userIcon;
	public static Text userName;
}