package io.github.com;

import com.epam.jdi.mobile.elements.complex.Menu;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Frame;
import com.epam.jdi.mobile.elements.pageobjects.annotations.JSite;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Title;
import com.epam.jdi.mobile.elements.pageobjects.annotations.Url;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import io.github.com.pages.*;

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

	@Frame("#jdi-frame-site") public static HomePageFrame iframe;
	public static GithubPage githubPage;
}