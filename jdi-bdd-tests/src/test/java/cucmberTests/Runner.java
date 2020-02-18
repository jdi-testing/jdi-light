package cucmberTests;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.com.StaticSite;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        , glue = {"com.epam.jdi.bdd", "cucmberTests"}
        , tags = {"@textarea"}
)
public class Runner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
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