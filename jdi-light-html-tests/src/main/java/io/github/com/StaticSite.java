package io.github.com;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.JMenu;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.base.HtmlList;
import com.epam.jdi.light.ui.html.complex.Menu;
import io.github.com.custom.MenuItem;
import io.github.com.pages.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.CheckTypes.CONTAINS;

@JSite("https://epam.github.io/JDI/")
public class StaticSite {
	@Url("/index.html") public static HomePage homePage;
	@Url("/metals-colors.html") @Title("Metal and Colors")
	public static MetalAndColorsPage metalAndColorsPage;
	@Url("/contacts.html") @Title("Contact Form")
	public static ContactFormPage contactFormPage;
	@Url(value = "/html5/%s", template = "/html5/+*", validate = CONTAINS) public static HtmlElementsPage htmlElementsPage2;
	@Url("/html5.html") public static HtmlElementsPage html5Page;
	@Url("/dates.html") @Title("Dates") public static DatesPage datesPage;

	@Css("[ui=label]") public static List<WebElement> navigation;
	@Css("[ui=label]") public static HtmlList navigationL;
	@UI("[ui=label][*'%s']") public static HtmlList navigationS;
	@UI(".sidebar-menu span<[*'%s']") public static Menu leftMenu;
	@UI(".sidebar-menu span") public static WebList<MenuItem> menu;
	@JMenu({"[ui=label][*'%s']", "[ui=label][*'%s']"}) public static Menu leftMenu2D;

	@Css("header") public static Header header;
	@Css("footer") public static Footer footer;

	@Frame("iframe") public static HomePageFrame iframe;
	public static GithubPage githubPage;
}