package selenium.site;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.entities.User;
import selenium.site.pages.*;
import selenium.site.sections.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    public static HomePage homePage;
    public static ContactPage contactPage;
    public static JDIPerformancePage performancePage;
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
