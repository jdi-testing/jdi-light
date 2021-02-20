package androidtests.emulatorpower;

import android.AndroidEmulatorPower;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class EmulatorPowerInit {
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(AndroidEmulatorPower.class);
        logger.toLog("Run Emulator Power Tests");
        AppManager.launchApp();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }

}
