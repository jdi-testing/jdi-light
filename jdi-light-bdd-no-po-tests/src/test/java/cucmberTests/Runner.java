package cucmberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features"
    , glue = {"com.epam.jdi.bdd", "cucmberTests"}
    //, tags = {"@form"}
)
public class Runner extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void shutDown() {
        killAllSeleniumDrivers();
    }
}