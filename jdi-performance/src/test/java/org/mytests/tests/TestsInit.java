package org.mytests.tests;

import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.TimeoutSettings.PAGE_TIMEOUT;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mytests.tests.PerfStatistic.*;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class TestsInit {
    public static Safe<Timer> TIMER = new Safe<>();
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        initSite(SiteJdi.class);
        assertThat(TIMEOUT.get(), is(5));
        assertThat(PAGE_TIMEOUT.get(), is(25));
        BEFORE_JDI_ACTION = jp -> {
            BEFORE_STEP_ACTION.execute(jp);
            processNewPage(jp);
            TIMER.set(new Timer());
        };
        AFTER_JDI_ACTION = (jp, result) -> {
            addStatistic(jp.getSignature().getName(), TIMER.get().timePassedInMSec());
            return AFTER_STEP_ACTION.execute(jp, result);
        };
        homePage.open();
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        System.out.println("Min: " + minTime() + "ms");
        System.out.println("Min Action: " + minAction());
        System.out.println("Max: " + maxTime() + "ms");
        System.out.println("Max Action: " + maxAction());
        System.out.println("Average: " + averageTime() + "ms");
        System.out.println("Actions Count: " + actionsCount());
        System.out.println("=== Statistic ===");
        printStatistic();
        killAllSeleniumDrivers();
    }
}
