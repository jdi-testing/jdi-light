package org.mytests.tests;

import org.mytests.uiobjects.example.site.SiteJdi;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static com.epam.jdi.eyes.JDIEyes.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;

public class TestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initSite(SiteJdi.class);
        visualTestInitJdi();
        homePage.open();
        logger.info("Run Tests");
    }
    @BeforeMethod
    public void before(Method method) {
        newVisualTest(method);
    }
    @AfterSuite(alwaysRun = true)
    public static void teardown() {
        closeAllEyes();
    }
}
