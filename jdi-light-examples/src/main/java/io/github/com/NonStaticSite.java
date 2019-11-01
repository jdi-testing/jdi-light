package io.github.com;

import com.epam.jdi.light.common.CheckTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import io.github.com.pages.*;
import io.github.com.sections.LoginForm;
import org.openqa.selenium.WebElement;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
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
