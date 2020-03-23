package org.mytests.tests;

import org.junit.jupiter.api.*;
import org.mytests.uiobjects.example.site.SiteJdi;

import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;

public class TestsInit {
    private static boolean initialized = false;
    @BeforeAll
    public static void setUp() {
        if (initialized) return;
        initSite(SiteJdi.class);
        homePage.open();
        logger.info("Run Tests");
        initialized = true;
    }

    @AfterAll
    public static void teardown() {
        /*killAllSeleniumDrivers();*/
    }
}
