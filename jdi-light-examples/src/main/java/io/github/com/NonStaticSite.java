package io.github.com;

import com.epam.jdi.light.common.CheckTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import io.github.com.pages.*;
import io.github.com.sections.LoginForm;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static io.github.epam.entities.Users.DEFAULT_USER;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class NonStaticSite {

    @Url("/index.html")
    @Title(value = "Home", validate = CheckTypes.CONTAINS)
    private HomePage homePage;

    @XPath("//*[@ui='label']")
    private UIElement userName;

    private WebElement userIcon;

    @Css("form")
    private LoginForm loginForm;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    private MetalAndColorsPage metalAndColorsPage;

    @Url(value = "/metals-colors.html{0}", template = "metals-colors.html")
    @Title("Metal and Colors")
    private MetalAndColorsPage metalAndColorsPageParams;

    @Url("/contacts.html")
    @Title(value = ".*tact \\w{4}", validate = CheckTypes.MATCH)
    private ContactFormPage contactFormPage;

    @Url("/performance.html")
    @Title("Performance page")
    private PerformancePage tablePage;

    @Url("/search.html")
    private SearchPage searchPage;

    @Css("[ui=label]")
    private List<WebElement> navigation;

    @Css("[ui=label]")
    private WebList navigationL;

    @UI("//*[@ui='label']//*[contains(text(),'%s')]")
    private WebList navigationS;

    @UI("//*[@ui='label']//*[contains(text(),'%s')]")
    private UIElement menu;

    @Css("header")
    private Header header;

    @Css("footer")
    private Footer footer;

    @Frame("iframe")
    private HomePageFrame iframe;

    private GithubPage githubPage;


    public static String getUrl() {

        return getDriver().getCurrentUrl();
    }

    public void login() {

        if (!getUserName().isDisplayed()) {
            getUserIcon().click();
            getLoginForm().submit(DEFAULT_USER, "enter");
        }
    }

    public void shouldBeLoggedIn() {

        if (!getUrl().contains("https://jdi-testing.github.io/jdi-light/"))
            getHomePage().open();

        login();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public MetalAndColorsPage getMetalAndColorsPage() {
        return metalAndColorsPage;
    }

    public MetalAndColorsPage getMetalAndColorsPageParams() {
        return metalAndColorsPageParams;
    }

    public ContactFormPage getContactFormPage() {
        return contactFormPage;
    }

    public PerformancePage getTablePage() {
        return tablePage;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public List<WebElement> getNavigation() {
        return navigation;
    }

    public WebList getNavigationL() {
        return navigationL;
    }

    public WebList getNavigationS() {
        return navigationS;
    }

    public UIElement getMenu() {
        return menu;
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public HomePageFrame getIframe() {
        return iframe;
    }

    public GithubPage getGithubPage() {
        return githubPage;
    }

    public UIElement getUserName() {
        return userName;
    }

    public WebElement getUserIcon() {
        return userIcon;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }
}
