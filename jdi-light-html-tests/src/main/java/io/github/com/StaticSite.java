package io.github.com;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.JMenu;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import io.github.com.custom.MenuItem;
import io.github.com.pages.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.CheckTypes.CONTAINS;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {
	@Url("/index.html") public static HomePage homePage;
	@Url("/metals-colors.html") @Title("Metal and Colors")
	public static MetalAndColorsPage metalAndColorsPage;
	@Url("/contacts.html") @Title("Contact Form")
	public static ContactFormPage contactFormPage;
	@Url(value = "/html5/%s", template = "/html5/+*", validate = CONTAINS)
	public static HtmlElementsPage htmlElementsPage2;
	@Url("/html5.html") public static HtmlElementsPage html5Page;
	@Url("/suspend-html-page.html") public static HtmlElementsPage suspendHtml5Page;
	@Url("/dates.html") @Title("Dates")
	public static DatesPage datesPage;
	@Url("/user-table.html") @Title("User Table")
	public static UsersPage usersPage;

	@Css("[ui=label]") public static List<WebElement> navigation;
	@Css("[ui=label]") public static WebList navigationL;
	@UI("[ui=label][*'%s']") public static WebList navigationS;
	@UI("//*[@class='sidebar-menu']//span/..//*[text()='%s']/../..") public static Menu leftMenu;
	//TODO
	//@UI(".sidebar-menu span<[*'%s']<<") public static Menu leftMenu;
	@UI("//*[@class='sidebar-menu']//span/..//*[text()='%s']/../..") public static WebList leftMenuList;
	//TODO
	//@UI(".sidebar-menu span<[*'%s']<<") public static WebList leftMenuList;
	@UI(".sidebar-menu span") public static JList<MenuItem> menu;
	@JMenu({"[ui=label][*'%s']", "[ui=label][*'%s']"}) public static Menu leftMenu2D;

	@Css("header") public static Header header;
	@Css("footer") public static Footer footer;

	@Frame("iframe") public static HomePageFrame iframe;
	public static GithubPage githubPage;
}