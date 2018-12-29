package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import io.qameta.allure.Step;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.pages.ContactFormPage;
import org.mytests.uiobjects.example.site.pages.ContactsPage;
import org.mytests.uiobjects.example.site.pages.HomePage;
import org.mytests.uiobjects.example.site.pages.JDIPerformancePage;
import org.openqa.selenium.WebElement;

//@JSite("https://epam.github.io/JDI/")
public class SiteJdi {
    public static HomePage homePage;
    public static JDIPerformancePage performancePage;
    public static ContactFormPage contactFormPage;
    public static ContactsPage contactsPage;
    @Css("form") public static Form<User> loginForm;

    @Css(".profile-photo [ui=label]") public static WebElement userName;
    @Css(".fa-sign-out") public static WebElement logout;
    @Css("img#user-icon") public static WebElement userIcon;

    @Css(".sidebar-menu [ui=label]")
    public static WebList navigation;

    @Step
    public static void shouldBeLoggedIn() {
        if (!WebPage.getUrl().contains("https://epam.github.io/JDI/"))
            homePage.open();
        if (!userName.isDisplayed())
            login();
    }
    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(new User(), "enter");
    }
    @Step
    public static void shouldBeLoggedOut() {
        if (!WebPage.getUrl().contains("https://epam.github.io/JDI/"))
            homePage.open();
        if (userName.isDisplayed())
            logout();
    }
    @Step
    public static void logout() {
        userIcon.click();
        logout.click();
    }
}
