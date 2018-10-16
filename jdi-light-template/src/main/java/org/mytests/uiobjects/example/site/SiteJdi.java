package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import io.qameta.allure.Step;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.pages.HomePage;
import org.mytests.uiobjects.example.site.pages.JDIPerformancePage;
import org.mytests.uiobjects.example.site.sections.LoginForm;
import org.openqa.selenium.WebElement;

@JSite("https://epam.github.io/JDI/")
public class SiteJdi {
    public static HomePage homePage;
    public static JDIPerformancePage jdiPerformancePage;
    @Css("form") public static LoginForm loginForm;

    @Css(".profile-photo") public static WebElement profilePhoto;
    @Css(".profile-photo [ui=label]") public static WebElement userName;

    @Css(".sidebar-menu [ui=label]")
    public static WebList navigation;

    @Step("Login")
    public static void login(User user) {
        if (!userName.isDisplayed()) {
            profilePhoto.click();
            loginForm.submit(user, "enter");
        }
    }
}
