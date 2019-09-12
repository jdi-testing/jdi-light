package cucmberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.com.StaticSite;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.*;
import static io.github.com.StaticSite.loginForm;
import static io.github.com.StaticSite.userIcon;
import static io.github.com.entities.Users.DEFAULT_USER;

/**
 * Created by Roman Iovlev on 12.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        ,glue = {"com.epam.jdi.bdd", "cucmberTests"}
        //,tags = {"test"}
)
public class Runner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setup() {
        SMART_SEARCH_LOCATORS.add("[ui=%s]");
        initElements(StaticSite.class);
        openUrl(DOMAIN);
        logger.toLog("Run Tests");
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
    }

    @AfterClass
    public static void teardown() {
        killAllSeleniumDrivers();
    }

}