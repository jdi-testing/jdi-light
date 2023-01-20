package io.github.epam.material.tests.utils;

import static io.github.com.StaticSite.useMediaQueryPage;
import static io.github.com.pages.utils.UseMediaQueryPage.useMediaQueryText;
import static org.hamcrest.Matchers.containsString;

import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UseMediaQueryTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        useMediaQueryPage.open();
        useMediaQueryPage.shouldBeOpened();
    }

    @Test
    public void useMediaQueryTestWithDifferentScreenWidth() {
        useMediaQueryText.has().value(containsString("true"));
        useMediaQueryPage.driver().manage().window().setSize(new Dimension(500, 1000));
        useMediaQueryText.has().value(containsString("false"));
        useMediaQueryPage.driver().manage().window().setSize(new Dimension(700, 1000));
        useMediaQueryText.has().value(containsString("true"));
    }

    @AfterMethod
    public void after() {
        useMediaQueryPage.driver().manage().window().setSize(new Dimension(1920, 1080));
    }
}
