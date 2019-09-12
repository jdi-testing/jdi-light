package io.github.epam.html.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.base.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.settings.WebSettings.SMART_SEARCH_LOCATORS;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.com.pages.HtmlElementsPage.blueButton;
import static io.github.com.pages.HtmlElementsPage.ghostButton;
import static io.github.com.pages.HtmlElementsPage.redButton;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import io.github.com.pages.HomePage;
import io.github.com.pages.HtmlElementsPage;

public class TestsWithoutInitSite {
	
	@BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.setLogLevel(INFO);
        SMART_SEARCH_LOCATORS.add("[ui=%s]");
		initElements();
		HomePage.open();
        logger.toLog("Run Tests");
    }
	
	@BeforeMethod
	public void before() {
		userIcon.click();
		loginForm.loginAs(DEFAULT_USER);
		HtmlElementsPage.open();
	}

    @Test
    public void acceptAlertTest() {
        redButton.click();
        acceptAlert();
        blueButton.click();
        acceptAlert();
        refresh();
        ghostButton.click();
        acceptAlert();
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
