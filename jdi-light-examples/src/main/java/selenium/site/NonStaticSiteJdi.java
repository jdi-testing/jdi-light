package selenium.site;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.entities.User;
import selenium.site.pages.ContactPage;
import selenium.site.pages.HomePage;
import selenium.site.pages.JDIPerformancePage;
import selenium.site.sections.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class NonStaticSiteJdi {

    public HomePage homePage;
    public ContactPage contactPage;
    public JDIPerformancePage performancePage;

    @FindBy(css = "form")
    public LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public WebElement profilePhoto;

    @FindBy(css = ".profile-photo [ui=label]")
    public WebElement userName;

    @FindBy(css = ".sidebar-menu [ui=label]")
    public WebList navigation;

    @Step("Login")
    public void login(User user) {
        if (!userName.isDisplayed()) {
            profilePhoto.click();
            loginForm.submit(user, "enter");
        }
    }
}
