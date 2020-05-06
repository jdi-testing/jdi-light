package selenium.seleniumPO;

import com.epam.jdi.light.driver.WebDriverFactory;
import selenium.entities.User;

import static com.epam.jdi.light.driver.WebDriverFactory.getWebDriverFactory;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class SiteSelenium {
    private static final WebDriverFactory driverFactory = getWebDriverFactory();
    public static HomePage homePage = initElements(driverFactory.getDriver(), HomePage.class);
    public static PerformancePage performancePage = initElements(driverFactory.getDriver(), PerformancePage.class);
    public static LoginForm loginForm = initElements(driverFactory.getDriver(), LoginForm.class);

    public static void login(User user) {
        if (!homePage.userName.isDisplayed()) {
            homePage.profilePhoto.click();
            loginForm.loginAs(user);
        }
    }
}
