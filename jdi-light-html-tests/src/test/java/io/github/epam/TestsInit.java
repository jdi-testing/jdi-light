package io.github.epam;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import io.github.com.StaticSite;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pseudo.site.PseudoSite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        initSite(StaticSite.class);
        initSite(PseudoSite.class);
        homePage.checkOpened();
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
