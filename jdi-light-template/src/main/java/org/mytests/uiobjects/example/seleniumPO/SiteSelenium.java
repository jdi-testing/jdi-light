package org.mytests.uiobjects.example.seleniumPO;

import org.mytests.uiobjects.example.entities.User;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

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
