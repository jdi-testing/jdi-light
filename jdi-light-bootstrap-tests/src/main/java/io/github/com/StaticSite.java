package io.github.com;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.entities.User;
import io.github.com.pages.BootstrapFormsPage;
import io.github.com.pages.BootstrapPage;

@SuppressWarnings("PMD.ClassNamingConventions")
@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {
	@Url("/bootstrap-new.html")
	public static BootstrapPage bsPage;
	@Url("/bootstrap_forms.html")
	public static BootstrapFormsPage bsFormsPage;

	@UI("#login-form")
	public static Form<User> loginForm;

	@Css(".fa-sign-out") public static Button logout;
	public static Button userIcon;
	public static Text userName;
}