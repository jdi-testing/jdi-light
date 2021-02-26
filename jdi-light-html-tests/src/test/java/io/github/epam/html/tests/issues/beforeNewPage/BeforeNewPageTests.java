package io.github.epam.html.tests.issues.beforeNewPage;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAndAcceptAlert;
import static com.epam.jdi.light.settings.JDISettings.PAGE;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.ghostButton;
import static io.github.com.pages.HtmlElementsPage.redButton;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class BeforeNewPageTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    final Timer timer= new Timer();
    @Test(enabled = false)
    public void withBeforeNewPage() {
        homePage.open();
        PAGE.beforeNewPage = page -> {
            WebPage.beforeNewPage(page);
            redButton.waitFor().displayed();
            logger.info("timer restart");
            timer.restart();
            ghostButton.waitFor().disappear();
            logger.info("ghost button hidden");
        };
        try {
            html5Page.open();
            logger.info("redbtn click");
            redButton.click();
            long time = timer.timePassedInMSec();
            logger.info(time + "");
            validateAndAcceptAlert("Red button");
            assertThat(time, greaterThan(2500L));
        } finally {
            PAGE.beforeNewPage = WebPage::beforeNewPage;
        }
    }

    @Test
    public void withoutBeforeNewPage() {
        homePage.open();
        html5Page.open();
        redButton.waitFor().displayed();
        timer.restart();
        redButton.click();
        long time = timer.timePassedInMSec();
        logger.info(time + "");
        validateAndAcceptAlert("Red button");
        assertThat(time, lessThan(1000L));
    }
}
