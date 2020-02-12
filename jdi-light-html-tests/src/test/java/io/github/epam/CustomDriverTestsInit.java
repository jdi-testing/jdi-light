package io.github.epam;

import com.epam.jdi.mobile.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.mobile.ui.html.elements.complex.DataListOptions;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.mobile.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.mobile.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.mobile.elements.init.PageFactory.initSite;
import static com.epam.jdi.mobile.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;

//import static com.epam.jdi.mobile.driver.get.DriverInfos.FF_INFO;

public class CustomDriverTestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
//        useDriver(() -> FF_INFO.getDriver() );
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
