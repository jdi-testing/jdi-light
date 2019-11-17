package applitools.hackathon;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import applitools.hackathon.pages.ApplitoolsSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.tools.PropertyReader.readProperties;

public class TestsInit {
    protected static String startUrl = "https://demo.applitools.com/hackathon.html";

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initSite(ApplitoolsSite.class);
        if (readProperties().getProperty("environment").equals("V2"))
            startUrl = "https://demo.applitools.com/hackathonV2.html";
    }
    @AfterSuite(alwaysRun = true)
    public static void teardown() {
        killAllSeleniumDrivers();
    }
}
