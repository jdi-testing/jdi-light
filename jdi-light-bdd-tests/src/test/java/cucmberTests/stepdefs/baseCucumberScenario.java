package cucmberTests.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.com.StaticSite;

import java.io.IOException;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH_LOCATORS;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;

/**
 * Created by Dmitry_Lebedev1 on 1/13/2016.
 */
public class baseCucumberScenario {

//    @Before
//    public void before(){
//        logger.setLogLevel(INFO);
//        initElements(StaticSite.class);
//        homePage.open();
//        logger.toLog("Run Tests");
//        userIcon.click();
//        loginForm.loginAs(DEFAULT_USER);
//        homePage.checkOpened();
//    }
//
//    @After
//    public void after() {
//        killAllSeleniumDrivers();
//    }
}
