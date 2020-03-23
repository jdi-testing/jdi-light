package org.mytests.tests;

import com.epam.jdi.light.actions.ActionHelper;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.tools.*;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.testng.annotations.*;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.init.InitActions.*;
import static com.epam.jdi.light.elements.init.PageFactory.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mytests.tests.PerfStatistic.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;

public class TestsInit {
    public static Safe<Timer> TIMER = new Safe<>();
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        INTERFACES.update(IsCombobox.class, DataListOptions.class);
        initSite(SiteJdi.class);
        assertThat(TIMEOUTS.element.get(), is(5));
        assertThat(TIMEOUTS.page.get(), is(15));
        BEFORE_JDI_ACTION = jInfo -> {
            ActionHelper.beforeJdiAction(jInfo);
            TIMER.set(new Timer());
        };
        AFTER_JDI_ACTION = (jInfo, result) -> {
            addStatistic(jInfo.jp().getSignature().getName(), TIMER.get().timePassedInMSec());
            return ActionHelper.afterJdiAction(jInfo, result);
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
