package io.github.epam;

import com.epam.jdi.mobile.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.mobile.ui.html.elements.complex.DataListOptions;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pseudo.site.PseudoSite;

import static com.epam.jdi.mobile.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.mobile.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.mobile.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.mobile.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.mobile.elements.init.PageFactory.initSite;
import static com.epam.jdi.mobile.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        initSite(StaticSite.class);
        initSite(PseudoSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }


    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killAllSeleniumDrivers();
    }

    default boolean isFireFox() {
        return DRIVER_NAME.toLowerCase().equals("firefox");
    }
}
