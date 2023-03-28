package nativeapp_ios;

import com.epam.jdi.light.driver.WebDriverFactory;
import nativeapp.ios.photos.PhotosApp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class PhotosAppTestInit {
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(PhotosApp.class);
        logger.toLog("Run Photos App Tests");
    }

    @BeforeMethod(alwaysRun = true)
    public void continueThroughWelcomePage() {
        if (PhotosApp.continueButton.isDisplayed())
            PhotosApp.continueButton.click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }
}
