package cucmberTests;

import com.epam.jdi.mobile.elements.composite.Form;
import com.epam.jdi.mobile.elements.composite.WebPage;
import cucmberTests.steps.User;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.mobile.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.mobile.elements.init.UIFactory.$;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features"
    , glue = {"com.epam.jdi.bdd", "cucmberTests"}
    , tags = {"@form"}
)
public class Runner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setUp() {
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
        $("img#user-icon").click();
        new Form<User>().submit(new User().set(u -> {u.name = "Roman"; u.password = "Jdi1234"; }));
    }
    @AfterClass
    public static void shutDown() {
        killAllSeleniumDrivers();
    }
}