package com.epam.jdi.light.settings.unittests;

import com.epam.jdi.light.settings.CommonSettings;
import com.epam.jdi.light.settings.JDISettings;
import com.epam.jdi.light.settings.WebSettings;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.CommonSettings.getCommonSettings;
import static com.epam.jdi.light.settings.JDISettings.getJDISettings;
import static com.epam.jdi.light.settings.WebSettings.getWebSettings;
import static org.testng.Assert.*;

public class SettingsTests {
    private WebSettings webSettings;
    private JDISettings jdiSettings;
    private CommonSettings commonSettings;

    @BeforeTest
    public void initSettings() {
        webSettings = getWebSettings();
        commonSettings = getCommonSettings();
        jdiSettings = getJDISettings();
        webSettings.init();
    }

    @Test
    public void checkHasDomain() {
        webSettings.setDomain(null);
        assertFalse(webSettings.hasDomain());
        String testDomain = "invalidDomain";
        webSettings.setDomain(testDomain);
        assertFalse(webSettings.hasDomain());
        testDomain = "https://some-test.com";
        webSettings.setDomain(testDomain);
        assertTrue(webSettings.hasDomain());
    }

    @Test
    public void checkGetDomainMethod() {
        webSettings.setDomain(null);
        String errorMessage = "No Domain Found. Use test.properties or JDISettings.DRIVER.domain";
        String testDomain = "https://test.domain";
        assertEquals(webSettings.getDomain(), errorMessage);
        jdiSettings.DRIVER.domain = testDomain;
        assertEquals(webSettings.getDomain(), jdiSettings.DRIVER.domain);
    }

    @Test
    public void checkSetDomainMethod() {
        String testDomain = "https://my.test";
        webSettings.setDomain(testDomain);
        assertEquals(jdiSettings.DRIVER.domain, testDomain);
    }

    @Test
    public void checkInitPopulatesCommonSettingsStrategy() {
        assertNotNull(commonSettings.strategy);
        assertNotNull(commonSettings.killBrowser);
    }

    @Test
    public void checkInitPopulatesJDISettings() {
        assertNotNull(jdiSettings.TIMEOUTS.element);
        assertNotNull(jdiSettings.TIMEOUTS.page);
        assertNotNull(jdiSettings.DRIVER.name);
        assertNotNull(jdiSettings.DRIVER.version);
        assertNotNull(jdiSettings.DRIVER.path);
        assertNotNull(jdiSettings.DRIVER.screenSize);
        assertNotNull(jdiSettings.DRIVER.pageLoadStrategy);
        assertNotNull(jdiSettings.DRIVER.capabilities);
        assertNotNull(jdiSettings.SCREEN.path);
        assertNotNull(jdiSettings.LOGS.screenStrategy);
        assertNotNull(jdiSettings.LOGS.htmlCodeStrategy);
        assertNotNull(jdiSettings.LOGS.requestsStrategy);
        assertNotNull(jdiSettings.LOGS.logLevel);
        assertNotNull(jdiSettings.LOGS.writeToAllure);
        assertNotNull(jdiSettings.ELEMENT.smartName);
        assertNotNull(jdiSettings.ELEMENT.smartTemplate);
        assertNotNull(jdiSettings.ELEMENT.useSmartSearch);
    }

}
