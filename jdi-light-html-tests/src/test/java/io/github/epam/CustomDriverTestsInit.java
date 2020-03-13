package io.github.epam;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import io.github.com.StaticSite;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.driver.get.DriverInfos.*;
import static com.epam.jdi.light.elements.init.InitActions.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static io.github.com.StaticSite.*;

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
