package io.github.com;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import io.github.com.entities.User;
import io.github.com.pages.BootstrapPage;
import io.github.com.sections.modal.EmbeddedVideoModalFrame;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {
	@Url("/bootstrap.html")
	public static BootstrapPage bsPage;

	@UI("#login-form")
	public static Form<User> loginForm;

	@Css(".fa-sign-out") public static Button logout;
	public static Button userIcon;
	public static Text userName;
}