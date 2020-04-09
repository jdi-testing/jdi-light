package nativeApp.contacts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class ContactsTests {

    @BeforeClass(alwaysRun = true)
    public static void setUp() {
        initElements(StaticApp.class);
        logger.toLog("Run Tests");
    }

    @Test
    public void selectPhoneTypeTest(){
        StaticApp.mainPage.createNewContact();
        //newContactPage.checkOpened();
        StaticApp.newContactPage.fillInNewContactInformation();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
