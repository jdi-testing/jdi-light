package io.github.epam.testng;

import com.epam.jdi.light.mobile.settings.MobileSettings;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        MobileSettings.setup();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        killAllSeleniumDrivers();
    }
}
