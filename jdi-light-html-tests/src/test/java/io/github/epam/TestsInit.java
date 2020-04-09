package io.github.epam;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.composite.WebPage2;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.tools.func.JAction1;
import io.github.com.StaticSite;
import io.github.epam.html.tests.elements.common.FileUploadTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pseudo.site.PseudoSite;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.init.InitActions.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static io.github.com.StaticSite.*;

public interface TestsInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        killAllSeleniumDrivers();
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
        return DRIVER.name.toLowerCase().equals("firefox");
    }
}
