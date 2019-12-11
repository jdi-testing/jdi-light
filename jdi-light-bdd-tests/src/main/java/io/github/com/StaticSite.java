package io.github.com;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.pages.ContactFormPage;
import io.github.com.pages.DatesPage;
import io.github.com.pages.Footer;
import io.github.com.pages.GithubPage;
import io.github.com.pages.Header;
import io.github.com.pages.HomePage;
import io.github.com.pages.HomePageFrame;
import io.github.com.pages.HtmlElementsPage;
import io.github.com.pages.MetalAndColorsPage;
import io.github.com.pages.SimplePage;
import io.github.com.pages.UsersPage;

@SuppressWarnings("PMD.ClassNamingConventions")
@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {
	@Url("/index.html") public static HomePage homePage;
	@Url("/metals-colors.html") @Title("Metal and Colors")
	public static MetalAndColorsPage metalAndColorsPage;
	@Url("/contacts.html") @Title("Contact Form")
	public static ContactFormPage contactFormPage;
	@Url("/html5.html") public static HtmlElementsPage html5Page;
	@Url("/dates.html") @Title("Dates")
	public static DatesPage datesPage;
	@Url("/user-table.html") @Title("User Table")
	public static UsersPage usersPage;
	@Url("/simple-table.html") @Title("Simple Table")
	public static SimplePage simplePage;

	@UI("header") public static Header header;
	@UI("footer") public static Footer footer;
	@UI(".sidebar-menu span") public static Menu leftMenu;

	@Frame("frame")
	public static HomePageFrame iframe;
	public static GithubPage githubPage;
}