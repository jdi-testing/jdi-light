package io.github.epam.html.tests.retry;

import io.github.epam.TestsInit;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.redButton;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class RetryTest implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.open();
    }
    //@Test
    public void passedTest() {
        redButton.click();
        validateAlert("Red button");
    }
    //@Test
    public void retryPassTest() {
        redButton.click();
        long time = System.currentTimeMillis();
        boolean fail = time % 2 == 0;
        log(time);
        log(fail);
        if (fail) {
            validateAlert("Red button2");
        } else {
            validateAlert("Red button");
        }
    }

    //@Test
    public void failedTest() {
        redButton.click();
        validateAlert("Red button2");
    }
    //@Step("{0}")
    public void log(Object status) {
        System.out.println(status);
    }
}
