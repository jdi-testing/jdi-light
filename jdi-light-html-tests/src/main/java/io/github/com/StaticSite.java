package io.github.com;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.annotations.JMenu;
import com.epam.jdi.light.ui.html.elements.annotations.NoInheritance;
import com.epam.jdi.light.ui.html.elements.complex.Menu2D;
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
	@Url("/html5.html") public static HtmlElementsPage html5Page;
	@Url("/suspend-html-page.html") public static WebPage suspendHtml5Page;
	@Url(value = "/html5/%s", template = "/html5/+*", validate = CONTAINS)
	public static WebPage htmlElementsPage2;
	@Url("/dates.html") @Title("Dates")
	public static DatesPage datesPage;
	@Url("/user-table.html") @Title("User Table")
	public static UsersPage usersPage;
	@Url("/simple-table.html") @Title("Simple Table")
	public static SimpleTablePage tablePage;
	@Url("/performance.html") @Title("Performance page")
	public static PerformancePage performancePage;
	@Url("/search.html")
	public static SearchPage searchPage;

	@Css("[ui=label]") public static List<WebElement> navigation;
	@Css("[ui=label]") public static webList navigationL;
	@Css("[ui=label]") public static UIElement navigationElement;
	@WaitAfterAction
	@UI("//*[@ui='label']//*[contains(text(),'%s')]") public static webList navigationS;
	//TODO
	//@UI("[ui=label][*'%s']") public static WebList navigationS;
	@UI(".sidebar-menu [ui=label]") public static Menu leftMenu;
	//TODO
	//@UI(".sidebar-menu span<[*'%s']<<") public static Menu leftMenu;
	@UI("//*[@class='sidebar-menu']//span/..//*[text()='%s']/../..") public static webList leftMenuList;
	//TODO
	//@UI(".sidebar-menu span<[*'%s']<<") public static WebList leftMenuList;
	@UI(".sidebar-menu span") public static JList<MenuItem> menu;
	@NoInheritance
	@JMenu({"[ui=label][*'%s']", "[ui=label][*'%s']"}) public static Menu2D leftMenu2D;
	@JMenu({"[ui=label] span", "../..//ul//li[@ui='label']"}) public static Menu2D menu2D;

	@Css("header") public static Header header;
	@Css("footer") public static Footer footer;

	@Frame("#jdi-frame-site") public static HomePageFrame iframe;
	public static GithubPage githubPage;
}