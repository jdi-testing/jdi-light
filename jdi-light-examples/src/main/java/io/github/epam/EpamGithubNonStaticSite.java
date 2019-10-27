package io.github.epam;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import io.github.epam.pages.*;
import io.github.epam.sections.Footer;
import io.github.epam.sections.Header;
import org.openqa.selenium.WebElement;

import java.util.List;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class EpamGithubNonStaticSite {

    @Url("/index.html")
    public HomePage homePage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public MetalAndColorsPage metalAndColorsPage;

    @Url("/contacts.html")
    @Title("Contact Form")
    public ContactFormPage contactFormPage;

    @Url("/performance.html")
    @Title("Performance page")
    public PerformancePage tablePage;

    @Url("/complex-table.html")
    @Title("Complex Table")
    public WebPage complextablePage;

    @Css("[ui=label]")
    public List<WebElement> navigation;

    @Css("[ui=label]")
    public WebList navigationL;

    @Css("header")
    public Header header;

    @Css("footer")
    public Footer footer;

    @Frame("iframe")
    public HomePageFrame iframe;

    public GithubPage githubPage;
}