package nativeapp.contacts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.mobile.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.contacts.StaticNativeApp.mainPage;
import static nativeapp.contacts.StaticNativeApp.newContactPage;

public class ContactsTests {

    @BeforeClass(alwaysRun = true)
    public static void setUp() {
        initElements(StaticNativeApp.class);
        logger.toLog("Run Tests");
    }

    @Test
    public void selectPhoneTypeTest(){
        mainPage.createNewContact();
        //newContactPage.checkOpened();
        newContactPage.fillInNewContactInformation();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
