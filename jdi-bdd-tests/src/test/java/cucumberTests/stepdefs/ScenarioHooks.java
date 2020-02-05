package cucumberTests.stepdefs;

import com.epam.jdi.light.settings.WebSettings;
import cucumber.api.java.Before;
import io.github.com.StaticSite;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.com.pages.Header.userName;

public class ScenarioHooks {
    @Before
    public static void setUp() {
        WebSettings.init();
        initElements(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");

        if (userName.isHidden()) {
            if (loginForm.isHidden()) {
                userIcon.click();
            }
            loginForm.submit(DEFAULT_USER);
        }
    }
}

