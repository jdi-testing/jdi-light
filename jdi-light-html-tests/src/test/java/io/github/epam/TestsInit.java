package io.github.epam;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import io.github.com.StaticSite;
import io.github.epam.testng.TestNGListener;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pseudo.site.PseudoSite;

import java.io.File;
import java.io.IOException;


@Listeners(TestNGListener.class)
public interface TestsInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        killAllSeleniumDrivers();
        initSite(StaticSite.class);
        initSite(PseudoSite.class);
        // todo delete
        System.out.println("!!! TMP FOR DEBUG capabilities.chrome: " + DRIVER.capabilities.chrome.get("arguments"));
        try {
            System.out.println("!!! TMP FOR DEBUG chrome.properties: " +
                    FileUtils.readFileToString(new File("src\\test\\resources\\chrome.properties"), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        homePage.open();
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    default void tearDown() {
        killAllSeleniumDrivers();
    }

    default boolean isFireFox() {
        return DRIVER.name.toLowerCase().equals("firefox");
    }
}
