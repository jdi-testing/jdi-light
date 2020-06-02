package cucumberTests;

import com.epam.jdi.light.elements.composite.WebPage;
import cucumberTests.test.data.User;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static cucumberTests.test.data.TestData.*;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features"
    , glue = {"com.epam.jdi.bdd", "cucumberTests"}
    , tags = {"@form"}
)
public class TestRunner {
    @BeforeClass
    public static void setUp() {
        killAllSeleniumDrivers();
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
        $("img#user-icon").click();
        form("#login-form", User.class).submit(ROMAN);
    }
    @AfterClass
    public static void shutDown() {
        killAllSeleniumDrivers();
    }
}