package io.github.epam;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.pageobjects.annotations.JPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import io.github.epam.pages.ContactFormPage;
import io.github.epam.pages.HomePage;
import io.github.epam.pages.MetalAndColorsPage;
import io.github.epam.sections.Footer;
import io.github.epam.sections.Header;
import io.github.epam.sections.NavigationSidebar;
import org.openqa.selenium.WebElement;

import java.util.List;

@JSite("https://epam.github.io/JDI/")
public class EpamGithubSite {
	@JPage(url = "/metals-colors.html", title = "Metal and Colors")
	public static MetalAndColorsPage metalAndColorsPage;
	@JPage(url = "/contacts.html", title = "Contact Form")
	public static ContactFormPage contactFormPage;
	@JPage(url = "/index.html", title = "Home Page")
	public static HomePage homePage;

	@Css(".sidebar-menu [ui=label]")
	public static List<WebElement> navigation;
	@Css(".sidebar-menu [ui=label]")
	public static UIList navigationL;

	@Css("header") public static Header header;
	@Css("footer") public static Footer footer;
	@Css(".uui-side-bar") public static NavigationSidebar navigationSidebar;
}