package io.github.epam;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.mobile.ui.html.elements.complex.DataListOptions;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverInfos.FF_INFO;
import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.settings.WebSettings.useDriver;
import static io.github.com.StaticSite.homePage;

public class CustomDriverTestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        useDriver(() -> FF_INFO.getDriver() );
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        initSite(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }

}
