package cucmberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

/**
 * Created by Dmitry_Lebedev1 on 1/22/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        , glue = {"com.epam.jdi.bdd", "cucmberTests"}
        , tags = {"@baselocator"}
)
public class Runner extends AbstractTestNGCucumberTests {
//    @BeforeClass
//    public static void setUp() {
//    	SMART_SEARCH_LOCATORS.add("[ui=%s]");
//        logger.setLogLevel(INFO);
//        initElements(StaticSite.class);
//        homePage.open();
//        logger.toLog("Run Tests");
//        userIcon.click();
//        loginForm.loginAs(DEFAULT_USER);
//    }

    @AfterClass
    public static void shutDown() {
        killAllSeleniumDrivers();
    }
}