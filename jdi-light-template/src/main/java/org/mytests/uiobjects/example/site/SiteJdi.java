package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.pages.HomePage;
import org.mytests.uiobjects.example.site.pages.JDIPerformancePage;
import org.mytests.uiobjects.example.site.sections.LoginForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JSite("https://epam.github.io/JDI/")
public class SiteJdi {
    public static HomePage homePage;
    public static JDIPerformancePage jdiPerformancePage;
    @FindBy(css = "form") public static LoginForm loginForm;

    @FindBy(css = ".profile-photo") public static WebElement profilePhoto;
    @FindBy(css = ".profile-photo [ui=label]") public static WebElement userName;

    @FindBy(css = ".sidebar-menu [ui=label]")
    public static WebList navigation;

    @Step("Login")
    public static void login(User user) {
        if (!userName.isDisplayed()) {
            profilePhoto.click();
            loginForm.submit(user, "enter");
        }
    }
}
