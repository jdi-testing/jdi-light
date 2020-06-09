package cucumberTests;

import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumberTests.test.data.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.form;
import static cucumberTests.test.data.TestData.ROMAN;

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