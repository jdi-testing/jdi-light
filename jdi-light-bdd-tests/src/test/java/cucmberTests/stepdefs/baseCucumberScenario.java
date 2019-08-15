package cucmberTests.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.com.StaticSite;

import java.io.IOException;

import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH_LOCATORS;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static io.github.com.StaticSite.homePage;

/**
 * Created by Dmitry_Lebedev1 on 1/13/2016.
 */
public class baseCucumberScenario {

    @Before
    public void before(){
        logger.setLogLevel(INFO);
        initElements(StaticSite.class);
        homePage.open();
        logger.toLog("Run Tests");
    }

    @After
    public void after() {
    }
}
