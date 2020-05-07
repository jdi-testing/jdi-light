package cucmberTests;

import com.epam.jdi.light.elements.composite.WebPage;
import cucmberTests.test.data.User;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static cucmberTests.test.data.TestData.*;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features"
    , glue = {"com.epam.jdi.bdd", "cucmberTests"}
    , tags = {"@form"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setUp() {
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
        $("img#user-icon").click();
        form("#login-form", User.class).submit(ROMAN);
    }
    @AfterClass
    public static void shutDown() {
        killAllSeleniumDrivers();
    }
}