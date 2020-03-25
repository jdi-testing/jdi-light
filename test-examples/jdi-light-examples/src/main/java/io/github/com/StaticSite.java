package io.github.com;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.pages.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.CheckTypes.*;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {
	@Url("/index.html")  @Title(value = "Home", validate = CONTAINS)
	public static HomePage homePage;
	@Url("/metals-colors.html") @Title("Metal and Colors")
	public static MetalAndColorsPage metalAndColorsPage;
	@Url(value = "/metals-colors.html{0}", template = "metals-colors.html") @Title("Metal and Colors")
	public static MetalAndColorsPage metalAndColorsPageParams;
	@Url("/contacts.html") @Title(value = ".*tact \\w{4}", validate = MATCH)
	public static ContactFormPage contactFormPage;
	@Url("/performance.html") @Title("Performance page")
	public static PerformancePage tablePage;
	@Url("/search.html")
	public static SearchPage searchPage;

	@Css("[ui=label]") public static List<WebElement> navigation;
	@Css("[ui=label]") public static WebList navigationL;
	@UI("//*[@ui='label']//*[contains(text(),'%s')]") public static WebList navigationS;
	// TODO fix slow @UI("[ui=label][*'%s']") public static WebList navigationS;
	@UI("//*[@ui='label']//*[contains(text(),'%s')]") public static UIElement menu;
	// TODO fix slow @UI("[ui=label][*'%s']") public static UIElement menu;

	@Css("header") public static Header header;
	@Css("footer") public static Footer footer;

	@Frame("#jdi-frame-site") public static HomePageFrame iframe;
	@Frame("#first_frame") @UI("img")
	public static UIElement wolverinFrame;
	@Frame({"#second_frame", "#frame_in_frame"}) @UI("img")
	public static UIElement spidermanElement;
	@Frame({"#second_frame", "#frame_in_frame"})
	public static FrameSpiderman frameSpiderman;

	public static GithubPage githubPage;
}