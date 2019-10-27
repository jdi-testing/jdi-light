package io.github.com;

import com.epam.jdi.light.common.CheckTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.pages.*;
import org.openqa.selenium.WebElement;
import java.util.List;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class NonStaticSite {

    @Url("/index.html")  @Title(value = "Home", validate = CheckTypes.CONTAINS)
    public HomePage homePage;
    @Url("/metals-colors.html") @Title("Metal and Colors")
    public MetalAndColorsPage metalAndColorsPage;
    @Url(value = "/metals-colors.html{0}", template = "metals-colors.html") @Title("Metal and Colors")
    public MetalAndColorsPage metalAndColorsPageParams;
    @Url("/contacts.html") @Title(value = ".*tact \\w{4}", validate = CheckTypes.MATCH)
    public ContactFormPage contactFormPage;
    @Url("/performance.html") @Title("Performance page")
    public PerformancePage tablePage;
    @Url("/search.html")
    public SearchPage searchPage;

    @Css("[ui=label]") public List<WebElement> navigation;
    @Css("[ui=label]") public WebList navigationL;
    @UI("//*[@ui='label']//*[contains(text(),'%s')]") public WebList navigationS;
    // TODO fix slow @UI("[ui=label][*'%s']") public static WebList navigationS;
    @UI("//*[@ui='label']//*[contains(text(),'%s')]") public UIElement menu;
    // TODO fix slow @UI("[ui=label][*'%s']") public static UIElement menu;

    @Css("header") public Header header;
    @Css("footer") public Footer footer;

    @Frame("iframe") public HomePageFrame iframe;
    public GithubPage githubPage;
}
