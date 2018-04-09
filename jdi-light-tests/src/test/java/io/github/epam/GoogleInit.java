package io.github.epam;

import com.epam.jdi.light.elements.init.PageFactory;
import com.google.GoogleSite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.logger.LogLevels.INFO;

public class GoogleInit  {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.setLogLevel(INFO);
        PageFactory.initElements(GoogleSite.class);
        GoogleSite.homePage.open();
        logger.info("Run Tests");
    }


}
