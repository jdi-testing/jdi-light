package io.github.epam;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import io.github.epam.pages.ContactFormPage;
import io.github.epam.pages.HomePage;
import io.github.epam.pages.MetalAndColorsPage;
import io.github.epam.pages.PerformancePage;
import io.github.epam.sections.Footer;
import io.github.epam.sections.Header;
import io.github.epam.sections.NavigationSidebar;
import org.openqa.selenium.WebElement;

import java.util.List;

@JSite("https://epam.github.io/JDI/")
public class EpamGithubSite {
	@Url("/metals-colors.html") @Title("Metal and Colors")
	public static MetalAndColorsPage metalAndColorsPage;
	@Url("/contacts.html") @Title("Contact Form")
	public static ContactFormPage contactFormPage;
	@Url("/index.html") @Title("Home Page")
	public static HomePage homePage;
	@Url("/performance.html") @Title("Simple Table")
	public static PerformancePage tablePage;

	@Css(".sidebar-menu [ui=label]")
	public static List<WebElement> navigation;
	@Css(".sidebar-menu [ui=label]")
	public static WebList navigationL;

	@Css("header") public static Header header;
	@Css("footer") public static Footer footer;
	@Css(".uui-side-bar") public static NavigationSidebar navigationSidebar;
}