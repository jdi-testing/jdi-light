package nativeApp.calculator;

import org.testng.Assert;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class CalculatorTests {

    private static MainPage mainPage;

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        mainPage = new MainPage();
        logger.toLog("Run Tests");
    }

    @Test
    public void checkAdditionTest() {
        double result = mainPage.addition();
        Assert.assertEquals(9.0, result);
    }

    @Test
    public void checkAdditionRealNumberTest() {
        double result = mainPage.additionReal();
        Assert.assertEquals(4.1, result);
    }

    @AfterTest
    public void clearDisplay() {
        mainPage.clearDisplay();
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}