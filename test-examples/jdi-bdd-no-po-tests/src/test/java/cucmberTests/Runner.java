package cucmberTests;

import com.epam.jdi.light.elements.composite.*;
import cucmberTests.steps.User;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.*;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features"
    , glue = {"com.epam.jdi.bdd", "cucmberTests"}
    //, tags = {"@form"}
)
public class Runner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setUp() {
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
        $("img#user-icon").click();
        new Form<User>().submit(new User().set(u -> { u.name = "Roman"; u.password = "Jdi1234"; }));
    }
    @AfterClass
    public static void shutDown() {
        killAllSeleniumDrivers();
    }
}