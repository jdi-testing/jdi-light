package io.github.com;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import io.github.com.custom.MenuItem;
import io.github.com.pages.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.CheckTypes.*;

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
	@Url("/simple-table.html") @Title("Simple Table")
	public static SimpleTablePage tablePage;
	@Url("/performance.html") @Title("Performance page")
	public static PerformancePage performancePage;

	@Css("[ui=label]") public static List<WebElement> navigation;
	@Css("[ui=label]") public static WebList navigationL;
	@Css("[ui=label]") public static UIElement navigationElement;
	@UI("//*[@ui='label']//*[contains(text(),'%s')]") public static WebList navigationS;
	//TODO
	//@UI("[ui=label][*'%s']") public static WebList navigationS;
	@UI(".sidebar-menu li") public static Menu leftMenu;
	//TODO
	//@UI(".sidebar-menu span<[*'%s']<<") public static Menu leftMenu;
	@UI("//*[@class='sidebar-menu']//span/..//*[text()='%s']/../..") public static WebList leftMenuList;
	//TODO
	//@UI(".sidebar-menu span<[*'%s']<<") public static WebList leftMenuList;
	@UI(".sidebar-menu span") public static JList<MenuItem> menu;
	@JMenu({"[ui=label][*'%s']", "[ui=label][*'%s']"}) public static Menu leftMenu2D;

	@Css("header") public static Header header;
	@Css("footer") public static Footer footer;

	@Frame("#jdi-frame-site") public static HomePageFrame iframe;
	public static GithubPage githubPage;
}