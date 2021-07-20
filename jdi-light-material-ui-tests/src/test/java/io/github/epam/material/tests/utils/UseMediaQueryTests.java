package io.github.epam.material.tests.utils;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.useMediaQueryPage;
import static io.github.com.pages.utils.UseMediaQueryPage.useMediaQueryText;
import static org.hamcrest.Matchers.containsString;

public class UseMediaQueryTests extends TestsInit {

    @BeforeMethod
    public void before() {
        useMediaQueryPage.open();
        useMediaQueryPage.shouldBeOpened();
    }

    @AfterMethod
    public void after() {
        WebDriverFactory.getDriver().manage().window().maximize();
    }

    @Test
    public void useMediaQueryTestWithDifferentScreenWidth() {
        new Timer(2000L)
                .wait(() -> useMediaQueryText.has().value(containsString("true")));
        WebDriverFactory.getDriver().manage().window().setSize(new Dimension(500, 1000));
        useMediaQueryText.has().value(containsString("false"));
        WebDriverFactory.getDriver().manage().window().setSize(new Dimension(700, 1000));
        useMediaQueryText.has().value(containsString("true"));
    }
}
