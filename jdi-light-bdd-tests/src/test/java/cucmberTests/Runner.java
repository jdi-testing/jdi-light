package cucmberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.com.StaticSite;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH_LOCATORS;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;

/**
 * Created by Dmitry_Lebedev1 on 1/22/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        , glue = {"com.epam.jdi.bdd", "cucmberTests"}
//        , tags = {"@webpage"}
)
public class Runner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setUp() {
    	SMART_SEARCH_LOCATORS.add("[ui=%s]");
        logger.setLogLevel(INFO);
        initElements(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
    }

    @AfterClass
    public static void shutDown() {
        killAllSeleniumDrivers();
    }
}