package applitools.hackathon;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import applitools.hackathon.pages.ApplitoolsSite;
import com.epam.jdi.eyes.JDIEyes;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

import static applitools.hackathon.pages.ApplitoolsSite.loginPage;
import static com.epam.jdi.eyes.JDIEyes.*;
import static com.epam.jdi.mobile.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.mobile.elements.init.PageFactory.initSite;
import static com.epam.jdi.tools.PropertyReader.readProperties;

public class TestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        visualTestInit(ApplitoolsSite.class);
        if (readProperties().getProperty("environment").equals("V2"))
            loginPage.url = "https://demo.applitools.com/hackathonV2.html";
    }
    @BeforeMethod
    public void before(Method method) {
        newVisualTest(method);
    }
    @AfterSuite(alwaysRun = true)
    public static void teardown() {
        closeAllEyes();
        killAllSeleniumDrivers();
    }
}
