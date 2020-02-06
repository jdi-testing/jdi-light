package selenium.seleniumPO;

import selenium.entities.User;

import static com.epam.jdi.mobile.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.mobile.elements.init.PageFactory.initElements;

public class SiteSelenium {
    public static HomePage homePage = initElements(getDriver(), HomePage.class);
    public static PerformancePage performancePage = initElements(getDriver(), PerformancePage.class);
    public static LoginForm loginForm = initElements(getDriver(), LoginForm.class);

    public static void login(User user) {
        if (!homePage.userName.isDisplayed()) {
            homePage.profilePhoto.click();
            loginForm.loginAs(user);
        }
    }
}
